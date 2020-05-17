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
        int offset = 100;

        int outHang = 30;        //outhang er 15 cm på hver side det vil sige at sammen lagt er der 30 cm ekstra lodret og vandret
        int y = 0;
        int u= 0;
        int a=10;
        //udregning for hvad mellemrummet skal være imellem hver spær på taget og hvor mange spær der skal til
        double lengthPlusOuthang= length + outHang;
        int spærAntal = (int) (1 + Math.ceil(lengthPlusOuthang / 55));
        int spærMellemrum = (int) (lengthPlusOuthang/(spærAntal - 1));

        Svg svg = new Svg(1000, 1000, "0,0,1000,1000",0,0);
        Svg svgInnerDrawing = new Svg(900,800,"0,0,900,800",0,0);
        svg.addRect(offset,offset ,width+outHang ,length+outHang);





        if(shedLength > 0){ //Shed building
            svg.addShed(offset+length+outHang-shedLength-outHang/2,offset+outHang/2,shedWidth, shedLength);
            svg.addPole(offset+length+outHang-shedLength-outHang/2,offset+outHang/2+shedWidth/2,4, 4);
            svg.addPole(offset+length+outHang-outHang/2,offset+outHang/2+shedWidth/2,4, 4);
            svg.addPole(offset+length+outHang-shedLength-outHang/2,offset+outHang/2,4, 4);
            svg.addPole(offset+length+outHang-shedLength-outHang/2,offset+shedWidth+outHang/2,4, 4);

          if(shedWidth<width){ // tilføjer pæle til shed hvis den er kortere end brædten på carporten

              svg.addPole(offset+length+outHang-shedLength-outHang/2,offset+outHang/2+shedWidth,4, 4);
              svg.addPole(offset+length+outHang-shedLength-outHang/2,offset+outHang/2,4,4);
              svg.addPole(offset+length+outHang-outHang/2,offset+outHang/2+shedWidth,4,4);

            }

        }
        // sætter spær på siderne af carporten
        svg.addRect(offset,offset+outHang/2,4,length+outHang);
        svg.addRect(offset,offset+width+outHang/2,4,length+outHang);

        for ( int i = 0; i < poles/2; i++) {        // for each loop sætter pælene ind i tegningen

            svg.addPole(offset+outHang/2+y,offset+outHang/2,4,4 );
            svg.addPole(offset+outHang/2+y,offset+width+outHang/2,4, 4);

            y += length/(poles/2-1);
    }

        for (int i =0; i<spærAntal; i++) {  //tilføjer spær til taget

            svg.addRect(offset+u, offset, width+outHang, 4);
            svg.addLine(offset+u,25 , 50, 1);
            u+=spærMellemrum;
        }

        for (int i = 0; i < spærAntal; i++
             ) {

        }



        svg.addLine(25, offset, 1, 50);
        svg.addLine(25, offset+width+outHang, 1, 50);
        svg.addLine(50, offset, width+outHang,1);
        svg.addLine(offset, offset+length+outHang+ 25, 1, length+outHang);

        svg.addLine(offset,offset+width+outHang+25,50,1);
        svg.addLine(offset+length+outHang,offset+width+outHang+25,50,1);













        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}