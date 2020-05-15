package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MaterialFacade;
import FunctionLayer.TiltedRoofCoating;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UpdateTRC extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //tag med rejsning
        int tiltedroofID = Integer.parseInt(request.getParameter("tiltedroof"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        MaterialFacade.updateTRC(tiltedroofID,name,price);

        List<TiltedRoofCoating> tiltedroofcoatings = new ArrayList<TiltedRoofCoating>();
        tiltedroofcoatings= MaterialFacade.getTiltedRoofCoating();

        HttpSession session = request.getSession();
        session.setAttribute("tiltedroofcoatings", tiltedroofcoatings);


        return "UpdateNameAndPrice";
    }
}
