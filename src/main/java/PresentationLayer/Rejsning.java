package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Rejsning extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        List<TiltedRoofCoating> tiltedroofcoatings = new ArrayList<TiltedRoofCoating>();
        tiltedroofcoatings= MaterialFacade.getTiltedRoofCoating();
        HttpSession session = request.getSession();
        session.setAttribute("tiltedroofcoatings", tiltedroofcoatings);

        List<ShedClothing> shedclothing = new ArrayList<ShedClothing>();
        shedclothing= MaterialFacade.getShedclothing();
        session.setAttribute("shedclothing",shedclothing);

        return "Rejsning";
    }
}
