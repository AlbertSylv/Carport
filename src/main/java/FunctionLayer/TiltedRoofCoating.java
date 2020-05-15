package FunctionLayer;

public class TiltedRoofCoating {

        int tiltedroofID;
        String name;
        int price;
        double meter2;
        int pricePrM;

    //Constructor til når Calculatoren skal returne en roofcoating
    public TiltedRoofCoating(String name, int price, double meter2) {
        this.name = name;
        this.price = price;
        this.meter2 = meter2;
    }

    //Constructor til MaterialMapperen
    public TiltedRoofCoating(int tiltedroofID, String name, int pricePrM) {
        this.tiltedroofID = tiltedroofID;
        this.name = name;
        this.pricePrM = pricePrM;
    }

    public int getPricePrM() {
        return pricePrM;
    }

    public void setPricePrM(int pricePrM) {
        this.pricePrM = pricePrM;
    }

    public double getMeter2() {
        return meter2;
    }

    public void setMeter2(double meter2) {
        this.meter2 = meter2;
    }

    public int getTiltedroofID() {
            return tiltedroofID;
        }

        public void setTiltedroofID(int tiltedroofID) {
            this.tiltedroofID = tiltedroofID;
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


