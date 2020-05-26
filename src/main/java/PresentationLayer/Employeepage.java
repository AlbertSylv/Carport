package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.RequestFacade;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Employeepage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        return "employeepage";
    }
}
