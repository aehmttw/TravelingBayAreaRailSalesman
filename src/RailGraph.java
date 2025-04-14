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

    public Station sjBerryessa = new Station("San Jose Berryessa", "place_BERY");
    public Station milpitas = new Station("Milpitas", "place_MLPT", "PS_MILP");
    public Station bayFair = new Station("Bay Fair", "place_BAYF");
    public Station coliseum = new Station("Coliseum", "place_COLS");
    public Station macarthur = new Station("MacArthur", "place_MCAR");
    public Station richmond = new Station("Richmond", "place_RICH");
    public Station embarcadero = new Station("Embarcadero", "place_EMBR", "Metro Embarcadero Station");
    public Station powell = new Station("Powell", "place_POWL", "Metro Powell Station/Downtown", "Metro Powell Station/Outbound", "Union Square/Market St Station Northbound", "Union Square/Market St Station Southbound");
    public Station civicCenter = new Station("Civic Center", "place_CIVC", "Metro Civic Center Station/Downtn", "Metro Civic Center Station/Outbd");
    public Station balboaPark = new Station("Balboa Park", "place_BALB", "Balboa Park BART/Mezzanine Level", "San Jose Ave & Geneva Ave", "San Jose Ave & Niagra Ave");
    public Station dalyCity = new Station("Daly City", "place_DALY");
    public Station antioch = new Station("Antioch", "place_ANTC");
    public Station millbrae = new Station("Millbrae", "place_MLBR");
    public Station dublinPleasanton = new Station("Dublin/Pleasanton", "place_DUBL");
    public Station gilroy = new Station("Gilroy", "gilroy");
    public Station tamien = new Station("Tamien", "tamien", "PS_TAMN");
    public Station diridon = new Station("Diridon", "sj_diridon", "PS_DIRD");
    public Station mountainView = new Station("Mountain View", "mountain_view", "PS_MVTC");
    public Station bayshore = new Station("Bayshore", "bayshore");
    public Station southSF = new Station("South San Francisco", "south_sf");
    public Station sf4thAndKing = new Station("San Francisco 4th & King", "san_francisco", "4th St & King St", "King St & 4th St");
    public Station sf22nd = new Station("22nd Street", "22nd_street");
    public Station oldIronsides = new Station("Old Ironsides", "PS_OLDI");
    public Station champion = new Station("Champion", "PS_CHMP");
    public Station baypointe = new Station("Baypointe", "PS_BAYP");
    public Station alumRock = new Station("Alum rock", "PS_ALUM");
    public Station conventionCenter = new Station("Convention Center", "PS_CONV");
    public Station winchester = new Station("Winchester", "PS_WINC");
    public Station santaTeresa = new Station("Santa Teresa", "PS_TRSA");
    public Station vanNess = new Station("Van Ness", "Metro Van Ness Station", "Van Ness Station Outbound");
    //public Station duboceAndChurch = new Station("Duboce & Church", "Duboce Ave & Church St", "Church St & Duboce Ave");
    public Station church = new Station("Church", "Metro Church Station/Outbound", "Metro Church Station/Downtown", "Church St & Market St");
    public Station westPortal = new Station("West Portal", "West Portal Station");
    public Station zoo = new Station("SF Zoo", "Wawona/46th Ave /SF Zoo", "47th Ave & Cutler Ave");
    public Station sloatAndStFrancis = new Station("Sloat & St. Francis", "West Portal/Sloat/St Francis Circle");
    public Station oceanBeach = new Station("Ocean Beach", "Judah/La Playa/Ocean Beach");
    public Station chinatown = new Station("Chinatown - Rose Pak", "Chinatown - Rose Pak Station");
    public Station sf23rd = new Station("23rd Street", "Third Street & 23rd St");
    public Station sunnydale = new Station("Sunnydale", "Bayshore Blvd & Sunnydale Ave");

    public Station fremont = new Station("fremont", true);
    public Station sanLeandro = new Station("san leandro", true);
    public Station fruitvale = new Station("fruitvale", true);
    public Station westOakland = new Station("west oakland", true);
    public Station oakland12th = new Station("12th oakland", true);
    public Station montgomery = new Station("montgomery", true);
    public Station mission24th = new Station("24th mission", true);
    public Station sfAirport = new Station("sfo", true);
    public Station sunnyvale = new Station("sunnyvale", true);
    public Station paloAlto = new Station("palo alto", true);
    public Station sanBruno = new Station("san bruno", true);
    public Station nasa = new Station("nasa", true);
    public Station tasman = new Station("tasman", true);
    public Station greatMall = new Station("great mall", true);
    public Station greatAmerica = new Station("great america", true);
    public Station sanFernando = new Station("san fernando", true);
    public Station childrensMuseum = new Station("childrens' museum", true);
    public Station church24th = new Station("24th church", true);
    public Station oceanLee = new Station("ocean and lee", true);
    public Station westPortal14th = new Station("west portal and 14th", true);
    public Station castro = new Station("castro", true);
    public Station sfState = new Station("sf state", true);
    public Station folsom = new Station("folsom", true);
    public Station brannan4th = new Station("brannan and 4th", true);
    public Station ucsf = new Station("ucsf", true);
    public Station williams = new Station("williams", true);
    public Station taraval = new Station("taraval", true);
    public Station judah = new Station("judah", true);
    public Station belmont = new Station("belmont", true);
    public Station calAve = new Station("california ave", true);
    public Station santaClara = new Station("santa clara", true);

    public void init()
    {
        bartOrange.addStop(richmond, bartRed)
                .addStop(macarthur, bartYellow)
                .addMStop(oakland12th)
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
                .addMStop(oakland12th)
                .addMStop(westOakland)
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
                .addMStop(westOakland)
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
                .addMStop(oakland12th)
                .addMStop(westOakland)
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
                .addMStop(westOakland)
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

        muniL.addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(vanNess, muniN)
                .addStop(church, muniJ)
                .addMStop(castro)
                .addStop(westPortal, muniK, muniM)
                .addMStop(taraval)
                .addStop(zoo, oceanBeachWalk)
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

            if (stop.station == target)
                cur.finished = true;

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

                    if (arriveTime < n.bfsTime)
                    {
                        if (arriveTime >= time)
                        {
                            n.bfsFrom = stop;
                            n.bfsTime = arriveTime;
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
        ArrayList<Station> remainingStations = new ArrayList<>();
//        while (!temp.isEmpty())
//        {
//            remainingStations.add(temp.remove((int) (r.nextDouble() * temp.size())));
//        }

        remainingStations.add(diridon);
        remainingStations.add(fremont);
        remainingStations.add(westOakland);

        int time = 0;
        Line.Stop location = caltrain.stops.get(9);//caltrainGilroy.stops.get(caltrainGilroy.stops.size() - 1);
        //remainingStations.remove();
        itinerary.add(new ItineraryElement(location.bfsTime, location));

        while (!remainingStations.isEmpty())
        {
            Station next = remainingStations.remove(remainingStations.size() - 1);
            System.out.println("goto " + next.name + " " + next.explored);

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

                    //System.out.println("> " + result);
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
                for (Station s: remainingStations)
                {
//                    System.out.println(s.name + " " + s.explored);
                    if (!s.explored)
                        remaining.add(s);
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
        Line.Stop location = caltrainGilroy.stops.get(caltrainGilroy.stops.size() - 1);
        Line.Stop dest = bfsTo(winchester, location, 0);

        do
        {
            if (!dest.midpoint)
                System.out.println(dest);

            dest = dest.bfsFrom;
        }
        while (dest != null);
    }

    public static void main(String[] args)
    {
        RailGraph r = new RailGraph();
//        r.test();
        r.init();

        Random seeder = new Random();

        long bestSeed = -2250604172248135272l;//seeder.nextLong();
        Itinerary itinerary = r.travelingSalesman(new Random(bestSeed));
        int runs = 0;
        for (int i = 0; i < runs; i++)
        {
            if (i * 100 / runs != (i - 1) * 100 / runs)
                System.out.println(i * 100 / runs + "% done");

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
