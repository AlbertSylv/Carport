package FunctionLayer;

public class Wood {
    String type;
    String woodName;
    int pricePrM;
    int price;
    int meters;

    //Constructor til når calculator skal returne et Wood objekt
    public Wood(String woodName, int price, int meters) {
        this.woodName = woodName;
        this.price = price;
        this.meters = meters;
    }

    //Constructor til når MaterialMapperen skal returne et Wood objekt
    public Wood(String woodName, int pricePrM) {
        this.woodName = woodName;
        this.pricePrM = pricePrM;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWoodName() {
        return woodName;
    }

    public void setWoodName(String woodName) {
        this.woodName = woodName;
    }

    public int getPricePrM() {
        return pricePrM;
    }

    public void setPricePrM(int pricePrM) {
        this.pricePrM = pricePrM;
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }
}
