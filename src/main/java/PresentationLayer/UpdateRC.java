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
        //hent ny RC
        int roofID = Integer.parseInt(request.getParameter("roof"));
        String name = request.getParameter("RCname");
        int price = Integer.parseInt(request.getParameter("RCprice"));
        name = name.replaceAll("Ã¦","æ");
        name = name.replaceAll( "Ã¸","ø");
        name = name.replaceAll("Ã¥","å");

        //opdater
        MaterialFacade.updateRC(roofID,name,price);

        //hent liste med opdateret produkt
        List<RoofCoating> roofcoatings = new ArrayList<RoofCoating>();
        roofcoatings= MaterialFacade.getRoofCoatings();


        HttpSession session = request.getSession();
        session.setAttribute("roofcoatings", roofcoatings);





        return "UpdateNameAndPrice";
    }
}
