package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "createRequest", new CreateRequest() );
        commands.put( "employeepage", new Employeepage() );
        commands.put( "customerpage", new Customerpage() );
        commands.put( "fladtTagMedSkur", new fladtTagMedSkur() );
        commands.put( "fladtTagUdenSkur", new fladtTagUdenSkur());
        commands.put( "Rejsning", new Rejsning());
        commands.put( "RejsningSkur", new RejsningSkur());

    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "taget" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
