package FunctionLayer;

import com.sun.javafx.binding.StringFormatter;

public class Svg {

    private int width;
    private int height;
    private String viewbox;
    private int x;
    private int y;
    private StringBuilder svg = new StringBuilder();

    private final String headerTemplate = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" height=\"%s\" width=\"%s\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String rectTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String poleTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; stroke-width: 2px; fill: #ffffff\" />";
    private final String shedTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; stroke-width: 4px; fill: #ffffff\" />";
    private final String lineTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final String arrowDefsTemplate = "<defs><marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\"><path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" /></marker><marker \tid=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" \trefX=\"12\" refY=\"6\" orient=\"auto\"><path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" /></marker></defs>";
    private final String arrowTemplate = "<line x1=\"%d\"  y1=\"%d\" x2=\"%d\"   y2=\"%d\" style=\"stroke: #006600; marker-start: url(#beginArrow); marker-end: url(#endArrow);\"/>";
    private final String textTemplate = "<text  style=\"text-anchor: middle\" transform=\"translate(%d,%d) rotate(%d)\">%d cm</text>";
    private final String svgEnd = "</svg>";
    private final String roofTemplate = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" transform=\"rotate(%d)\" style=\"stroke:#000000; fill: #ffffff\" />";

    public Svg(int width, int height, String viewbox, int x, int y) {
        this.width = width;
        this.height = height;
        this.viewbox = viewbox;
        this.x = x;
        this.y = y;
        svg.append(String.format(headerTemplate, height, width, viewbox));
        svg.append(arrowDefsTemplate);
    }
    public void addShed(int x, int y, int height, int width){
        svg.append(String.format(shedTemplate, x, y, height, width));
    }

    public void addRect(int x, int y, int height, int width){
        svg.append(String.format(rectTemplate, x, y, height, width));
    }
    public void addPole(int x, int y, int height, int width){
        svg.append(String.format(poleTemplate, x, y, height, width));
    }
    public void addLine(int x, int y, int height, int width){
        svg.append(String.format(lineTemplate, x,y,height, width));
    }
    public void addArrowLine(int x1, int y1, int x2, int y2){

        svg.append(String.format(arrowTemplate,x1,y1,x2,y2));
    }

    public void addText(int x, int y, int rotate, int length){
        svg.append(String.format(textTemplate,x,y,rotate,length));
    }
    public void addEnd(){
        svg.append(String.format(svgEnd));
    }
    public void addRoof(int x, int y, int height, int width, int rotate){
        svg.append(String.format(roofTemplate,x,y,height,width,rotate));
    }



    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getViewbox() {
        return viewbox;
    }

    public void setViewbox(String viewbox) {
        this.viewbox = viewbox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>" ;
    }
}