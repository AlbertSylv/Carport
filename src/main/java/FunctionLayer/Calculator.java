package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.RequestMapper;

import java.util.ArrayList;

public class Calculator {

    public static Wood getPole(int id) throws LoginSampleException {

        Request request = null;

        Wood wood = MaterialMapper.getWood("Pæl");
        int pricePrM = wood.getPricePrM();
        String name = wood.getWoodName();


        request = RequestMapper.getRequest4Styklist(id);
        int shedheight = 2;
        int skurLength = request.getShedLength();
        int skurWidth = request.getShedWidth();
        int Length = request.getLength();
        int width = request.getWidth();
        double metersOfPole = 0;
        int angle = request.getAngle();


        double lengthAsDouble = Length;



        //Længden er i cm, så vi gør den til meter. Der skal være to meter mellem hver stolpe og der skal være en stolpe på hver side så det er divideret med 2 gange med 2, hvilket betyder vi ikke behøver at skrive hverken eller.
        int numberOfPoles = (int) Math.ceil((lengthAsDouble/100) + 2);
        if(numberOfPoles % 2 != 0){
            numberOfPoles +=1;
        }
        System.out.println(numberOfPoles);




        //Carport med skur
        if(skurLength!=0){

        //Carport uden skur
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

        return pole;
    }
}
