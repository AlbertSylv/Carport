package FunctionLayer;

public class RoofCoating {
    int roofID;
    String name;
    int price;

    public RoofCoating(int roofID, String name, int price) {
        this.roofID = roofID;
        this.name = name;
        this.price = price;
    }

    public RoofCoating(int roofID, String name) {
        this.roofID = roofID;
        this.name = name;
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
