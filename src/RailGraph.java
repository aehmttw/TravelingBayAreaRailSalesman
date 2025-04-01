public class RailGraph
{
    public Line bartOrange = new Line("BART Orange");
    public Line bartRed = new Line("BART Red");
    public Line bartYellow = new Line("BART Yellow");
    public Line bartGreen = new Line("BART Green");
    public Line bartBlue = new Line("BART Blue");

    public Line caltrain = new Line("Caltrain");

    public Line vtaOrange = new Line("VTA Orange");
    public Line vtaGreen = new Line("VTA Green");
    public Line vtaBlue = new Line("VTA Blue");

    public Line muniJ = new Line("Muni J");
    public Line muniK = new Line("Muni K");
    public Line muniL = new Line("Muni L");
    public Line muniM = new Line("Muni M");
    public Line muniN = new Line("Muni N");
    public Line muniT = new Line("Muni T");

    public Station sjBerryessa = new Station("San Jose Berryessa");
    public Station milpitas = new Station("Milpitas");
    public Station bayFair = new Station("Bay Fair");
    public Station coliseum = new Station("Coliseum");
    public Station macarthur = new Station("MacArthur");
    public Station richmond = new Station("Richmond");
    public Station embarcadero = new Station("Embarcadero");
    public Station powell = new Station("Powell");
    public Station civicCenter = new Station("Civic Center");
    public Station balboaPark = new Station("Balboa Park");
    public Station dalyCity = new Station("Daly City");
    public Station antioch = new Station("Antioch");
    public Station millbrae = new Station("Millbrae");
    public Station dublinPleasanton = new Station("Dublin/Pleasanton");
    public Station gilroy = new Station("Gilroy");
    public Station tamien = new Station("Tamien");
    public Station diridon = new Station("Diridon");
    public Station mountainView = new Station("Mountain View");
    public Station bayshore = new Station("Bayshore");
    public Station sf4thAndKing = new Station("San Francisco 4th & King");
    public Station oldIronsides = new Station("Old Ironsides");
    public Station champion = new Station("Champion");
    public Station baypointe = new Station("Baypointe");
    public Station alumRock = new Station("Alum rock");
    public Station conventionCenter = new Station("Convention Center");
    public Station winchester = new Station("Winchester");
    public Station santaTeresa = new Station("Santa Teresa");
    public Station vanNess = new Station("Van Ness");
    public Station duboceAndChurch = new Station("Duboce & Church");
    public Station church = new Station("Church");
    public Station westPortal = new Station("West Portal");
    public Station zoo = new Station("SF Zoo");
    public Station sloatAndStFrancis = new Station("SF Zoo");
    public Station oceanBeach = new Station("Ocean Beach");
    public Station chinatown = new Station("Chinatown - Rose Pak");
    public Station sunnydale = new Station("Sunnydale");

    public Station fremont = new Station();
    public Station sanLeandro = new Station();
    public Station fruitvale = new Station();
    public Station westOakland = new Station();
    public Station oakland12th = new Station();
    public Station montgomery = new Station();
    public Station mission24th = new Station();
    public Station sfAirport = new Station();
    public Station sunnyvale = new Station();
    public Station paloAlto = new Station();
    public Station southSF = new Station();
    public Station sf22nd = new Station();
    public Station nasa = new Station();
    public Station tasman = new Station();
    public Station greatMall = new Station();
    public Station greatAmerica = new Station();
    public Station sanFernando = new Station();
    public Station childrensMuseum = new Station();
    public Station church24th = new Station();
    public Station westPortal14th = new Station();
    public Station castro = new Station();
    public Station sfState = new Station();
    public Station folsom = new Station();
    public Station brannan4th = new Station();
    public Station ucsf = new Station();

    public void init()
    {
        bartOrange.addStop(sjBerryessa, bartGreen)
                .addStop(milpitas, vtaOrange)
                .addMStop(fremont)
                .addStop(bayFair, bartBlue)
                .addMStop(sanLeandro)
                .addStop(coliseum)
                .addMStop(fruitvale)
                .addMStop(oakland12th)
                .addStop(macarthur, bartYellow)
                .addStop(richmond, bartRed);

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
                .addStop(dalyCity, bartYellow, bartGreen, bartBlue)
                .addMStop(sfAirport)
                .addStop(millbrae, caltrain);

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
                .addStop(dalyCity, bartYellow, bartGreen, bartRed);

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
                .addStop(dalyCity, bartRed, bartGreen, bartBlue);

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
                .addStop(dalyCity, bartYellow, bartBlue, bartRed);

        caltrain.addStop(gilroy)
                .addStop(tamien, vtaBlue)
                .addStop(diridon, vtaGreen)
                .addMStop(sunnyvale)
                .addStop(mountainView, vtaOrange)
                .addMStop(paloAlto)
                .addStop(millbrae, bartRed)
                .addMStop(southSF)
                .addStop(bayshore, muniT)
                .addMStop(sf22nd)
                .addStop(sf4thAndKing);

        vtaOrange.addStop(mountainView, caltrain)
                .addStop(nasa)
                .addStop(oldIronsides, vtaGreen)
                .addStop(champion, vtaGreen)
                .addMStop(greatAmerica)
                .addStop(baypointe, vtaBlue)
                .addMStop(greatMall)
                .addStop(milpitas, vtaOrange, vtaGreen)
                .addStop(alumRock);

        vtaGreen.addStop(oldIronsides, vtaOrange)
                .addMStop(greatAmerica)
                .addStop(champion, vtaOrange)
                .addMStop(tasman)
                .addStop(conventionCenter, vtaBlue)
                .addMStop(sanFernando)
                .addStop(diridon, caltrain)
                .addStop(winchester);

        vtaBlue.addStop(baypointe, vtaOrange)
                .addMStop(tasman)
                .addStop(conventionCenter, vtaGreen)
                .addMStop(childrensMuseum)
                .addStop(tamien, caltrain)
                .addStop(santaTeresa);

        muniJ.addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniK, muniL, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(vanNess, muniK, muniL, muniM)
                .addStop(duboceAndChurch, muniN)
                .addStop(church, muniK, muniM, muniL)
                .addMStop(church24th)
                .addStop(balboaPark, bartRed, bartYellow, bartGreen, bartBlue, muniK, muniM);

        muniK.addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniL, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(vanNess, muniN)
                .addStop(church, muniJ)
                .addMStop(castro)
                .addStop(westPortal, muniL)
                .addMStop(westPortal14th)
                .addStop(sloatAndStFrancis, muniM)
                .addMStop(church24th)
                .addStop(balboaPark, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniM);

        muniL.addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(vanNess, muniN)
                .addStop(church, muniJ)
                .addMStop(castro)
                .addStop(westPortal, muniK, muniM)
                .addStop(zoo);

        muniM.addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniL, muniK, muniN)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(vanNess, muniN)
                .addStop(church, muniJ)
                .addMStop(castro)
                .addStop(westPortal, muniL)
                .addMStop(westPortal14th)
                .addStop(sloatAndStFrancis, muniK)
                .addMStop(sfState)
                .addStop(balboaPark, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK);

        muniN.addStop(sf4thAndKing, caltrain, muniT)
                .addMStop(folsom)
                .addStop(embarcadero, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniL)
                .addMStop(montgomery)
                .addStop(powell, muniT)
                .addStop(civicCenter, bartRed, bartYellow, bartGreen, bartBlue)
                .addStop(vanNess, muniK, muniL, muniM)
                .addStop(duboceAndChurch, muniJ)
                .addStop(oceanBeach);

        muniT.addStop(chinatown)
                .addStop(powell, bartRed, bartYellow, bartGreen, bartBlue, muniJ, muniK, muniM, muniL, muniN)
                .addMStop(brannan4th)
                .addStop(sf4thAndKing, caltrain, muniN)
                .addMStop(ucsf)
                .addStop(sunnydale, caltrain);
    }
}
