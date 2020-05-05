package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDeleteRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int id = Integer.parseInt(request.getParameter("ID"));
            RequestMapper.adminDeleteRequest(id);

        ArrayList<Request> bestillinger= LogicFacade.getRequests();
        HttpSession session = request.getSession();
        session.setAttribute("bestillinger", bestillinger);

        return "bestillinger";
    }
}
