package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.RequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int roofID = Integer.parseInt(request.getParameter("roof"));
        int tiltedroofID = Integer.parseInt(request.getParameter("tiltedroof"));

        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedID = Integer.parseInt(request.getParameter("shedclothing"));
        int angle = Integer.parseInt(request.getParameter("angle"));
        String note = request.getParameter("note");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        session.setAttribute("SCwarning",null);
        session.setAttribute("Wwarning",null);
        session.setAttribute("Lwarning",null);
        if(shedID==1 && shedLength!=0 || shedID==1 && shedWidth!=0){
            shedID=2;
            session.setAttribute("SCwarning","Hov! Dit skur skal have en beklædning! Vi har valgt 21X85 MM BLOKHUSBRÆDDER FYR MED VEKSELFALS for dig.");

            Log.info("Der er ikke blevet valgt skurbeklædning.");


        }
        if(shedWidth>width){
            shedWidth=width;
            session.setAttribute("Wwarning","Hov! Dit skur kan ikke være bredere end din carport! Dit skurs bredde er sat ned, så den matcher din carports bredde.");

            Log.info("Skurets bredde overskreddet. " + "Ændret til: " + shedWidth);

        }
        if(shedLength>length){
            shedLength=length;
            session.setAttribute("Lwarning","Hov! Dit skur kan ikke være længere end din carport! Dit skurs længde er sat ned, så den matcher din carports længde.");

            Log.info("Skurets længde overskreddet. " + "Ændret til: " + shedLength);


        }
        if(shedLength==0 && shedWidth!=0 || shedLength==0 && shedID>1){
            shedLength=150;
            session.setAttribute("Lwarning","Hov! Dit skurs længde kan ikke være 0 og er blevet sat op til minimum længden på 150 cm.");

            Log.info("Skur længde = 0");


        }
        if(shedWidth==0 && shedLength!=0 || shedWidth==0 && shedID>1){
            session.setAttribute("Wwarning","Hov! Dit skurs bredde kan ikke være 0 og er blevet sat op til minimum bredden på 210 cm.");
            shedWidth=210;

            Log.info("Skur bredde = 0");


        }

        RequestFacade.createRequest(roofID, tiltedroofID, shedID, width, length, shedWidth, shedLength, angle, note, email);

        Request req = null;
        req = RequestFacade.getRequest(email);


        session.setAttribute("req", req);
        return "confirmation";
    }

}
