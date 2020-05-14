package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.RequestMapper;

import java.util.ArrayList;

public class Calculator {

    public static Wood  getPole(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("Pæl");
        int pricePrM = wood.getPricePrM();
        String name = wood.getWoodName();
        Svg svg = new Svg(800, 600, "0,0,800,600",0,0);

        Request request = RequestMapper.getRequest4Styklist(id);
        int skurLength = request.getShedLength();
        int skurWidth = request.getShedWidth();
        int Length = request.getLength();
        int width = request.getWidth();
        double metersOfPole = 0;

        double lengthAsDouble = Length;

        //Længden er i cm, så vi gør den til meter. Der skal være to meter mellem hver stolpe og der skal være en stolpe på hver side så det er divideret med 2 gange med 2, hvilket betyder vi ikke behøver at skrive hverken eller.
        int numberOfPoles = (int) Math.ceil((lengthAsDouble/100) + 2);
        if(numberOfPoles % 2 != 0){
                numberOfPoles +=1;
        }

        //Carport uden skur
        if(skurLength==0){

        //Carport med skur
        }else{
            if(skurWidth==width && skurLength==Length){
                //+1 pæl til at hægte skur døren på. Alle andre pæle til at holde skurets vægge oppe er allerede i carporten
                numberOfPoles = numberOfPoles + 1;

            }
            if(skurWidth==width && skurLength!=Length){
                //3 pæle ekstra fordi skuret allerede har to støttepæle bagerst, men mangler to front støtte pæle og en pæl til at hægte skur døren på.
                numberOfPoles = numberOfPoles + 3;
            }
            if(skurWidth!=width && skurLength!=Length){
                //4 pæle ekstra fordi, skuret mangler i 3 hjørner og 1 pæl til at hægte døren på.
                numberOfPoles = numberOfPoles + 4;

            }

        }
        //Hver stolpe er 3 meter, fordi 100 cm af stolpen skal graves i jorden bagerst og 90 cm forrest, så taget får hældning(hvis det altså er en carport med fladt tag.
        metersOfPole = numberOfPoles*3;

        //Sammenlagt pris af pæle
        int price = (int) (metersOfPole * pricePrM);

        Wood pole = new Wood(name,price, (int) metersOfPole);
        svg.addRect(0, 0, Length,width);

        return pole ;
    }

    public static Wood getSpær(int id) throws LoginSampleException {

        Request request = RequestMapper.getRequest4Styklist(id);
        Wood wood = MaterialMapper.getWood("Spær");
        int pricePrM = wood.getPricePrM();
        String name = wood.getWoodName();
        int Length = request.getLength();
        int width = request.getWidth();
        int angle = request.getAngle();

        double lengthAsDouble = Length;
        double widthAsDouble= width;

        int spærLength = 0;
        //If der bestemmer om tag er med eller uden rejsning.
        if(angle==0){
            //Rem i hver side placeres på stolper, de raver 15 cm ud over stolperne i hver side = 30. Oven på remmene placeres spær 55 cm fra hinanden. +1 fordi det er mellemrummene man får når man dividerer med 0.55 og ikke antal spær.
             spærLength = (int) Math.ceil(((lengthAsDouble/100+0.3)*2)+((((lengthAsDouble+30)/100)/0.55 + 1)*(widthAsDouble/100+0.3)));
        }else{
            //Rem i hver side placeres på stolper, de raver 15 cm ud over stolperne i hver side = 30. Oven på remmene placeres spær 89 cm fra hinanden. +1 fordi det er mellemrummene man får når man dividerer med 0.55 og ikke antal spær.
             spærLength = (int) Math.ceil(((lengthAsDouble/100+0.3)*2)+((((lengthAsDouble+30)/100)/0.89 + 1)*(widthAsDouble/100+0.3)));

            double hypotenusen = (width/2)/Math.cos(Math.toRadians(angle))/100;

            double trekant = hypotenusen*2;

            int antaltrekanter = (int) (Math.ceil(lengthAsDouble/100)/0.89 + 1);

             spærLength += trekant * antaltrekanter;
        }


        //Sammenlagt pris af spær
        int price = spærLength*pricePrM;

        Wood spær = new Wood(name, price, spærLength);

        return spær;
    }

    public static Wood getRegel(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("Regel");
        int pricePrM = wood.getPricePrM();
        String name = wood.getWoodName();

        Request request = RequestMapper.getRequest4Styklist(id);
        int skurLength = request.getShedLength();
        int skurWidth = request.getShedWidth();
        double skurLengthAsDouble = skurLength;
        double skurWidthAsDouble = skurWidth;

        //der sidder øvre og nedre løsholter i et skur de skal være hel vejen rundt, så det er bare omkredsen af skuret gange 2
        int regelLength = (int) Math.ceil((skurLengthAsDouble/100) * 2 + (skurWidthAsDouble/100) * 2);

        //Sammenlagt pris af regeler
        int price = regelLength*pricePrM;

        Wood regel = new Wood(name, price, regelLength);

        return regel;

    }

