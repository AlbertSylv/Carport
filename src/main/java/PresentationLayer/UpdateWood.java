package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialFacade;

import FunctionLayer.Wood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


public class UpdateWood extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String type = request.getParameter("woods");
        String name = request.getParameter("name");

        //note to self - lad vær med at putte danske bogsytaver i koden.
        type = type.replaceAll("Ã¦","æ");
        type = type.replaceAll( "Ã¸","ø");
        type = type.replaceAll("Ã¥","å");
        name = name.replaceAll("Ã¦","æ");
        name = name.replaceAll( "Ã¸","ø");
        name = name.replaceAll("Ã¥","å");
        int price = Integer.parseInt(request.getParameter("price"));

        MaterialFacade.updateWood(type,name,price);

        ArrayList<Wood> Woods = new ArrayList<Wood>();
        Woods= MaterialFacade.getWoods();

        HttpSession session = request.getSession();
        session.setAttribute("woods", Woods);


        return "UpdateNameAndPrice";
    }
}
