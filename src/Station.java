public class Station
{
    public String name;
    public boolean visited = false;

    public Station(String name)
    {
        this.name = name;
    }

    public Station()
    {
        this.name = "midpoint";
    }
}
