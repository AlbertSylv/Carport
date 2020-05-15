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
        int poleSpace= 200;
        int offset = 0;
        int length = req.getLength();
        int width = req.getWidth();
        //outhang er 15 cm på hver side det vil sige at sammen lagt er der 30 cm ekstra lodret og vandret
        int outHang = 30;
        int y = 0;
        int a=10;
        int shedWidth = req.getShedWidth();
        int shedLength = req.getShedLength();
        Svg svg = new Svg(1000, 1000, "0,0,1000,1000",0,0);
        Svg svgInnerDrawing = new Svg(900,800,"0,0,900,800",0,0);
        svg.addRect(offset,0,width+outHang ,length+outHang);
        svg.addRect(offset,outHang/2,4,length+outHang);
        svg.addRect(offset,width+outHang/2,4,length+outHang);

        // for each loop sætter pælene ind i tegningen
        for ( int i = 0; i < poles/2; i++) {

        svg.addPole(offset+outHang/2+y,outHang/2,4,4 );
        svg.addPole(offset+outHang/2+y,width+outHang/2,4, 4);

            //y får fastast to meters afstand mellem pællene trækker antalpælle på den eneside divideret med pællepå den eneside divideret med sig selv minus en.
            // Det er for at tage højde for at pælene på tegningen er 4x4.

            y += length/(poles/2-1);

        }





        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}