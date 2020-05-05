package FunctionLayer;

public class TiltedRoofCoating {

        int tiltedroofID;
        String name;
        int price;

        public TiltedRoofCoating(int tiltedroofID, String name, int price) {
            this.tiltedroofID = tiltedroofID;
            this.name = name;
            this.price = price;
        }

    public TiltedRoofCoating(int tiltedroofID, String name) {
        this.tiltedroofID = tiltedroofID;
        this.name = name;
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


