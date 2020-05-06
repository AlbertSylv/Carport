package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.RequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Bestillinger extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Request> bestillinger= RequestFacade.getRequests();
        HttpSession session = request.getSession();
        session.setAttribute("bestillinger", bestillinger);
        return "bestillinger";
    }
}