    public static ShedClothing getClothing(int id) throws LoginSampleException {
        Request request = RequestMapper.getRequest4Styklist(id);
        String name = request.getSCname();

        int Width = request.getWidth() + 30;
        int angle = request.getAngle();
        int skurLength = request.getShedLength();
        int skurWidth = request.getShedWidth();
        double skurLengthAsDouble = skurLength;
        double skurWidthAsDouble = skurWidth;

        //prisPrM ligger allerede som kvadratmeter pris i databasen.
        int prisPrM = request.getSCprice();

        //Beregning af skurets overflade
        double skurKvadratmeter = skurLengthAsDouble*200*2 + skurWidthAsDouble*200*2;

        //Beregning af carportens gavl hvis carporten er med rejsning
        if(angle != 0){
            skurKvadratmeter = Math.ceil(skurKvadratmeter + ((Width/2) * ( (Width/2) * Math.tan(Math.toRadians(angle)) ) * 2 * 2));
        }

        //Overfladen omregnes til kvadratmeter. Math.ceil fordi hellere for meget beklædning end for lidt.
        skurKvadratmeter = Math.ceil(skurKvadratmeter/100/100);

        int pris = (int) (skurKvadratmeter*prisPrM);

        ShedClothing clothing = new ShedClothing(name, pris, skurKvadratmeter);

        return clothing;
    }

    public static RoofCoating getTag(int id) throws LoginSampleException {
        Request request = RequestMapper.getRequest4Styklist(id);

        //Taget hænger 15 cm ud over på hver side
        double length = 30 + request.getLength();
        double width = 30 + request.getWidth();

        String name = request.getRCname();

        //prisPrM ligger allerede som kvadratmeter pris i databasen.
        int prisPrM =request.getRCprice();

        //Runder op til nærmese kvadratmeter med Math.ceil
        double tagKvadratmeter = Math.ceil(length*width/100/100);

        int pris = (int) (tagKvadratmeter*prisPrM);

        RoofCoating RC = new RoofCoating(name, pris, tagKvadratmeter);

        return RC;
    }

    public static TiltedRoofCoating getRejsningTag(int id) throws LoginSampleException {
        Request request = RequestMapper.getRequest4Styklist(id);
        //Taget hænger 15 cm ud over på hver side
        double length = 30 + request.getLength();
        double width = 30 + request.getWidth();
        int angle = request.getAngle();

        String name = request.getTRCname();

        //prisPrM ligger allerede som kvadratmeter pris i databasen.
        int prisPrM =request.getTRCprice();

        double hypotenusen = (width/2)/Math.cos(Math.toRadians(angle))/100;

        int tagKvadratmeter = (int) Math.ceil((length/100)*hypotenusen*2);

        int pris = tagKvadratmeter * prisPrM;

        TiltedRoofCoating TRC = new TiltedRoofCoating(name, pris, tagKvadratmeter);

        return TRC;
    }


    public static Wood getUniBeslag(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("UniversalBeslag");
        int pricePrStk = wood.getPricePrM();
        String name = wood.getWoodName();

        Request request = RequestMapper.getRequest4Styklist(id);
        int Length = request.getLength();
        int angle = request.getAngle();
        int antalBeslag = 0;
        int spærAntal = 0;

        //If der bestemmer om tag er med eller uden rejsning.
        if(angle==0){
            //spær placeres 55 cm fra hinanden. +1 fordi det er mellemrummene man får når man dividerer med 0.55 og ikke antal spær.
            spærAntal = (int) Math.ceil((Length+30)/55) + 1;

        }else{
            ////spær placeres 55 cm fra hinanden. +1 fordi det er mellemrummene man får når man dividerer med 0.55 og ikke antal spær.

            spærAntal = (int) Math.ceil((Length+30)/89) + 1;

        }

        antalBeslag = spærAntal*2;

        //Sammenlagt pris af beslag - prisPrM
        int price = antalBeslag*pricePrStk;

        Wood UniBeslag = new Wood(name, price, antalBeslag);
        return UniBeslag;
    }

