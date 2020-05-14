package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static FunctionLayer.Calculator.*;

public class Stykliste extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int id = Integer.parseInt(request.getParameter("id"));
        Wood pole = getPole(id);
        Wood spær = getSpær(id);
        ShedClothing clothing = getClothing(id);
        RoofCoating RC = getTag(id);
        TiltedRoofCoating TRC = getRejsningTag(id);
        Wood uniBeslag = getUniBeslag(id);
        Wood bræddeBolt = getBræddeBolt(id);
        Wood vindskede = getVindskede(id);
        Wood regel = null;
        Wood løsBeslag = null;
        Wood lægte = null;
        int regelP = 0;
        int hulbåndP = 0;
        int beslagskruerpris = 167;
        int VSskruer = 1;
        int VSskruePris = 75;
        int håndtagP = 0;
        int TLskruePris = 0;
        int løsBeslagP = 0;
        int lægteP = 0;

        Request req = RequestMapper.getRequest4Styklist(id);

        HttpSession session = request.getSession();
        session.setAttribute("pole", pole);
        session.setAttribute("spær", spær);

        session.setAttribute("clothing", clothing);
        session.setAttribute("vindskede", vindskede);

        session.setAttribute("req", req);



        session.setAttribute("uniBeslag",uniBeslag);
        session.setAttribute("bræddeBolt", bræddeBolt);

        session.setAttribute("VSskruer",VSskruer);
        session.setAttribute("VSskruepris", VSskruePris);


        //Fordi jeg ikke gider at lære jsp er jeg nød til at nulstille alle session attributes før if statements så sessionen ikke husker tingene når man går ind på en anden stykliste.


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
            session.setAttribute("brFT","<br>");
            hulbåndP = 400;
        } else {
            session.setAttribute("tag", TRC);
            session.setAttribute("lægteoverskrift", "Lægte");
            session.setAttribute("navn", "Navn: ");
            session.setAttribute("meter", "Meter: ");
            session.setAttribute("antal", "Antal: ");
            session.setAttribute("pris", "Pris: ");

            lægte = getLægte(id);
            lægteP = lægte.getPrice();
            session.setAttribute("lægte", lægte);

            session.setAttribute("TLskruer", "5,0x100 mm. skruer (taglægter)");
            session.setAttribute("TLskruePakker", "2 pakker af 200");
            session.setAttribute("TLskruePris", "340 kr");
            TLskruePris = 340;
        }


        if(req.getShedLength()!=0){
            session.setAttribute("håndtagN","Stalddørgreb galv. 50-75 mm dørtykkelse og T-hængsler 390 mm galv. ");
            session.setAttribute("håndtagP","280 kr");
            session.setAttribute("håndtagA","1 sæt");
            håndtagP = 280;
            session.setAttribute("VSskruer",4);
            VSskruer = 4;
            regel = getRegel(id);
            regelP = regel.getPrice();
            løsBeslag = getLøsBeslag(id);
            løsBeslagP = løsBeslag.getPrice();
            session.setAttribute("løsBeslag", løsBeslag);
            session.setAttribute("regel", regel);
            session.setAttribute("regelOverskrift","Regel som løsholter til skur");
            session.setAttribute("NavnMS","Navn: ");
            session.setAttribute("AntalMS","Antal: ");
            session.setAttribute("PrisMS","Pris: ");
            session.setAttribute("KrMS"," kr");
            session.setAttribute("hrMS","<hr>");
            session.setAttribute("brMS", "<br>");


        }


        int sum = beslagskruerpris + pole.getPrice() + spær.getPrice() + regelP + clothing.getPrice() + RC.getPrice() + TRC.getPrice() + uniBeslag.getPrice() + bræddeBolt.getPrice() + vindskede.getPrice() + hulbåndP + (VSskruer*VSskruePris) + lægteP + løsBeslagP;
        session.setAttribute("sum",sum);

        return "stykliste";
    }
}
