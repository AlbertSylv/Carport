package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class fladtTag extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        List<RoofCoating> roofcoatings = new ArrayList<RoofCoating>();
        roofcoatings= MaterialFacade.getRoofCoatings();
        HttpSession session = request.getSession();
        session.setAttribute("roofcoatings", roofcoatings);

        List<ShedClothing> shedclothing = new ArrayList<ShedClothing>();
        shedclothing= MaterialFacade.getShedclothing();
        session.setAttribute("shedclothing",shedclothing);

        return "fladtTag";
    }
}
