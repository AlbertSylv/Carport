package PresentationLayer;

import FunctionLayer.*;

import DBAccess.MaterialMapper;
import DBAccess.RequestMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int id = Integer.parseInt(request.getParameter( "id" ));
        Request req =  RequestFacade.getRequest4Styklist(id);

        int poles = Calculator.getPoles(id) ;

        int offset = 100;
        int length = req.getLength();
        int width = req.getWidth();
        int shedWidth = req.getShedWidth();
        int shedLength = req.getShedLength();
        Svg svg = new Svg(800, 600, "0,0,800,600",0,0);
        Svg svgInnerDrawing = new Svg(900,800,"0,0,900,800",0,0);
        svg.addRect(offset,0,length ,width);
        svg.addRect(offset,35,4,width);
        svg.addRect(offset,length-35,4,width);
        int y = 10;
        int a=10;
        for ( int i = 0; i < poles/2; i++) {

        svg.addRect(offset+y,35,4,4 );
            y += 10;
        }



        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}