package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int roofID = Integer.parseInt(request.getParameter("roof"));
        int tiltedroofID = Integer.parseInt(request.getParameter("tiltedroof"));

        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        int shedID = Integer.parseInt(request.getParameter("shedclothing"));
        int angle = Integer.parseInt(request.getParameter("angle"));
        String note = request.getParameter("note");
        String email = request.getParameter("email");

        LogicFacade.createRequest(roofID, tiltedroofID, shedID, width, length, shedWidth, shedLength, angle, note, email);

        Request req = null;
        req = LogicFacade.getRequest(email);

        HttpSession session = request.getSession();
        session.setAttribute("req", req);
return "confirmation";
    }

}
