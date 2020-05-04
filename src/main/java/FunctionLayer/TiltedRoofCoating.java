package FunctionLayer;

public class TiltedRoofCoating {

        int tiltedroofID;
        String name;
        int price;

        public TiltedRoofCoating(int roofID, String name, int price) {
            this.tiltedroofID = roofID;
            this.name = name;
            this.price = price;
        }

        public int getRoofID() {
            return tiltedroofID;
        }

        public void setRoofID(int roofID) {
            this.tiltedroofID = roofID;
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


