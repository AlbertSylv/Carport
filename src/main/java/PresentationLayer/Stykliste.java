package PresentationLayer;

import DBAccess.RequestMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Stykliste extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int id = Integer.parseInt(request.getParameter("id"));
        Wood pole = Calculator.getPole(id);
        Wood spær = Calculator.getSpær(id);
        Wood regel = Calculator.getRegel(id);
        ShedClothing clothing = Calculator.getClothing(id);
        RoofCoating RC = Calculator.getTag(id);
        TiltedRoofCoating TRC = Calculator.getRejsningTag(id);

        Request req = RequestMapper.getRequest4Styklist(id);


        HttpSession session = request.getSession();
        session.setAttribute("pole", pole);
        session.setAttribute("spær", spær);
        session.setAttribute("regel", regel);
        session.setAttribute("clothing", clothing);

        //Tag type bestemmer
        if(req.getAngle()==0) {
            session.setAttribute("tag", RC);
        } else {
            session.setAttribute("tag", TRC);
        }


        return "stykliste";
    }
}