    public static Wood getBræddeBolt(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("BræddeBolt");
        int pricePrStk = wood.getPricePrM();
        String name = wood.getWoodName();

        Request request = RequestMapper.getRequest4Styklist(id);
        int skurLength = request.getShedLength();
        int skurWidth = request.getShedWidth();
        int Length = request.getLength();
        int width = request.getWidth();
        int numOfBolte = 0;

        double lengthAsDouble = Length;

        //Længden er i cm, så vi gør den til meter. Der skal være to meter mellem hver stolpe og der skal være en stolpe på hver side så det er divideret med 2 gange med 2, hvilket betyder at vi ikke behøver skrive hverken eller.
        int numberOfPoles = (int) Math.ceil((lengthAsDouble/100) + 2);
        if(numberOfPoles % 2 != 0){
            numberOfPoles +=1;
        }

        //Carport uden skur
        if(skurLength==0){

            //Carport med skur
        }else{
            if(skurWidth==width && skurLength==Length){
                //+1 pæl til at hægte skur døren på. Alle andre pæle til at holde skurets vægge oppe er allerede i carporten
                numberOfPoles = numberOfPoles + 1;

            }
            if(skurWidth==width && skurLength!=Length){
                //3 pæle ekstra fordi skuret allerede har to støttepæle bagerst, men mangler to front støtte pæle og en pæl til at hægte skur døren på.
                numberOfPoles = numberOfPoles + 3;
            }
            if(skurWidth!=width && skurLength!=Length){
                //4 pæle ekstra fordi, skuret mangler i 3 hjørner og 1 pæl til at hægte døren på.
                numberOfPoles = numberOfPoles + 4;

            }

        }
        //Hver stolpe er 3 meter, fordi 100 cm af stolpen skal graves i jorden bagerst og 90 cm forrest, så taget får hældning(hvis det altså er en carport med fladt tag.
        numOfBolte = numberOfPoles*2;

        //Sammenlagt pris af pæle
        int price = (numOfBolte * pricePrStk);

        Wood pole = new Wood(name,price, (int) numOfBolte);

        return pole;
    }

    public static Wood getLøsBeslag(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("LøsholteBeslag");
        int pricePrStk = wood.getPricePrM();
        String name = wood.getWoodName();

        Request request = RequestMapper.getRequest4Styklist(id);
        int width = request.getWidth();
        int Length = request.getLength();
        int skurLength = request.getShedLength();
        int skurWidth = request.getShedWidth();
        double lengthAsDouble = Length;
        int numberOfPoles = 0;
        int numberOfPolesShed = 0;
        int numberOfBeslag = 0;

        numberOfPoles = (int) Math.ceil((lengthAsDouble/100) + 2);
        if(numberOfPoles % 2 != 0){
            numberOfPoles +=1;
        }

            if(skurWidth==width && skurLength==Length){

                numberOfPoles = numberOfPoles + 1;

                numberOfPolesShed = numberOfPoles;

                //4 beslag på hver pæl i skur
                numberOfBeslag = numberOfPolesShed * 4;


            }
            if(skurWidth==width && skurLength!=Length){
                //Det kan godt være at der kommer til at være nogle stolper  skuret, som ikke har beslag på i dette scenarie, men alle 4 hjørner og dør-stolpen har beslag.
                numberOfPolesShed = 5;
                numberOfBeslag = numberOfPolesShed * 4;
            }
            if(skurWidth!=width && skurLength!=Length){
                numberOfPolesShed = 5;
                numberOfBeslag = numberOfPolesShed * 4;

            }
            int price = pricePrStk * numberOfBeslag;

        Wood løsBeslag = new Wood(name, price, numberOfBeslag);

        return løsBeslag;
    }

    public static Wood getLægte(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("Lægte");
        int pricePrM = wood.getPricePrM();
        String name = wood.getWoodName();

        Request request = RequestMapper.getRequest4Styklist(id);
        //Taget hænger 15 cm ud over på hver side
        double length = 30 + request.getLength();
        double width = 30 + request.getWidth();
        int angle = request.getAngle();



        double hypotenusen = (width/2)/Math.cos(Math.toRadians(angle))/100;

        //307 mm mellem lægte rækker på tag
        int lægteRækker = (int) ( Math.ceil(hypotenusen/0.307) * 2 );

        int meters = (int) (lægteRækker * Math.ceil(length/100));
        int price = pricePrM * meters;

        Wood lægte = new Wood(name, price, meters);

        return lægte;
    }

    public static Wood getVindskede(int id) throws LoginSampleException {
        Wood wood = MaterialMapper.getWood("Vindskede");
        int pricePrM = wood.getPricePrM();
        String name = wood.getWoodName();

        Request request = RequestMapper.getRequest4Styklist(id);
        //Taget hænger 15 cm ud over på hver side
        double length = 30 + request.getLength();
        double width = 30 + request.getWidth();
        int skurlength = request.getShedLength();
        int angle = request.getAngle();
        int meters = 0;
        int price = 0;

        //Hvis carporten har et skur skal der 5 meter træ til z'et bag på døren
        if(skurlength!= 0){
            meters = meters + 5;
        }

        if(angle == 0){
            meters = (int) Math.ceil(length/100 * 2 + width/100 * 2);

        }else{
            double hypotenusen = (width/2)/Math.cos(Math.toRadians(angle))/100;
            meters = (int) Math.ceil(length/100 * 2 + hypotenusen * 4);

        }
        price = meters * pricePrM;
        Wood vindskede = new Wood(name,price, meters);

        return vindskede;
    }

}
