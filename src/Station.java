import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Station
{
    public static class Region
    {
        public static ArrayList<Region> regions = new ArrayList<>();

        public HashSet<Station> stations = new HashSet<>();
        public String id;

        public Region(String id)
        {
            regions.add(this);
            this.id = id;
        }
    }

    public static HashMap<String, Station> stationsByName = new HashMap<>();
    public static ArrayList<Station> allStations = new ArrayList<>();

    public String name;
    public String[] internalNames;

    public boolean explored = false;
    public boolean midpoint = false;

    public Region region;

    public Station(Region r, String name, String... otherNames)
    {
        this.region = r;
        this.name = name;
        this.internalNames = otherNames;
        stationsByName.put(name, this);
        allStations.add(this);
    }

    public Station(Region r, String name, boolean mid)
    {
        this.region = r;
        this.name = name;
        allStations.add(this);

        if (mid)
            midpoint = true;
    }
}
