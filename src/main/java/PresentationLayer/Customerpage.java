package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Customerpage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        List<RoofCoating> roofcoatings = new ArrayList<RoofCoating>();
        roofcoatings= LogicFacade.getRoofCoatings();

        List<TiltedRoofCoating> tiltedroofcoatings = new ArrayList<TiltedRoofCoating>();
        tiltedroofcoatings= LogicFacade.getTiltedRoofCoating();

        ArrayList<FunctionLayer.Rejsning> rejsning = new ArrayList<>();
        rejsning= LogicFacade.getRejsning();

        ArrayList<FunctionLayer.RejsningSkur> rejsningSkur = new ArrayList<>();
        rejsningSkur = LogicFacade.getRejsningSkur();

        ArrayList<FladtTag> fladtTag = new ArrayList<>();
        fladtTag = LogicFacade.getFladtTag();

        ArrayList<FladtTagSkur> fladtTagSkur = new ArrayList<>();
        fladtTagSkur = LogicFacade.getFladtTagSkur();



        HttpSession session = request.getSession();
        session.setAttribute("roofcoatings", roofcoatings);
        session.setAttribute("tiltedroofcoatings", tiltedroofcoatings);
        session.setAttribute("rejsning", rejsning);
        session.setAttribute("rejsningskur", rejsningSkur);
        session.setAttribute("fladtTag", fladtTag);
        session.setAttribute("fladtTagSkur", fladtTagSkur);

        return "customerpage";
    }
}


