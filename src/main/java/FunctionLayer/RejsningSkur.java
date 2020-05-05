package FunctionLayer;

public class RejsningSkur {
    int rejsningSkurID;
    String name;
    int price;

    public RejsningSkur(int rejsningSkurID, String name, int price) {
        this.rejsningSkurID = rejsningSkurID;
        this.name = name;
        this.price = price;
    }

    public int getRejsningSkurID() {
        return rejsningSkurID;
    }

    public void setRejsningSkurID(int rejsningSkurID) {
        this.rejsningSkurID = rejsningSkurID;
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