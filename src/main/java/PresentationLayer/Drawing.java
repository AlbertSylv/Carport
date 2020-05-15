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
        int shedWidth = req.getShedWidth();
        int shedLength = req.getShedLength();
        int poles = Calculator.getPoles(id) ;
        int length = req.getLength();
        int width = req.getWidth();
        int offset = 0;

        //outhang er 15 cm på hver side det vil sige at sammen lagt er der 30 cm ekstra lodret og vandret
        int outHang = 30;
        int y = 0;
        int a=10;
        int spærAfstand = 0;
        double spærAntal = ((length+outHang)/55);

        Svg svg = new Svg(1000, 1000, "0,0,1000,1000",0,0);
        Svg svgInnerDrawing = new Svg(900,800,"0,0,900,800",0,0);
        svg.addRect(offset,0,width+outHang ,length+outHang);
        svg.addRect(offset,outHang/2,4,length+outHang);
        svg.addRect(offset,width+outHang/2,4,length+outHang);

        // for each loop sætter pælene ind i tegningen
        for ( int i = 0; i < poles/2; i++) {

        svg.addPole(offset+outHang/2+y,outHang/2,4,4 );
        svg.addPole(offset+outHang/2+y,width+outHang/2,4, 4);



            y += length/(poles/2-1);

        }
        svg.addRect(offset, 0, width+outHang,4);
        svg.addRect(offset+length+outHang,0,width+outHang,4);

        for (int i =0; i<spærAntal; i++) {

            svg.addRect(offset+spærAfstand, 0, width+outHang, 4);

            spærAfstand+=length/spærAntal;


        }






        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}