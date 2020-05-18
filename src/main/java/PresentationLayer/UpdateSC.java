package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialFacade;
import FunctionLayer.ShedClothing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UpdateSC extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //skur beklædning
        int shedID = Integer.parseInt(request.getParameter("shedclothings"));
        String name = request.getParameter("SCname");
        int price = Integer.parseInt(request.getParameter("SCprice"));
        name = name.replaceAll("Ã¦","æ");
        name = name.replaceAll( "Ã¸","ø");
        name = name.replaceAll("Ã¥","å");

        MaterialFacade.updateSC(shedID,name,price);

        List<ShedClothing> shedclothings = new ArrayList<ShedClothing>();


        shedclothings = MaterialFacade.getShedclothing();

        HttpSession session = request.getSession();

        session.setAttribute("shedclothings",shedclothings);


        return "UpdateNameAndPrice";
    }
}
