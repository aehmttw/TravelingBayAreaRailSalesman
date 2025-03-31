import java.util.ArrayList;
import java.util.HashMap;

public class Line
{
    public String name;
    public ArrayList<Stop> stops = new ArrayList<>();
    public HashMap<Station, Stop> stopsByStation;

    public Line(String name)
    {
        this.name = name;
    }

    public static class Stop
    {
        public Station station;
        public boolean midpoint;
        public Line[] connections;

        public Stop(Station s, boolean midpoint, Line[] connections)
        {
            this.station = s;
            this.midpoint = midpoint;
            this.connections = connections;
        }
    }

    public Line addStop(Station s)
    {
        Stop st = new Stop(s, false, new Line[0]);
        this.stops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }

    public Line addMStop(Station s)
    {
        Stop st = new Stop(s, true, new Line[0]);
        this.stops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }

    public Line addStop(Station s, Line... connections)
    {
        Stop st = new Stop(s, false, connections);
        this.stops.add(st);
        this.stopsByStation.put(s, st);
        return this;
    }
}
