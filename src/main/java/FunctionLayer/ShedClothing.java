package FunctionLayer;

public class ShedClothing {
    int shedID;
    String name;
    int price;
    double meter2;

    //Constructor til når Calculatoren skal returne en roofcoating
    public ShedClothing(String name, int price, double meter2) {
        this.name = name;
        this.price = price;
        this.meter2 = meter2;
    }
    //Constructor til MaterialMapperen
    public ShedClothing(int shedID, String name) {
        this.shedID = shedID;
        this.name = name;
    }

    public double getMeter2() {
        return meter2;
    }

    public void setMeter2(double meter2) {
        this.meter2 = meter2;
    }

    public int getShedID() {
        return shedID;
    }

    public void setShedID(int shedID) {
        this.shedID = shedID;
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
