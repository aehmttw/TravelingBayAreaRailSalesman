import java.util.*;

public class RailGraph
{
    public String days = "MTWRF";
    public String bartFile = "bart.csv";
    public String caltrainFile = "caltrain.csv";
    public String vtaFile = "vta.csv";
    public String muniFile = "muni.csv";

    public Line bartOrange = new Line("BART Orange");
    public Line bartRed = new Line("BART Red");
    public Line bartYellow = new Line("BART Yellow");
    public Line bartGreen = new Line("BART Green");
    public Line bartBlue = new Line("BART Blue");

    public Line caltrain = new Line("Caltrain Local");
    public Line caltrainLimited = new Line("Caltrain Limited");
    public Line caltrainExpress = new Line("Caltrain Express");
    public Line caltrainGilroy = new Line("Caltrain South County Connector");

    public Line vtaOrange = new Line("VTA Orange");
    public Line vtaGreen = new Line("VTA Green");
    public Line vtaBlue = new Line("VTA Blue");

    public Line muniJ = new Line("Muni J");
    public Line muniK = new Line("Muni K");
    public Line muniL = new Line("Muni L");
    public Line muniM = new Line("Muni M");
    public Line muniN = new Line("Muni N");
    public Line muniT = new Line("Muni T");

    public Line bayshoreWalk = new Line("Bayshore to Sunnydale Walk");
    public Line oceanBeachWalk = new Line("Ocean Beach to Zoo Walk");
    public Line twentyStreetWalk = new Line("22nd to 23rd St Walk");

    public Station.Region sanJose = new Station.Region("J");
    public Station.Region sanFrancisco = new Station.Region("F");
    public Station.Region eastBay = new Station.Region("E");

    public Station sjBerryessa = new Station(sanJose, "San Jose Berryessa", "place_BERY");
    public Station milpitas = new Station(sanJose, "Milpitas", "place_MLPT", "PS_MILP");
    public Station bayFair = new Station(eastBay, "Bay Fair", "place_BAYF");
    public Station coliseum = new Station(eastBay, "Coliseum", "place_COLS");
    public Station macarthur = new Station(eastBay, "MacArthur", "place_MCAR");
    public Station westOakland = new Station(eastBay, "West Oakland", "place_WOAK");
    public Station oakland12th = new Station(eastBay, "12th St. Oakland", "place_12TH");
    public Station lakeMeritt = new Station(eastBay, "Lake Meritt", "place_LAKE");
    public Station richmond = new Station(eastBay, "Richmond", "place_RICH");
    public Station embarcadero = new Station(sanFrancisco, "Embarcadero", "place_EMBR", "Metro Embarcadero Station");
    public Station powell = new Station(sanFrancisco, "Powell", "place_POWL", "Metro Powell Station/Downtown", "Metro Powell Station/Outbound", "Union Square/Market St Station Northbound", "Union Square/Market St Station Southbound");
    public Station civicCenter = new Station(sanFrancisco, "Civic Center", "place_CIVC", "Metro Civic Center Station/Downtn", "Metro Civic Center Station/Outbd");
    public Station balboaPark = new Station(sanFrancisco, "Balboa Park", "place_BALB", "Balboa Park BART/Mezzanine Level", "San Jose Ave & Geneva Ave", "San Jose Ave & Niagra Ave");
    public Station dalyCity = new Station(sanFrancisco, "Daly City", "place_DALY");
    public Station antioch = new Station(eastBay, "Antioch", "place_ANTC");
    public Station millbrae = new Station(sanFrancisco, "Millbrae", "place_MLBR");
    public Station dublinPleasanton = new Station(eastBay, "Dublin/Pleasanton", "place_DUBL");
    public Station gilroy = new Station(sanJose, "Gilroy", "gilroy");
    public Station tamien = new Station(sanJose, "Tamien", "tamien", "PS_TAMN");
    public Station diridon = new Station(sanJose, "Diridon", "sj_diridon", "PS_DIRD");
    public Station mountainView = new Station(sanJose, "Mountain View", "mountain_view", "PS_MVTC");
    public Station bayshore = new Station(sanFrancisco, "Bayshore", "bayshore");
    public Station southSF = new Station(sanFrancisco, "South San Francisco", "south_sf");
    public Station sf4thAndKing = new Station(sanFrancisco, "San Francisco 4th & King", "san_francisco", "4th St & King St", "King St & 4th St");
    public Station sf22nd = new Station(sanFrancisco, "22nd Street", "22nd_street");
    public Station oldIronsides = new Station(sanJose, "Old Ironsides", "PS_OLDI");
    public Station champion = new Station(sanJose, "Champion", "PS_CHMP");
    public Station baypointe = new Station(sanJose, "Baypointe", "PS_BAYP");
    public Station alumRock = new Station(sanJose, "Alum rock", "PS_ALUM");
    public Station conventionCenter = new Station(sanJose, "Convention Center", "PS_CONV");
    public Station winchester = new Station(sanJose, "Winchester", "PS_WINC");
    public Station santaTeresa = new Station(sanJose, "Santa Teresa", "PS_TRSA");
    public Station vanNess = new Station(sanFrancisco, "Van Ness", "Metro Van Ness Station", "Van Ness Station Outbound");
    //public Station duboceAndChurch = new Station("Duboce & Church", "Duboce Ave & Church St", "Church St & Duboce Ave");
    public Station church = new Station(sanFrancisco, "Church", "Metro Church Station/Outbound", "Metro Church Station/Downtown", "Church St & Market St");
    public Station westPortal = new Station(sanFrancisco, "West Portal", "West Portal Station");
    public Station zoo = new Station(sanFrancisco, "SF Zoo", "Wawona/46th Ave /SF Zoo", "47th Ave & Cutler Ave");
    public Station sloatAndStFrancis = new Station(sanFrancisco, "Sloat & St. Francis", "West Portal/Sloat/St Francis Circle");
    public Station oceanBeach = new Station(sanFrancisco, "Ocean Beach", "Judah/La Playa/Ocean Beach");
    public Station chinatown = new Station(sanFrancisco, "Chinatown - Rose Pak", "Chinatown - Rose Pak Station");
    public Station sf23rd = new Station(sanFrancisco, "23rd Street", "Third Street & 23rd St");
    public Station sunnydale = new Station(sanFrancisco, "Sunnydale", "Bayshore Blvd & Sunnydale Ave");

