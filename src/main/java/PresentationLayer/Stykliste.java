package PresentationLayer;

import FunctionLayer.Calculator;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Wood;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Stykliste extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int id = Integer.parseInt(request.getParameter("id"));
        Wood pole = Calculator.getPole(id);

        HttpSession session = request.getSession();
        session.setAttribute("pole", pole);

        return "stykliste";
    }
}
