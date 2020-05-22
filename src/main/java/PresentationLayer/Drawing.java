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
        int angle = req.getAngle();
        int offset = 250;
        double roofHeightDouble= Calculator.getRoofHeight(width, angle)*100;// *100 for at lave dem om til cm
        int roofHeight= (int) roofHeightDouble;
        int rejsAntalLægter = Calculator.getAntalLægterEnSide(width, angle);

        int rejsLægterMellemrum = (int) Calculator.getLægterMellemrumTopview(rejsAntalLægter, width, angle);

        int outHang = 30;        //outhang er 15 cm på hver side det vil sige at sammen lagt er der 30 cm ekstra lodret og vandret
        int y = 0;
        int u= 0;
        int u2=0;
        int u3=0;
        int a=0;
        int t=0;

        int height=200;


        //udregning for hvad mellemrummet skal være imellem hver spær på taget og hvor mange spær der skal til
        double lengthPlusOuthang= length + outHang;
        int spærAntal = (int) (1 + Math.ceil(lengthPlusOuthang / 55));
        int spærMellemrum = (int) (lengthPlusOuthang/(spærAntal - 1));
        double shedLengthAsDouble = shedLength;
        int shedSpærAntal = (int) (1+Math.ceil(shedLengthAsDouble/55));
        int shedSpærMellemrum = (int) (shedLengthAsDouble/(shedSpærAntal-1));
        int tagStregAntal = (int) (1+Math.ceil((length+outHang)/55));
        int tagStregMellemrum = (int) ((length+outHang)/(tagStregAntal-1));

        Svg svg = new Svg(1000, 1000, "0,0,1300,1300",0,0);
        Svg sideSvg = new Svg(1000, 1000, "0,0,1300,1300",1000, 0);

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
            sideSvg.addPole(offset+outHang/2+y, offset+10, height, 4);//tilføjer pæle til sideview
            sideSvg.addLine(offset+outHang/2+y, offset+225 , 50 , 1);//tilføjer linjer til bunden af sideview tegningen

            y += length/(poles/2-1);
    }


            for (int i = 0; i < spærAntal; i++) {  //tilføjer spær til taget og linjer til afstand mellem spærne

                svg.addRect(offset + u, offset, width + outHang, 4);
                svg.addLine(offset + u, offset-75, 50, 1);//linje til afstand af spær

                u += spærMellemrum;
            }
        if (angle>0) { //hvis tag med hældning

             for (int i = 0; i <= rejsAntalLægter; i++) {  //tilføjer vandrette spær til taget og linjer til afstand mellem spærne
                 svg.addRect(offset, offset+a,4,length+outHang);
                 svg.addRect(offset,offset+width+outHang-a,4,length+outHang);
                 a+=rejsLægterMellemrum;



            }
        }

        for (int i =0; i<spærAntal-1; i++) {  //tilføjer pile og afstands tekst mellem spærafstand
            svg.addArrowLine(offset+u2, offset-50, offset+spærMellemrum+u2, offset-50);
            svg.addText(offset+u2+spærMellemrum/2, offset-65, 0, spærMellemrum);
            u2+=spærMellemrum;
        }




        //lodrette mål
        svg.addLine(offset-75, offset, 1, 50);
        svg.addArrowLine(offset-50, offset, offset-50, offset+width+outHang);
        svg.addLine(offset-75,offset+width+outHang,1, 50);
        svg.addText(offset-55, offset+(width+outHang)/2, -90, width+outHang);

        //vandrette mål
        svg.addLine(offset, offset+width+outHang+25, 50, 1);
        svg.addArrowLine(offset, offset+width+outHang+50,offset+length+outHang , offset+width+outHang+50);
        svg.addLine(offset+length+outHang,offset+width+outHang+25,50,1);
        svg.addText(offset+(length+outHang)/2, offset+width+outHang+35, 0, length+outHang);


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

        //tilføjer tag
         if(angle==0) {
             sideSvg.addRoof(offset, offset, 15, length + outHang, vinkel);
             sideSvg.addRoof(offset, offset - 15, 15, length + outHang, vinkel);
         }else{
             sideSvg.addRoof(offset,offset-roofHeight,roofHeight,length + outHang, 0);//tag med hældning

             for (int i=0; i<((tagStregAntal*4));i++) { //tegner streget på taget for at få den til at se pænere ud
                 sideSvg.addLine(offset+t,offset-roofHeight,roofHeight,1);
                 t+=tagStregMellemrum/4;

             }
             sideSvg.addBlank(offset+length+outHang+9,offset-roofHeight-1,roofHeight+2,tagStregAntal*10);// fjerne unødvendige streger

             sideSvg.addRect(offset,offset-roofHeight-4,8, length+outHang);//vandret top rektangel på taget

             sideSvg.addRect(offset-4, offset-roofHeight-8, roofHeight-16, 8);//tilføjer rektangel på venstre side af taget
             sideSvg.addRect(offset+length+outHang-4, offset-roofHeight-8, roofHeight-16, 8);//tilføjer rektangel på højre side at taget

             sideSvg.addRect(offset+4, offset-roofHeight+roofHeight-8, 8, length+outHang-8);//tilføjer rektangel på bunden af taget
             sideSvg.addRect(offset+4, offset-roofHeight+roofHeight, 10, length+outHang-8);
             sideSvg.addRect(offset+outHang/2-2, offset-roofHeight+roofHeight+10, 10, length+4);//rektangel lige under taget neders


             //laver streger på taget for at få det til at se pænere ud, i stedet for at det er bare et tomt rektangel
         }


        // mål til venstre for carporten
        if (angle>0){
            sideSvg.addLine(offset-95, offset-roofHeight-5, 1, 80);//øverste linje
            sideSvg.addLine(offset-45, offset-roofHeight+roofHeight, 1, 30);//anden øverste linje





            sideSvg.addArrowLine(offset-70,offset-roofHeight-5,offset-70,offset+215);//yderste pil
            sideSvg.addText(offset-80, (offset-roofHeight+roofHeight+200+5)/2, -90, 200+5+roofHeight);//højde på hele carporten

            sideSvg.addArrowLine(offset-30, offset, offset-30, offset+215);//inderste pil
            sideSvg.addText(offset-40,offset-roofHeight+roofHeight+100,-90,200);//højde uden tag

            sideSvg.addLine(offset-95, offset+215, 1, 80);//nederste linje

            sideSvg.addLine(offset,offset+225,50,1);//linje på starten af carporten
            sideSvg.addLine(offset-100,offset+250,1,115);//mål linje
            sideSvg.addText(offset-60,offset+265,0,15);//mål


        }else {

            sideSvg.addLine(offset-100, offset-15, 1, 75);//øverste linje
            sideSvg.addLine(offset-50, offset, 1, 25);//anden øverste linje


            sideSvg.addLine(offset, offset + 225, 50, 1);//line på starten af carporten
            sideSvg.addLine(offset-100, offset + 250, 1, 115);//mål linje
            sideSvg.addText(offset-60, offset + 265, 0, 15);//mål


            sideSvg.addArrowLine(offset-75, offset - 15, offset-75, offset + 215);//yderste pil
            sideSvg.addText(offset-85, offset + 100, -90, 215);//højde på hele carporten

            sideSvg.addArrowLine(offset-38, offset, offset-38, offset + 215);//inderste pil
            sideSvg.addText(offset-48, offset + 100, -90, 200);//højde uden tag

            sideSvg.addLine(offset-100, offset + 215, 1, 75);//nederste linje

            //mål til højre for carporten
            sideSvg.addLine(offset + length + outHang + 25, offset, 1, 50);//øverste linje
            sideSvg.addArrowLine(offset + length + outHang + 50, offset, offset + length + outHang + 50, offset + 215);//pil
            sideSvg.addText(offset + length + outHang + 55, offset + 100, 90, 210);
            sideSvg.addLine(offset + length + outHang + 25, offset + 215, 1, 50);//nederste linje

        }
        //mål for bunden af tegningen
        sideSvg.addLine(offset, offset+215, 1, length+outHang);
        sideSvg.addArrowLine(offset+outHang/2, offset+250, offset+outHang/2+(y/(poles/2)), offset+250);//laver arrowline mellem to pæle
        sideSvg.addText(offset+outHang/2+(length/(poles/2-1)/2),offset+240,0,length/(poles/2-1));//tekst for hvor lang afstand der er mellem 2 pæle
        if(shedLength>0) {
            sideSvg.addBlank(offset + length + outHang/2- shedLength, offset + 224, 52, shedLength);//tilføjer et blank layer i bunden af svgSideview for at skjule stregerne som ikke burde være der
            sideSvg.addLine(offset + length + outHang/2 - shedLength, offset + 225, 50, 1);//linje i bunden til venster for skuret
            sideSvg.addArrowLine(offset + length + outHang/2 - shedLength, offset + 250, offset + length+outHang/2, offset + 250);//pilene mellem linjen
            sideSvg.addText(offset + length + outHang/2 - shedLength / 2, offset + 240, 0, shedLength);//tekst til pilen
            sideSvg.addLine(offset + length+outHang/2, offset + 225, 50, 1);//linje til højre for skuret


        }


        request.setAttribute("svgdrawing", svg.toString()+sideSvg.toString() );
        return "drawing";
    }
}