package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.RoofCoating;
import FunctionLayer.TiltedRoofCoating;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Customerpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        List<RoofCoating> roofcoatings = new ArrayList<RoofCoating>();
        roofcoatings= LogicFacade.getRoofCoatings();
        List<TiltedRoofCoating> tiltedroofcoatings = new ArrayList<TiltedRoofCoating>();


        HttpSession session = request.getSession();
        session.setAttribute("roofcoatings", roofcoatings);
        session.setAttribute("tiltedroofcoatings", tiltedroofcoatings);

        return "customerpage";
    }
}
