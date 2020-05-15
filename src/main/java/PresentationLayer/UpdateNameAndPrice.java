package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UpdateNameAndPrice extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //Definer tag med rejsning arraylist
        List<TiltedRoofCoating> tiltedroofcoatings = new ArrayList<TiltedRoofCoating>();
        tiltedroofcoatings= MaterialFacade.getTiltedRoofCoating();

        //Definer skur beklædning arraylist
        List<ShedClothing> shedclothings = new ArrayList<ShedClothing>();
        shedclothings= MaterialFacade.getShedclothing();

        //Definer fladt tag arraylist
        List<RoofCoating> roofcoatings = new ArrayList<RoofCoating>();
        roofcoatings= MaterialFacade.getRoofCoatings();

        HttpSession session = request.getSession();
        session.setAttribute("tiltedroofcoatings", tiltedroofcoatings);
        session.setAttribute("shedclothings",shedclothings);
        session.setAttribute("roofcoatings", roofcoatings);

        return "UpdateNameAndPrice";
    }
}
