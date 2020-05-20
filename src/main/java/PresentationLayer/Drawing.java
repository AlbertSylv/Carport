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
        int vinkel = (int) Calculator.getVinkel(length);
        int angel = req.getAngle();
        int offset = 100;

        int outHang = 30;        //outhang er 15 cm på hver side det vil sige at sammen lagt er der 30 cm ekstra lodret og vandret
        int y = 0;
        int u= 0;
        int u2=0;
        int u3=0;
        int a=10;
        int height=200;
        //udregning for hvad mellemrummet skal være imellem hver spær på taget og hvor mange spær der skal til
        double lengthPlusOuthang= length + outHang;
        int spærAntal = (int) (1 + Math.ceil(lengthPlusOuthang / 55));
        int spærMellemrum = (int) (lengthPlusOuthang/(spærAntal - 1));
        double shedLengthAsDouble = shedLength;
        int shedSpærAntal = (int) (1+Math.ceil(shedLengthAsDouble/55));
        int shedSpærMellemrum = (int) (shedLengthAsDouble/(shedSpærAntal-1));

        Svg svg = new Svg(1000, 1000, "0,0,1000,1000",0,0);
        Svg sideSvg = new Svg(1000, 1000, "0,0,1000,1000",1000, 0);

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
            sideSvg.addPole(offset+outHang/2+y, offset+10, height, 4);
            sideSvg.addLine(offset+outHang/2+y, offset+225 , 50 , 1);

            y += length/(poles/2-1);
    }

        for (int i =0; i<spærAntal; i++) {  //tilføjer spær til taget og linjer til afstand mellem spærne

            svg.addRect(offset+u, offset, width+outHang, 4);
            svg.addLine(offset+u,25 , 50, 1);//linje til afstand af spær

            u+=spærMellemrum;
        }

        for (int i =0; i<spærAntal-1; i++) {
            svg.addArrowLine(offset+u2, 50, offset+spærMellemrum+u2, 50);
            svg.addText(offset+u2+spærMellemrum/2, 35, 0, spærMellemrum);
            u2+=spærMellemrum;
        }



        //lodrette mål
        svg.addLine(25, offset, 1, 50);
        svg.addArrowLine(50, offset, 50, offset+width+outHang);
        svg.addLine(25,offset+width+outHang,1, 50);
        svg.addText(35, (offset+width+outHang)/2, -90, width+outHang);

        //vandrette mål
        svg.addLine(offset, offset+width+outHang+25, 50, 1);
        svg.addArrowLine(offset, offset+width+outHang+50,offset+length+outHang , offset+width+outHang+50);
        svg.addLine(offset+length+outHang,offset+width+outHang+25,50,1);
        svg.addText((offset+length+outHang)/2, offset+width+outHang+35, 0, length+outHang);


        //
        //
        //
        //Svg SIDEVIEW
        //
        //
        //




if(vinkel<1){
    vinkel=1;
}

        if(shedLength>0){
            sideSvg.addShed(offset+length+outHang-shedLength-outHang/2,offset+10,200, shedLength);
        }

        for(int i = 0; i<shedSpærAntal; i++){

            sideSvg.addRect(offset+length+outHang-shedLength-outHang/2+u3, offset+10, 200, 4);
            u3+=shedSpærMellemrum;
        }


        // if(){} metode her for at vælge tag
            sideSvg.addRoof(offset, offset, 15, length + outHang, vinkel);
            sideSvg.addRoof(offset, offset - 15, 15, length + outHang, vinkel);

       /* sideSvg.addLine(offset, offset+225, 50, 1);
        sideSvg.addArrowLine(offset, offset+250, length+outHang+offset, offset+250);

        sideSvg.addLine(offset+length+outHang, offset+225, 50, 1);*/









        request.setAttribute("svgdrawing", svg.toString()+sideSvg.toString() );
        return "drawing";
    }
}