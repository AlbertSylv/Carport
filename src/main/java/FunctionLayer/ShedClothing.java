package FunctionLayer;

public class ShedClothing {
    int shedID;
    String name;
    int price;

    public ShedClothing(int shedID, String name, int price) {
        this.shedID = shedID;
        this.name = name;
        this.price = price;
    }

    public ShedClothing(int shedID, String name) {
        this.shedID = shedID;
        this.name = name;
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