    public Station fremont = new Station(sanJose, "fremont", true);
    public Station sanLeandro = new Station(eastBay, "san leandro", true);
    public Station fruitvale = new Station(eastBay, "fruitvale", true);
    public Station montgomery = new Station(sanFrancisco, "montgomery", true);
    public Station mission24th = new Station(sanFrancisco, "24th mission", true);
    public Station sfAirport = new Station(sanFrancisco, "sfo", true);
    public Station sunnyvale = new Station(sanJose, "sunnyvale", true);
    public Station paloAlto = new Station(sanJose, "palo alto", true);
    public Station sanBruno = new Station(sanFrancisco, "san bruno", true);
    public Station nasa = new Station(sanJose, "nasa", true);
    public Station tasman = new Station(sanJose, "tasman", true);
    public Station greatMall = new Station(sanJose, "great mall", true);
    public Station greatAmerica = new Station(sanJose, "great america", true);
    public Station sanFernando = new Station(sanJose, "san fernando", true);
    public Station childrensMuseum = new Station(sanJose, "childrens' museum", true);
    public Station church24th = new Station(sanFrancisco, "24th church", true);
    public Station oceanLee = new Station(sanFrancisco, "ocean and lee", true);
    public Station westPortal14th = new Station(sanFrancisco, "west portal and 14th", true);
    public Station castro = new Station(sanFrancisco, "castro", true);
    public Station sfState = new Station(sanFrancisco, "sf state", true);
    public Station folsom = new Station(sanFrancisco, "folsom", true);
    public Station brannan4th = new Station(sanFrancisco, "brannan and 4th", true);
    public Station ucsf = new Station(sanFrancisco, "ucsf", true);
    public Station williams = new Station(sanFrancisco, "williams", true);
    public Station taraval = new Station(sanFrancisco, "taraval", true);
    public Station judah = new Station(sanFrancisco, "judah", true);
    public Station belmont = new Station(sanJose, "belmont", true);
    public Station calAve = new Station(sanJose, "california ave", true);
    public Station santaClara = new Station(sanJose, "santa clara", true);

