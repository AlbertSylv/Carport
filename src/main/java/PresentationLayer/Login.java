package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String name  = request.getParameter("name");
        String address = request.getParameter("address");
        String zipCity = request.getParameter("zipCity");
        String phone = request.getParameter("phone");
        String password = request.getParameter( "password" );
        User user = UserFacade.login( email, password, name, address, zipCity,phone);
        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke


        return user.getRole() + "page";
    }

}
