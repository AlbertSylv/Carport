package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialFacade;
import FunctionLayer.TiltedRoofCoating;
import FunctionLayer.Wood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UpdateWood extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String type = request.getParameter("type");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        MaterialFacade.updateWood(type,name,price);

        ArrayList<Wood> Woods = new ArrayList<Wood>();
        Woods= MaterialFacade.getWoods();

        HttpSession session = request.getSession();
        session.setAttribute("woods", Woods);


        return "UpdateNameAndPrice";
    }
}