    public void init()
    {
        bartOrange.addStop(richmond, bartRed)
                .addStop(macarthur, bartYellow)
                .addStop(oakland12th, bartRed, bartYellow)
                .addStop(lakeMeritt, bartBlue, bartGreen)
                .addMStop(fruitvale)
                .addStop(coliseum)
                .addMStop(sanLeandro)
                .addStop(bayFair, bartBlue)
                .addMStop(fremont)
                .addStop(milpitas, vtaOrange)
                .addStop(sjBerryessa, bartGreen)
                .readTimetable("Orange-S", "Orange-N", days, bartFile);

        bartRed.addStop(richmond, bartOrange)
                .addStop(macarthur, bartYellow)
                .addStop(oakland12th, bartOrange)
                .addStop(westOakland, bartGreen, bartBlue)
                .addStop(embarcadero, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(mission24th)
                .addStop(balboaPark, muniJ, muniK, muniM)
                .addStop(dalyCity, bartGreen, bartBlue)
                .addMStop(sfAirport)
                .addStop(millbrae, caltrain, bartYellow)
                .readTimetable("Red-S", "Red-N", days, bartFile);

        bartBlue.addStop(dublinPleasanton)
                .addStop(bayFair, bartGreen, bartOrange)
                .addMStop(sanLeandro)
                .addStop(coliseum)
                .addMStop(fruitvale)
                .addStop(lakeMeritt, bartOrange)
                .addStop(westOakland, bartRed, bartYellow)
                .addStop(embarcadero, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(mission24th)
                .addStop(balboaPark, muniJ, muniK, muniM)
                .addStop(dalyCity, bartYellow, bartGreen, bartRed)
                .readTimetable("Blue-S", "Blue-N", days, bartFile);

        bartYellow.addStop(antioch)
                .addStop(macarthur, bartRed, bartOrange)
                .addStop(oakland12th, bartOrange)
                .addStop(westOakland, bartGreen, bartBlue)
                .addStop(embarcadero, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(mission24th)
                .addStop(balboaPark, muniJ, muniK, muniM)
                .addStop(dalyCity, bartGreen, bartBlue)
                .addMStop(sfAirport)
                .addStop(millbrae, caltrain, bartRed)
                .readTimetable("Yellow-S", "Yellow-N", days, bartFile);

        bartGreen.addStop(sjBerryessa, bartOrange)
                .addStop(milpitas, vtaOrange)
                .addMStop(fremont)
                .addStop(bayFair, bartBlue)
                .addMStop(sanLeandro)
                .addStop(coliseum)
                .addMStop(fruitvale)
                .addStop(lakeMeritt, bartOrange)
                .addStop(westOakland, bartRed, bartYellow)
                .addStop(embarcadero, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, muniJ, muniK, muniL, muniM, muniN)
                .addMStop(mission24th)
                .addStop(balboaPark, muniJ, muniK, muniM)
                .addStop(dalyCity, bartYellow, bartBlue, bartRed)
                .readTimetable("Green-S", "Green-N", days, bartFile);

        caltrain.addStop(sf4thAndKing)
                .addStop(sf22nd, twentyStreetWalk)
                .addStop(bayshore, bayshoreWalk)
                .addStop(southSF)
                .addMStop(sanBruno)
                .addStop(millbrae, bartRed)
                .addMStop(belmont)
                .addMStop(paloAlto)
                .addMStop(calAve)
                .addStop(mountainView, vtaOrange)
                .addMStop(sunnyvale)
                .addMStop(santaClara)
                .addStop(diridon, vtaGreen, caltrainGilroy)
                .addStop(tamien, vtaBlue, caltrainGilroy)
                .readTimetable("Local Weekday", days, caltrainFile);

        caltrainLimited.addStop(sf4thAndKing)
                .addStop(sf22nd, caltrain, twentyStreetWalk)
                .addStop(southSF, caltrain)
                .addStop(millbrae, bartRed)
                .addMStop(paloAlto)
                .addMStop(calAve)
                .addStop(mountainView, vtaOrange)
                .addMStop(sunnyvale)
                .addMStop(santaClara)
                .addStop(diridon, vtaGreen, caltrainGilroy)
                .readTimetable("Limited", days, caltrainFile);

        caltrainExpress.addStop(sf4thAndKing)
                .addStop(sf22nd, caltrain, twentyStreetWalk)
                .addStop(southSF, caltrain)
                .addStop(millbrae, bartRed)
                .addMStop(paloAlto)
                .addStop(mountainView, vtaOrange)
                .addMStop(sunnyvale)
                .addStop(diridon, vtaGreen, caltrainGilroy)
                .readTimetable("Express", days, caltrainFile);

        caltrainGilroy.addStop(diridon, vtaGreen, caltrain, caltrainLimited, caltrainExpress)
                .addStop(tamien, vtaBlue, caltrain)
                .addStop(gilroy)
                .readTimetable("South County", days, caltrainFile);

        vtaOrange.addStop(alumRock)
                .addStop(milpitas, bartOrange, bartGreen)
                .addMStop(greatMall)
                .addStop(baypointe, vtaBlue)
                .addMStop(greatAmerica)
                .addStop(champion, vtaGreen)
                .addStop(oldIronsides, vtaGreen)
                .addMStop(nasa)
                .addStop(mountainView, caltrain, caltrainLimited, caltrainExpress)
                .readTimetable("Orange Line", days, vtaFile);

        vtaGreen.addStop(oldIronsides, vtaOrange)
                .addMStop(greatAmerica)
                .addStop(champion, vtaOrange)
                .addMStop(tasman)
                .addStop(conventionCenter, vtaBlue)
                .addMStop(sanFernando)
                .addStop(diridon, caltrain, caltrainLimited, caltrainExpress)
                .addStop(winchester)
                .readTimetable("Green Line", days, vtaFile);

        vtaBlue.addStop(baypointe, vtaOrange)
                .addMStop(tasman)
                .addStop(conventionCenter, vtaGreen)
                .addMStop(childrensMuseum)
                .addStop(tamien, caltrain)
                .addStop(santaTeresa)
                .readTimetable("Blue Line", days, vtaFile);

        muniJ.addStop(balboaPark, bartRed, bartYellow, bartGreen, bartBlue, muniK, muniM)
                .addMStop(church24th)
                .addStop(church, muniK, muniM, muniL)
                //.addStop(duboceAndChurch, muniN)
                .addStop(vanNess, muniK, muniL, muniM, muniN)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(powell, muniT)
                .addMStop(montgomery)
                .addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniK, muniL, muniM, muniN)
                .readTimetable("J", days, muniFile);

        muniK.addStop(balboaPark, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniM)
                .addMStop(oceanLee)
                .addStop(sloatAndStFrancis, muniM)
                .addMStop(westPortal14th)
                .addStop(westPortal, muniL)
                .addMStop(castro)
                .addStop(church, muniJ)
                .addStop(vanNess, muniN)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(powell, muniT)
                .addMStop(montgomery)
                .addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniL, muniM, muniN)
                .readTimetable("K", days, muniFile);

        muniL.addStop(zoo, oceanBeachWalk)
                .addMStop(taraval)
                .addStop(westPortal, muniK, muniM)
                .addMStop(castro)
                .addStop(church, muniJ)
                .addStop(vanNess, muniN)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(powell, muniT)
                .addMStop(montgomery)
                .addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniN)
                .readTimetable("L", days, muniFile);

        muniM.addStop(balboaPark, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK)
                .addMStop(sfState)
                .addStop(sloatAndStFrancis, muniK)
                .addMStop(westPortal14th)
                .addStop(westPortal, muniL)
                .addMStop(castro)
                .addStop(church, muniJ)
                .addStop(vanNess, muniN)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(powell, muniT)
                .addMStop(montgomery)
                .addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniL, muniK, muniN)
                .readTimetable("M", days, muniFile);

