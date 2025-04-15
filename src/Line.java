import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Line
{
    public String name;
    public ArrayList<OfficialStop> officialStops = new ArrayList<>();
    public ArrayList<Stop> stops = new ArrayList<>();
    public ArrayList<Stop> interestingStops = new ArrayList<>();
    public HashMap<Station, Stop> stopsByStation = new HashMap<>();
    public HashMap<String, Stop> stopsByInternalName = new HashMap<>();

    public String timetableForwardName;
    public String timetableBackName;
    public String timetableDays;
    public String timetableFile;

    public int colorR = 127;
    public int colorG = 127;
    public int colorB = 127;

    public boolean isWalk = false;
    public int walkTime = 0;

    public static ArrayList<Line> lines = new ArrayList<>();
    public static HashMap<String, Line> linesByName = new HashMap<>();

    public Line(String name)
    {
        this.name = name;
        lines.add(this);
        linesByName.put(this.name, this);
    }

    public static class OfficialStop
    {
        public int stopIndex = -1;
        public int index;

        public double longitude;
        public double latitude;
        public String name;

        public boolean explored = false;

        public OfficialStop(String name, double lon, double lat)
        {
            this.name = name;
            this.latitude = lat;
            this.longitude = lon;
        }
    }

    public static class Stop
    {
        public Station station;
        public int index;
        public int officialStopIndex;
        public boolean midpoint;
        public Line line;
        public Line[] connections;

        public int[] departureTimesForward;
        public int[] departureTimesBack;

        public int bfsIndex = 0;
        public Stop bfsFrom = null;
        public int bfsTime = Integer.MAX_VALUE;

        public Stop(Line l, Station s, boolean midpoint, Line[] connections)
        {
            this.line = l;
            this.station = s;
            this.midpoint = midpoint;
            this.connections = connections;

            if (this.station.internalNames != null)
            {
                for (String n : this.station.internalNames)
                {
                    this.line.stopsByInternalName.put(n, this);
                }
            }
        }

        public String toString()
        {
            return "(" + station.region.id + ")" + station.name + "/" + line.name;
        }

        public boolean isTerminus()
        {
            return this.index == 0 || this.index == this.line.stops.size() - 1;
        }
    }

    public Line addStop(Station s)
    {
        Stop st = new Stop(this, s, false, new Line[0]);
        assert !s.midpoint;
        st.index = this.stops.size();
        this.stops.add(st);
        this.interestingStops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }

    public Line addMStop(Station s)
    {
        Stop st = new Stop(this, s, true, new Line[0]);
        assert s.midpoint;
        st.index = this.stops.size();
        this.stops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }

    public Line addStop(Station s, Line... connections)
    {
        Stop st = new Stop(this, s, false, connections);
        st.index = this.stops.size();
        this.stops.add(st);
        this.interestingStops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }

    public void readTimetable(String forward, String days, String file)
    {
        readTimetable(forward, forward, days, file);
    }

    public void readTimetable(String forward, String back, String days, String file)
    {
        this.timetableForwardName = forward;
        this.timetableBackName = back;
        this.timetableDays = days;
        this.timetableFile = "data/" + file;

        boolean reading = false;
        boolean direction = false;

        Scanner scan = new Scanner(getClass().getResourceAsStream(this.timetableFile));

        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] sections = line.split(",");
            if (sections.length == 1)
            {
                String[] spec = line.split("/");
                if (!spec[4].contains(days))
                {
                    reading = false;
                    continue;
                }

                if (spec[0].equals(forward) && spec[1].equals("1"))
                {
                    reading = true;
                    direction = true;

                    this.colorR = Integer.parseInt(spec[5]);
                    this.colorG = Integer.parseInt(spec[6]);
                    this.colorB = Integer.parseInt(spec[7]);
                }
                else if (spec[0].equals(back) && spec[1].equals("0"))
                {
                    reading = true;
                    direction = false;
                }
                else
                    reading = false;
            }
            else if (reading)
            {
                Stop st = stopsByInternalName.get(sections[0]);

                if (direction)
                {
                    OfficialStop os = new OfficialStop(sections[1], Double.parseDouble(sections[2]), Double.parseDouble(sections[3]));
                    os.index = officialStops.size();
                    officialStops.add(os);
                }

//                System.out.println(sections[0] + stopsByInternalName);
                if (st == null)
                {
//                    System.out.println(forward + " didn't find stop " + sections[0]);
                    continue;
                }

//                System.out.println(st + " " + direction);

                int start = 4;
                if (direction)
                {
                    officialStops.get(officialStops.size() - 1).stopIndex = st.index;
                    st.officialStopIndex = officialStops.size() - 1;

                    if (st.departureTimesForward == null)
                        st.departureTimesForward = new int[sections.length - start];

                    int prev = -1;
                    for (int i = start; i < sections.length; i++)
                    {
                        if (sections[i].equals("null"))
                            st.departureTimesForward[i - start] = prev;
                        else
                            st.departureTimesForward[i - start] = Integer.parseInt(sections[i]);

                        prev = st.departureTimesForward[i - start];
                    }

//                    System.out.println(st + " -> " + st.departureTimesForward.length);
                }
                else
                {
                    if (st.departureTimesBack == null)
                        st.departureTimesBack = new int[sections.length - start];

                    int prev = -1;
                    for (int i = start; i < sections.length; i++)
                    {
                        if (sections[i].equals("null"))
                            st.departureTimesBack[i - start] = prev;
                        else
                            st.departureTimesBack[i - start] = Integer.parseInt(sections[i]);

                        prev = st.departureTimesBack[i - start];
                    }

//                    System.out.println(st + " <- " + st.departureTimesBack.length);
                }
            }
        }
    }

    public void printTimetable()
    {
        System.out.println("Direction A");
        for (Stop s: this.stops)
        {
            if (s.midpoint)
                continue;

            System.out.printf("%20s", s.station.name);
            for (int i: s.departureTimesForward)
                System.out.printf("%8d", i);
            System.out.println();
        }
        System.out.println("Direction B");
        for (Stop s: this.stops)
        {
            if (s.midpoint)
                continue;

            System.out.printf("%16s", s.station.name);
            for (int i: s.departureTimesBack)
                System.out.printf("%8d", i);
            System.out.println();
        }
    }

    public void verifyTimetable()
    {
        System.out.println("validating: " + this.name);
        for (int i = 0; i < interestingStops.size() - 1; i++)
        {
            Stop prev = interestingStops.get(i);
            Stop next = interestingStops.get(i + 1);

            for (int f = 0; f < prev.departureTimesForward.length; f++)
            {
                if (!((prev.departureTimesForward[f] <= next.departureTimesForward[f]) || next.departureTimesForward[f] == -1 || (f != 0 && next.departureTimesForward[f - 1] == next.departureTimesForward[f])))
                    throw new RuntimeException("Validation failed: " + this.name + " " + prev + "(" + prev.departureTimesForward[f] + ")" + " -> " + next + "(" + next.departureTimesForward[f] + ")");
            }

            for (int f = 0; f < prev.departureTimesBack.length; f++)
            {
                if (!((prev.departureTimesBack[f] >= next.departureTimesBack[f]) || next.departureTimesBack[f] == -1 || (f != 0 && next.departureTimesBack[f - 1] == next.departureTimesBack[f])))
                    throw new RuntimeException("Validation failed: " + this.name + " " +  prev + "(" + prev.departureTimesBack[f] + ")" + " <- " + next + "(" + next.departureTimesBack[f] + ")");
            }
        }
    }

    public void setWalk(int time)
    {
        this.isWalk = true;
        this.walkTime = time * 60;

        Stop c1 = this.stops.get(0).connections[0].stopsByStation.get(this.stops.get(0).station);
        Stop c2 = this.stops.get(1).connections[0].stopsByStation.get(this.stops.get(1).station);

        OfficialStop o1 = new OfficialStop(this.stops.get(0).station.name, c1.line.officialStops.get(c1.officialStopIndex).longitude, c1.line.officialStops.get(c1.officialStopIndex).latitude);
        OfficialStop o2 = new OfficialStop(this.stops.get(1).station.name, c2.line.officialStops.get(c2.officialStopIndex).longitude, c2.line.officialStops.get(c2.officialStopIndex).latitude);
        o1.stopIndex = 0;
        o2.stopIndex = 1;
        this.stops.get(0).officialStopIndex = 0;
        this.stops.get(1).officialStopIndex = 1;

        this.officialStops.add(o1);
        this.officialStops.add(o2);

    }
}
