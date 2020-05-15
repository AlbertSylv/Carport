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
        int shedID = Integer.parseInt(request.getParameter("shedclothing"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        MaterialFacade.updateTRC(shedID,name,price);

        List<ShedClothing> shedclothings = new ArrayList<ShedClothing>();


        shedclothings = MaterialFacade.getShedclothing();

        HttpSession session = request.getSession();

        session.setAttribute("shedclothings",shedclothings);


        return "UpdateNameAndPrice";
    }
}