        muniN.addStop(oceanBeach, oceanBeachWalk)
                .addMStop(judah)
                //.addStop(duboceAndChurch, muniJ)
                .addStop(vanNess, muniK, muniL, muniM, muniJ)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(powell, muniT)
                .addMStop(montgomery)
                .addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniL)
                .addMStop(folsom)
                .addStop(sf4thAndKing, caltrain, caltrainLimited, caltrainExpress, muniT)
                .readTimetable("N", days, muniFile);

        muniT.addStop(chinatown)
                .addStop(powell, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniL, muniN)
                .addMStop(brannan4th)
                .addStop(sf4thAndKing, caltrain, caltrainLimited, caltrainExpress, muniN)
                .addMStop(ucsf)
                .addStop(sf23rd, twentyStreetWalk)
                .addMStop(williams)
                .addStop(sunnydale, bayshoreWalk)
                .readTimetable("T", days, muniFile);

        oceanBeachWalk.addStop(oceanBeach, muniN)
                .addStop(zoo, muniL)
                .setWalk(30);

        bayshoreWalk.addStop(bayshore, caltrain)
                .addStop(sunnydale, muniT)
                .setWalk(10);

        twentyStreetWalk.addStop(sf22nd, caltrain, caltrainLimited, caltrainExpress)
                .addStop(sf23rd, muniT)
                .setWalk(2);
    }


    public static class QueueElement implements Comparable<QueueElement>
    {
        int time;
        boolean direction;
        boolean finished;
        Line.Stop stop;

        public QueueElement(int time, boolean direction, Line.Stop stop, boolean finished)
        {
            this.time = time;
            this.direction = direction;
            this.stop = stop;
            this.finished = finished;
        }

        @Override
        public int compareTo(QueueElement o)
        {
            return this.time - o.time;
        }
    }

    public static class ItineraryElement
    {
        int time;
        Line.Stop stop;

        public ItineraryElement(int time, Line.Stop stop)
        {
            this.time = time;
            this.stop = stop;
        }
    }

    public static class Itinerary
    {
        int endTime;

        ArrayList<ItineraryElement> stops;
        ArrayList<Station> remaining = new ArrayList<>();

        public Itinerary(int end, ArrayList<ItineraryElement> stops)
        {
            this.endTime = end;
            this.stops = stops;
        }

        public Itinerary(ArrayList<Station> remaining, ArrayList<ItineraryElement> stops)
        {
            this.endTime = Integer.MAX_VALUE;
            this.stops = stops;
            this.remaining = remaining;
        }
    }

    int bfsIndex = 1;

    public Line.Stop bfsTo(Station target, Line.Stop startingStop, int startingTime)
    {
        for (Line l: Line.lines)
        {
            for (Line.Stop s: l.stops)
            {
                s.bfsFrom = null;
                s.bfsTime = Integer.MAX_VALUE;
            }
        }

        startingStop.bfsTime = startingTime;

        PriorityQueue<QueueElement> frontier = new PriorityQueue<>();

        if (startingStop.line.isWalk)
            frontier.add(new QueueElement(startingTime, startingStop.index == 0, startingStop, false));
        else
        {
//            System.out.println(startingStop + " " + startingStop.departureTimesBack + " " + startingStop.departureTimesForward);
            int fIndex = Arrays.binarySearch(startingStop.departureTimesForward, startingTime);
            int bIndex = Arrays.binarySearch(startingStop.departureTimesBack, startingTime);

            if (fIndex < 0)
                fIndex = -(fIndex + 1);

            if (bIndex < 0)
                bIndex = -(bIndex + 1);

            startingStop.bfsTime = startingTime;

            if (fIndex < startingStop.departureTimesForward.length)
                frontier.add(new QueueElement(startingStop.departureTimesForward[fIndex], true, startingStop, false));

            if (bIndex < startingStop.departureTimesBack.length)
                frontier.add(new QueueElement(startingStop.departureTimesBack[bIndex], false, startingStop, false));
        }

        while (!frontier.isEmpty())
        {
            QueueElement cur = frontier.remove();
            Line.Stop stop = cur.stop;
            boolean dir = cur.direction;
            int time = cur.time;

//            System.out.println(" >> " + stop + " " + time + " from " + stop.bfsFrom + " " + (stop.bfsFrom != null ? stop.bfsFrom.bfsTime : ""));

//            System.out.println(stop + " " + target.name + " " + (stop.station == target) + " " + cur.finished);
            if (stop.station == target)
            {
                frontier.clear();
                cur.finished = true;
            }

            if (cur.finished && !cur.stop.midpoint)
                return cur.stop;

            Line.Stop si = stop;
            while (si.midpoint)
                si = si.bfsFrom;

            int stopIndex = -1;

            if (!si.line.isWalk)
            {
                if (dir)
                    stopIndex = Arrays.binarySearch(si.departureTimesForward, time);
                else
                    stopIndex = Arrays.binarySearch(si.departureTimesBack, time);

                if (stopIndex < 0)
                    stopIndex = -(stopIndex + 1);
            }

            int next = stop.index + (dir ? 1 : -1);
            while (next >= 0 && next <= stop.line.stops.size() - 1)
            {
                Line.Stop n = stop.line.stops.get(next);
                if (n.station != startingStop.station)
                {
//                    System.out.println(n + " " + n.index + " " + n.departureTimesForward + " " + n.departureTimesBack);
                    int arriveTime;
                    if (n.line.isWalk)
                        arriveTime = time + n.line.walkTime;
                    else if (n.midpoint)
                        arriveTime = time;
                    else if (dir)
                        arriveTime = n.departureTimesForward[stopIndex];
                    else
                        arriveTime = n.departureTimesBack[stopIndex];

//                    System.out.println("? " + n + " " + arriveTime + " " + n.bfsTime + " " + time);
                    if (arriveTime < n.bfsTime)
                    {
                        if (arriveTime >= time)
                        {
                            n.bfsFrom = stop;
                            n.bfsTime = arriveTime;
//                            System.out.println("+ " + n);
                            frontier.add(new QueueElement(arriveTime, dir, n, cur.finished));
                            break;
                        }
                        else
                        {
                            next += (dir ? 1 : -1);
                        }
                    }
                    else
                        break;
                }
                else
                    break;
            }

            for (Line l: stop.connections)
            {
                Line.Stop connection = l.stopsByStation.get(stop.station);
                if (connection.bfsTime <= time)
                    continue;

                connection.bfsFrom = stop;
                connection.bfsTime = time;

//                System.out.println(connection + " " + Arrays.toString(connection.departureTimesBack) + " " + Arrays.toString(connection.departureTimesForward));
                if (connection.line.isWalk)
                    frontier.add(new QueueElement(time, connection.index == 0, connection, cur.finished));
                else
                {
                    int fcIndex = Arrays.binarySearch(connection.departureTimesForward, time);
                    int bcIndex = Arrays.binarySearch(connection.departureTimesBack, time);

                    if (fcIndex < 0)
                        fcIndex = -(fcIndex + 1);

                    if (bcIndex < 0)
                        bcIndex = -(bcIndex + 1);

//                System.out.println(connection + " " + time + "->" + connection.departureTimesForward[fcIndex] + " " + connection.departureTimesBack[bcIndex]);

                    if (fcIndex < connection.departureTimesForward.length)
                        frontier.add(new QueueElement(connection.departureTimesForward[fcIndex], true, connection, cur.finished));

                    if (bcIndex < connection.departureTimesBack.length)
                        frontier.add(new QueueElement(connection.departureTimesBack[bcIndex], false, connection, cur.finished));
                }
            }
        }

        return null;
    }

    public Itinerary travelingSalesman(Random r)
    {
        for (Station s: Station.allStations)
        {
            s.explored = false;
        }

        ArrayList<ItineraryElement> itinerary = new ArrayList<>();

        ArrayList<Station> temp = new ArrayList<>(Station.allStations);
        HashMap<Station.Region, ArrayList<Station>> remainingStationsByRegion = new HashMap<>();
        while (!temp.isEmpty())
        {
            Station s = temp.remove((int) (r.nextDouble() * temp.size()));
            if (!remainingStationsByRegion.containsKey(s.region))
                remainingStationsByRegion.put(s.region, new ArrayList<>());

            remainingStationsByRegion.get(s.region).add(s);
        }

        int time = 0;
        ArrayList<Station.Region> remainingRegions = new ArrayList<>(Station.Region.regions);
        Line.Stop location = caltrainGilroy.stops.get(caltrainGilroy.stops.size() - 1);
        remainingStationsByRegion.get(sanJose).remove(gilroy);
        location.bfsTime = caltrainGilroy.stops.get(caltrainGilroy.stops.size() - 1).departureTimesBack[0];
        itinerary.add(new ItineraryElement(location.bfsTime, location));

        while (!remainingStationsByRegion.isEmpty())
        {
            Station.Region region = location.station.region;
            if (r.nextDouble() < 0.05 || !remainingStationsByRegion.containsKey(region))
                region = remainingRegions.get((int) (remainingRegions.size() * r.nextDouble()));

            ArrayList<Station> remainingStations = remainingStationsByRegion.get(region);
            Station next = remainingStations.remove(remainingStations.size() - 1);
            if (remainingStations.size() == 0)
            {
                remainingRegions.remove(region);
                remainingStationsByRegion.remove(region);
            }
//            System.out.println("goto " + next.name);

            if (next.explored)
                continue;

            Line.Stop result = bfsTo(next, location, time);
            if (result != null && result.bfsFrom != null)
            {
                Line.Stop prevLocation = location;
                location = result;
                time = result.bfsTime;

                ArrayList<Line.Stop> toAdd = new ArrayList<>();
                while (result != prevLocation)
                {
                    if (!result.midpoint)
                        toAdd.add(result);

//                    System.out.println(formatTime(result.bfsTime) + " > " + result);
                    result.station.explored = true;
                    result = result.bfsFrom;
                }

                for (int i = toAdd.size() - 1; i >= 0; i--)
                {
                    itinerary.add(new ItineraryElement(toAdd.get(i).bfsTime, toAdd.get(i)));
                }
            }
            else
            {
                ArrayList<Station> remaining = new ArrayList<>();
                for (Station.Region reg: remainingRegions)
                {
                    for (Station s : remainingStationsByRegion.get(reg))
                    {
//                    System.out.println(s.name + " " + s.explored);
                        if (!s.explored)
                            remaining.add(s);
                    }
                }
                if (!next.explored)
                    remaining.add(next);
                return new Itinerary(remaining, itinerary);
                //throw new RuntimeException("failed! " + location + " to " + next.name + " " + result);
            }
        }

        return new Itinerary(itinerary.get(itinerary.size() - 1).time, itinerary);
    }

    public void test()
    {
        init();
//        System.out.println(caltrainGilroy.stops.size());

//        muniL.printTimetable();

        for (Line l: Line.lines)
        {
            System.out.println(l.name);
            Line.Stop location = l.stops.get(0);
            Line.Stop dest = bfsTo(l.stops.get(l.stops.size() - 1).station, location, 35000);

            do
            {
                //if (!dest.midpoint)
                System.out.println(dest);

                dest = dest.bfsFrom;
            }
            while (dest != null);

            System.out.println("-------------");
        }
    }

    public static void main(String[] args)
    {
        RailGraph r = new RailGraph();
        r.init();

        Random seeder = new Random();

        long bestSeed = 6712661946611465523L; //seeder.nextLong();
        Itinerary itinerary = r.travelingSalesman(new Random(bestSeed));
        int runs = 0;
        for (int i = 0; i < runs; i++)
        {
            if (i * 100L / runs != (i - 1) * 100L / runs)
                System.out.println(i * 100L / runs + "% done");

            long seed = seeder.nextLong();
            Itinerary attempt = r.travelingSalesman(new Random(seed));
            if (!itinerary.remaining.isEmpty() && attempt.remaining.isEmpty() || itinerary.remaining.size() > attempt.remaining.size() || itinerary.endTime > attempt.endTime)
            {
                itinerary = attempt;
                bestSeed = seed;
                if (itinerary.remaining.isEmpty())
                    System.out.println(formatTime(attempt.endTime) + " - " + seed);
                else
                    System.out.println(attempt.remaining.size() + " - " + seed);
            }
        }

        Line line = itinerary.stops.get(0).stop.line;
        for (int i = 0; i < itinerary.stops.size(); i++)
        {
            Line.Stop s = itinerary.stops.get(i).stop;
            if (s.line != line || i == itinerary.stops.size() - 1 || i == 0 //changed lines
                    || itinerary.stops.get(i - 1).stop == itinerary.stops.get(i + 1).stop) //turned around
            {
                line = s.line;
                System.out.println(formatTime(itinerary.stops.get(i).time) + " - " + s);
            }
        }

        if (itinerary.remaining != null && !itinerary.remaining.isEmpty())
        {
            System.out.print("Remaining stations: ");
            for (Station s : itinerary.remaining)
            {
                System.out.print(s.name + ", ");
            }
            System.out.println("\b\b");
        }
        else
            System.out.println("End time: " + formatTime(itinerary.endTime));

        System.out.println();
        System.out.println("the best seed was " + bestSeed);
    }

    public static String formatTime(int time)
    {
        return String.format("%02d:%02d:%02d", time / 3600, (time / 60) % 60, time % 60);
    }
}
