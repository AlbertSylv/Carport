package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Stykliste extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int id = Integer.parseInt(request.getParameter("id"));
        Wood pole = Calculator.getPole(id);
        Wood spær = Calculator.getSpær(id);
        Wood regel = Calculator.getRegel(id);
        ShedClothing clothing = Calculator.getClothing(id);
        RoofCoating RC = Calculator.getTag(id);
        TiltedRoofCoating TRC = Calculator.getRejsningTag(id);
        Wood uniBeslag = Calculator.getUniBeslag(id);
        Wood bræddeBolt = Calculator.getBræddeBolt(id);


        Wood vindskede = Calculator.getVindskede(id);

        Request req = RequestMapper.getRequest4Styklist(id);


        HttpSession session = request.getSession();
        session.setAttribute("pole", pole);
        session.setAttribute("spær", spær);
        session.setAttribute("regel", regel);
        session.setAttribute("clothing", clothing);
        session.setAttribute("vindskede", vindskede);

        session.setAttribute("req", req);



        session.setAttribute("uniBeslag",uniBeslag);
        session.setAttribute("bræddeBolt", bræddeBolt);

        session.setAttribute("VSskruer",1);
        session.setAttribute("VSskruepris", 75);


        //Fordi jeg ikke gider at lære jsp er jeg nød til at sætte alle session attributes før if statementet så sessionen ikke husker tingene når man går ind på en anden stykliste.
        session.setAttribute("tag", RC);
        session.setAttribute("navnFT", null);
        session.setAttribute("antalFT", null);
        session.setAttribute("prisFT", null);
        session.setAttribute("hulbåndN", null);
        session.setAttribute("hulbåndA", null);
        session.setAttribute("hulbåndP", null);
        session.setAttribute("tag", null);
        session.setAttribute("lægteoverskrift", null);
        session.setAttribute("navn", null);
        session.setAttribute("meter", null);
        session.setAttribute("antal", null);
        session.setAttribute("pris", null);
        session.setAttribute("lægte", null);
        session.setAttribute("TLskruer", null);
        session.setAttribute("TLskruePakker", null);
        session.setAttribute("TLskruePris", null);
        session.setAttribute("håndtagN",null);
        session.setAttribute("håndtagP",null);
        session.setAttribute("håndtagA",null);
        session.setAttribute("VSskruer",null);
        session.setAttribute("løsBeslag", null);
        session.setAttribute("NavnMS", null);
        session.setAttribute("AntalMS",null);
        session.setAttribute("PrisMS",null);
        session.setAttribute("KrMS",null);
        //Tag type bestemmer
        if(req.getAngle()==0) {
            session.setAttribute("tag", RC);
            session.setAttribute("navnFT", "Navn: ");
            session.setAttribute("antalFT", "Antal: ");
            session.setAttribute("prisFT", "Pris: ");
            session.setAttribute("hulbåndN", "Hulbånd 1x20 mm. 10 mtr.");
            session.setAttribute("hulbåndA", "2 ruller");
            session.setAttribute("hulbåndP", "400 kr");
        } else {
            session.setAttribute("tag", TRC);
            session.setAttribute("lægteoverskrift", "Lægte");
            session.setAttribute("navn", "Navn: ");
            session.setAttribute("meter", "Meter: ");
            session.setAttribute("antal", "Antal: ");
            session.setAttribute("pris", "Pris: ");

            Wood lægte = Calculator.getLægte(id);
            session.setAttribute("lægte", lægte);

            session.setAttribute("TLskruer", "5,0x100 mm. skruer (taglægter)");
            session.setAttribute("TLskruePakker", "2 pakker af 200");
            session.setAttribute("TLskruePris", "340 kr");
        }


        if(req.getShedLength()!=0){
            session.setAttribute("håndtagN","Stalddørgreb galv. 50-75 mm dørtykkelse og T-hængsler 390 mm galv. ");
            session.setAttribute("håndtagP","280 kr");
            session.setAttribute("håndtagA","1 sæt");
            session.setAttribute("VSskruer",4);

            Wood løsBeslag = Calculator.getLøsBeslag(id);
            session.setAttribute("løsBeslag", løsBeslag);

            session.setAttribute("NavnMS","Navn: ");
            session.setAttribute("AntalMS","Antal: ");
            session.setAttribute("PrisMS","Pris: ");
            session.setAttribute("KrMS"," kr");


        }
        String sum = "7 milliarder boi";
        session.setAttribute("sum",sum);

        return "stykliste";
    }
}
