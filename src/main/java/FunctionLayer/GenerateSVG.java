package FunctionLayer;

public class GenerateSVG {

    private String topViewSVG;
    private String sideViewSVG;
    private int height, width, shedHeight, shedWidth, offset, outhangFront, outhangBack, outhangSites, postSpace;


    public GenerateSVG(int length, int width, int shedLength, int shedWidth, int outhangFront, int outhangBack, int outhangSites) {
        this.height = width;
        this.width = length;
        this.shedHeight = shedWidth;
        this.shedWidth = shedLength;
        this.offset = 100;
        this.outhangFront = outhangFront;
        this.outhangBack = outhangBack;
        this.outhangSites = outhangSites;

        topViewSVG = "<svg height='" + (this.height + offset * 2) + "' width='" + (this.width + offset) + "'>";
        topViewSVG += generateRect(0, 0, this.height, this.width, false);

    }



    private String generateLine(int x1, int y1, int x2, int y2, boolean dashed) {
        return "<line class='" + (dashed ? "svgDashed' stroke-dasharray='5,5'" : "svgThin'") + " x1='" + (x1 + offset) + "' y1='" + (y1 + offset) + "' x2='" + (x2 + offset) + "' y2='" + (y2 + offset) + "'/>";
    }
    private String generateRect(int x, int y, int height, int width, boolean bold) {
        return "<rect class='" + (bold ? "svgBold" : "") + "' x='" + (x + offset) + "' y='" + (y + offset) + "' height='" + height + "' width='" + width + "'/>";
    }
    private String generateText(int x, int y, String text, boolean os) {
        return "<text x='" + (x + (os ? offset : 0)) + "' y='" + (y + (os ? offset : 0)) + "' fill='black'>" + text + "</text>";
    }
}
