package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterEmployee extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String name  = request.getParameter("name");
        String address = request.getParameter("address");
        String zipCity = request.getParameter("zipCity");
        String phone = request.getParameter("phone");
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
       if ( password1.equals( password2 ) ) {
           UserFacade.createEmployeeUser( email, password1,name,address,zipCity,phone );
           User user = UserFacade.login(email,password1,name,address,zipCity,phone);

           HttpSession session = request.getSession();

           session.setAttribute("name", user.getName());
            session.setAttribute("email",user.getEmail());
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {

           Log.info("Registrering af Employee: " + "Password matchede ikke");

            throw new LoginSampleException( "Indtastede passwords matchede ikke - prøv igen" );
        }
    }

}
