import java.util.ArrayList;
import java.util.HashMap;

public class Station
{
    public static HashMap<String, Station> stationsByName = new HashMap<>();
    public static ArrayList<Station> allStations = new ArrayList<>();

    public String name;
    public String[] internalNames;

    public boolean explored = false;
    public boolean midpoint = false;

    public Station(String name, String... otherNames)
    {
        this.name = name;
        this.internalNames = otherNames;
        stationsByName.put(name, this);
        allStations.add(this);
    }

    public Station(String name, boolean mid)
    {
        this.name = name;
        allStations.add(this);

        if (mid)
            midpoint = true;
    }
}
