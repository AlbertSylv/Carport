package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        String roof = request.getParameter("roof");
        String shedClothing = request.getParameter("shedClothing");
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int angle = Integer.parseInt(request.getParameter("angle"));
        String note = request.getParameter("note");
        String email = request.getParameter("email");
        //Mangler email og note


        LogicFacade.createRequest(roof, shedClothing, width, length, shedWidth, shedLength, angle, note, email);
return "customerpage";
    }

}
