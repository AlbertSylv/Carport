package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UpdateRC extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //hent ny TRC
        int roofID = Integer.parseInt(request.getParameter("roof"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        //opdater
        MaterialFacade.updateTRC(roofID,name,price);

        //hent liste
        List<RoofCoating> roofcoatings = new ArrayList<RoofCoating>();
        roofcoatings= MaterialFacade.getRoofCoatings();


        HttpSession session = request.getSession();
        session.setAttribute("roofcoatings", roofcoatings);





        return "UpdateNameAndPrice";
    }
}
