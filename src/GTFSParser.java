import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GTFSParser
{
    public static final String folder = "bart";
    public static final boolean format_time = true;

    public static void parseStops(Scanner sc, HashMap<String, String> stopsMap, LinkedHashSet<String> stopNames, HashMap<String, String> stopNameTranslation)
    {
        System.out.println("Parsing stops...");

        String[] stopKeys;
        String l = sc.nextLine().trim().replace("\ufeff", "");
        stopKeys = l.replace("\"", "").split(",");

        int id_index1 = -1;
        int stop_name = -1;
        int stop_name2 = -1;

        for (int i = 0; i < stopKeys.length; i++)
        {
            switch (stopKeys[i])
            {
                case "parent_station" -> stop_name = i;
                case "stop_name" -> stop_name2 = i;
                case "stop_id" -> id_index1 = i;
            }
        }

        while (sc.hasNext())
        {
            String s = sc.nextLine().replace("\ufeff", "").replace("\"", "");

            if (s.equals("done"))
                break;
            String[] p = s.split(",");

            if (stop_name < 0)
                stop_name = stop_name2;

            if (id_index1 >= p.length || stop_name >= p.length)
                continue;

            String name = p[stop_name];
            if (name.isEmpty())
                name = p[stop_name2];

            stopsMap.put(p[id_index1], name);
            stopNameTranslation.put(name, p[stop_name2]);
            stopNames.add(name);
        }

    }

    public static void parseRoutes(Scanner sc, HashMap<String, String> routes)
    {
        System.out.println("Parsing routes...");

        String[] routeKeys;
        routeKeys = sc.nextLine().replace("\"", "").split(",");

        int id_index1 = -1;
        int route_index = -1;

        for (int i = 0; i < routeKeys.length; i++)
        {
            switch (routeKeys[i])
            {
                case "route_short_name" -> route_index = i;
                case "route_id" -> id_index1 = i;
            }
        }

        while (sc.hasNext())
        {
            String s = sc.nextLine().replace("\"", "");
            if (s.equals("done"))
                break;
            String[] p = s.split(",");

            routes.put(p[id_index1], p[route_index]);
        }
    }

    public static void parseDirections(Scanner sc, HashMap<String, String> directions)
    {
        System.out.println("Parsing directions...");

        String[] keys;
        keys = sc.nextLine().replace("\"", "").split(",");

        int dir_name_index = -1;
        int dir_id_index = -1;
        int route_index = -1;

        for (int i = 0; i < keys.length; i++)
        {
            switch (keys[i])
            {
                case "direction" -> dir_name_index = i;
                case "direction_id" -> dir_id_index = i;
                case "route_id" -> route_index = i;
            }
        }

        while (sc.hasNext())
        {
            String s = sc.nextLine().replace("\"", "");
            if (s.equals("done"))
                break;
            String[] p = s.split(",");

            directions.put(p[route_index] + "," + p[dir_id_index], p[dir_name_index]);
        }
    }

    public static void parseCalendar(Scanner sc, HashMap<String, String> calendar)
    {
        System.out.println("Parsing calendar...");

        String[] keys;
        keys = sc.nextLine().replace("\"", "").split(",");

        int service_index = -1;
        int[] weekdays = new int[7];

        for (int i = 0; i < keys.length; i++)
        {
            switch (keys[i])
            {
                case "service_id" -> service_index = i;
                case "monday" -> weekdays[0] = i;
                case "tuesday" -> weekdays[1] = i;
                case "wednesday" -> weekdays[2] = i;
                case "thursday" -> weekdays[3] = i;
                case "friday" -> weekdays[4] = i;
                case "saturday" -> weekdays[5] = i;
                case "sunday" -> weekdays[6] = i;

            }
        }

        while (sc.hasNext())
        {
            String s = sc.nextLine().replace("\"", "");
            if (s.equals("done"))
                break;
            String[] p = s.split(",");

            StringBuilder days = new StringBuilder();
            String allDays = "MTWRFSY";

            for (int i = 0; i < 7; i++)
            {
                if (p[weekdays[i]].equals("1"))
                    days.append(allDays.charAt(i));
            }

            calendar.put(p[service_index], days.toString());
        }
    }


    public static void parseTrips(Scanner sc, HashMap<String, String> tripToRoute, HashMap<String, String> tripToDir, HashMap<String, String> tripToService, HashSet<String> dirs)
    {
        System.out.println("Parsing trips...");

        String[] tripKeys;
        tripKeys = sc.nextLine().replace("\"", "").split(",");

        int trip_index = -1;
        int route_index = -1;
        int dir_index = -1;
        int service_index = -1;

        for (int i = 0; i < tripKeys.length; i++)
        {
            switch (tripKeys[i])
            {
                case "route_id" -> route_index = i;
                case "trip_id" -> trip_index = i;
                case "direction_id" -> dir_index = i;
                case "service_id" -> service_index = i;
            }
        }

        while (sc.hasNext())
        {
            String s = sc.nextLine().replace("\"", "");;
            if (s.equals("done"))
                break;

            String[] p = s.split(",");

            tripToRoute.put(p[trip_index], p[route_index]);
            tripToDir.put(p[trip_index], p[dir_index]);
            tripToService.put(p[trip_index], p[service_index]);
            dirs.add(p[dir_index]);
        }
    }

    public static String formatTime(String in)
    {
        if (in == null)
            return null;

        String[] sec = in.split(":");
        return Integer.parseInt(sec[0]) * 3600 + Integer.parseInt(sec[1]) * 60 + Integer.parseInt(sec[2]) + "";
    }

    static class Sortable
    {
        public String id;
        public int start = Integer.MAX_VALUE;

        public Sortable(String id)
        {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException
    {
        LinkedHashSet<String> stopNames = new LinkedHashSet<>();
        HashMap<String, Sortable> trips = new HashMap<>();

        HashMap<String, String> stopsMap = new HashMap<>();
        HashMap<String, String> stopsNameTranslations = new HashMap<>();
        parseStops(new Scanner(GTFSParser.class.getResourceAsStream(folder + "/stops.txt")), stopsMap, stopNames, stopsNameTranslations);

        HashMap<String, String> routesMap = new HashMap<>();
        parseRoutes(new Scanner(GTFSParser.class.getResourceAsStream(folder + "/routes.txt")), routesMap);

        HashMap<String, String> tripRouteMap = new HashMap<>();
        HashMap<String, String> tripDirMap = new HashMap<>();
        HashMap<String, String> tripServiceMap = new HashMap<>();
        HashSet<String> dirs = new HashSet<>();
        parseTrips(new Scanner(GTFSParser.class.getResourceAsStream(folder + "/trips.txt")), tripRouteMap, tripDirMap, tripServiceMap, dirs);

        HashMap<String, String> calendar = new HashMap<>();
        parseCalendar(new Scanner(GTFSParser.class.getResourceAsStream(folder + "/calendar.txt")), calendar);

        HashMap<String, String> directions = new HashMap<>();
        parseDirections(new Scanner(GTFSParser.class.getResourceAsStream(folder + "/directions.txt")), directions);

        Scanner sc = new Scanner(GTFSParser.class.getResourceAsStream(folder + "/stop_times.txt"));
        String[] keys;
        keys = sc.nextLine().replace("\"", "").split(",");

        System.out.println("Parsing stop times...");

        File out = new File(folder + ".csv");
        out.createNewFile();
        PrintWriter pw = new PrintWriter(out);

        int time_index = -1;
        int id_index = -1;
        int stop_index = -1;

        for (int i = 0; i < keys.length; i++)
        {
            switch (keys[i])
            {
                case "trip_id" -> id_index = i;
                case "departure_time" -> time_index = i;
                case "stop_id" -> stop_index = i;
            }
        }

        HashMap<String, HashMap<String, String>> stops = new HashMap<>();
        HashMap<String, HashMap<String, String>> stopsByTrip = new HashMap<>();
        HashMap<String, Integer> tripStopCount = new HashMap<>();

        while (sc.hasNext())
        {
            String s = sc.nextLine().replace("\"", "");
            if (s.equals("done"))
                break;

            String[] p = s.split(",");
            String time = p[time_index];
            String stop = stopsMap.get(p[stop_index]);
            String trip = p[id_index];

            if (!trips.containsKey(trip))
                trips.put(trip, new Sortable(trip));

            String t = formatTime(time);
            int ti = Integer.MAX_VALUE;
            if (t != null)
                ti = Integer.parseInt(t);

            trips.get(trip).start = Math.min(trips.get(trip).start, ti);

            if (!stops.containsKey(stop))
                stops.put(stop, new HashMap<>());

            if (!stopsByTrip.containsKey(trip))
                stopsByTrip.put(trip, new HashMap<>());

            if (!tripStopCount.containsKey(trip))
               tripStopCount.put(trip, 0);

            stops.get(stop).put(trip, time);
            stopsByTrip.get(trip).put(stop, time);
            tripStopCount.put(trip, tripStopCount.get(trip) + 1);
        }

        ArrayList<Sortable> tripsSorted = new ArrayList<>(trips.values());
        tripsSorted.sort(Comparator.comparingInt(o -> o.start));

        int count = calendar.keySet().size() * routesMap.keySet().size() * stopNames.size() * dirs.size() * tripsSorted.size();
        System.out.println("Writing " + count + " entries... (" + calendar.keySet().size() + " days, " + routesMap.keySet().size() + " routes, " + stopNames.size() + " stops, " + dirs.size() + " directions, " + tripsSorted.size() + " trips)");
        int count1 = calendar.keySet().size() * routesMap.keySet().size() * dirs.size();
        int countLeft = count1;

        for (String service: calendar.keySet())
        {
            for (String route : routesMap.keySet())
            {
                String routeName = routesMap.get(route);
                for (String dir : dirs)
                {
                    if (countLeft * 100 / count1 != (countLeft - 1) * 100 / count1)
                        System.out.println(100 - countLeft * 100 / count1 + "% complete...");

                    countLeft--;

                    Sortable foundTrip = null;
                    int stopCount = 0;
                    for (Sortable tt: tripsSorted)
                    {
                        if (!(route.equals(tripRouteMap.get(tt.id)) && dir.equals(tripDirMap.get(tt.id)) && service.equals(tripServiceMap.get(tt.id)) && stopsByTrip.get(tt.id) != null))
                            continue;

                        if (tripStopCount.get(tt.id) > stopCount)
                        {
                            foundTrip = tt;
                            stopCount = tripStopCount.get(tt.id);
                        }
                    }

                    ArrayList<String> stopNamesToUse = new ArrayList<>(stopNames);
                    if (foundTrip != null)
                    {
                        String t = foundTrip.id;
                        ArrayList<Sortable> ts = new ArrayList<>();
                        for (String s : stopsByTrip.get(t).keySet())
                        {
                            String time = stopsByTrip.get(t).get(s);
                            if (time != null)
                            {
                                Sortable so = new Sortable(s);
                                so.start = Integer.parseInt(formatTime(time));
                                ts.add(so);
                            }
                        }
                        ts.sort(Comparator.comparingInt(o -> o.start));

                        stopNamesToUse = new ArrayList<>();
                        for (Sortable so: ts)
                        {
                            stopNamesToUse.add(so.id);
                        }
                    }

                    boolean first = true;
                    for (String s : stopNamesToUse)
                    {
                        if (stops.get(s) == null)
                            continue;

                        boolean found = false;
                        for (Sortable tt : tripsSorted)
                        {
                            String t = tt.id;
                            if (route.equals(tripRouteMap.get(t)) && dir.equals(tripDirMap.get(t)) && service.equals(tripServiceMap.get(t)) && stops.get(s).get(t) != null)
                            {
                                found = true;
                                break;
                            }
                        }

                        if (!found)
                            continue;

                        if (first)
                            pw.println(routeName + "/" + dir + "/" + directions.get(route + "," + dir) + "/" + service + "/" + calendar.get(service));

                        first = false;

                        pw.print(s.trim() + "," + stopsNameTranslations.get(s).trim() + ",");
                        for (Sortable tt : tripsSorted)
                        {
                            String t = tt.id;
                            if (route.equals(tripRouteMap.get(t)) && dir.equals(tripDirMap.get(t)) && service.equals(tripServiceMap.get(t)))
                            {
                                String p = stops.get(s).get(t);

                                if (format_time)
                                    p = formatTime(p);

                                pw.print(p + ",");
                            }
                        }
                        pw.println();
                    }
                }
            }
        }
        System.out.println("done!");
        pw.close();
    }
}
