package FunctionLayer;

public class RoofCoating {
    int roofID;
    String name;
    int pricePrM;
    int price;
    double meter2;

    //Constructor til når Calculatoren skal returne en roofcoating
    public RoofCoating(String name, int price, double meter2) {
        this.name = name;
        this.price = price;
        this.meter2 = meter2;
    }

    //Constructor til MaterialMapperen
    public RoofCoating(int roofID, String name) {
        this.roofID = roofID;
        this.name = name;
    }

    public double getMeter2() {
        return meter2;
    }

    public void setMeter2(double meter2) {
        this.meter2 = meter2;
    }

    public int getPricePrM() {
        return pricePrM;
    }

    public void setPricePrM(int pricePrM) {
        this.pricePrM = pricePrM;
    }

    public int getRoofID() {
        return roofID;
    }

    public void setRoofID(int roofID) {
        this.roofID = roofID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
