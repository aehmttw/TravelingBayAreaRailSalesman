import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Line
{
    public String name;
    public ArrayList<Stop> stops = new ArrayList<>();
    public ArrayList<Stop> interestingStops = new ArrayList<>();
    public HashMap<Station, Stop> stopsByStation = new HashMap<>();
    public HashMap<String, Stop> stopsByInternalName = new HashMap<>();

    public boolean isWalk = false;
    public int walkTime = 0;

    public static ArrayList<Line> lines = new ArrayList<>();

    public Line(String name)
    {
        this.name = name;
        lines.add(this);
    }

    public static class Stop
    {
        public Station station;
        public int index;
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
            return station.name + "/" + line.name;
        }

        public boolean isTerminus()
        {
            return this.index == 0 || this.index == this.line.stops.size() - 1;
        }
    }

    public Line addStop(Station s)
    {
        Stop st = new Stop(this, s, false, new Line[0]);
        st.index = this.stops.size();
        this.stops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }

    public Line addMStop(Station s)
    {
        Stop st = new Stop(this, s, true, new Line[0]);
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
        this.stopsByStation.put(s, st);
        return this;
    }

    public void readTimetable(String forward, String days, String file)
    {
        readTimetable(forward, forward, days, file);
    }

    public void readTimetable(String forward, String back, String days, String file)
    {
        boolean reading = false;
        boolean direction = false;

        Scanner scan = new Scanner(getClass().getResourceAsStream("data/" + file));

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
//                System.out.println(sections[0] + stopsByInternalName);
                if (st == null)
                {
//                    System.out.println(forward + " didn't find stop " + sections[0]);
                    continue;
                }

//                System.out.println(st + " " + direction);

                if (direction)
                {
                    if (st.departureTimesForward == null)
                        st.departureTimesForward = new int[sections.length - 2];

                    int prev = -1;
                    for (int i = 2; i < sections.length; i++)
                    {
                        if (sections[i].equals("null"))
                            st.departureTimesForward[i - 2] = prev;
                        else
                            st.departureTimesForward[i - 2] = Integer.parseInt(sections[i]);

                        prev = st.departureTimesForward[i - 2];
                    }
                }
                else
                {
                    if (st.departureTimesBack == null)
                        st.departureTimesBack = new int[sections.length - 2];

                    int prev = -1;
                    for (int i = 2; i < sections.length; i++)
                    {
                        if (sections[i].equals("null"))
                            st.departureTimesBack[i - 2] = prev;
                        else
                            st.departureTimesBack[i - 2] = Integer.parseInt(sections[i]);

                        prev = st.departureTimesBack[i - 2];
                    }
                }
            }
        }
    }

    public void setWalk(int time)
    {
        this.isWalk = true;
        this.walkTime = time * 60;
    }
}
