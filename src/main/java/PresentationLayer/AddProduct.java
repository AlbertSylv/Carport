package PresentationLayer;

import DBAccess.MaterialMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProduct extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        if(type.equals("TRC")){
            MaterialFacade.insertTRC(name, price);

        }
        if(type.equals("RC")){
            MaterialFacade.insertRC(name, price);

        }
        if(type.equals("SC")){
            MaterialFacade.insertSC(name, price);

        }
        return "added";
    }
}
