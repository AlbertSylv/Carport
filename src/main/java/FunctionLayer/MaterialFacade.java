package FunctionLayer;

import DBAccess.MaterialMapper;

import java.util.ArrayList;

public class MaterialFacade {
    public static ArrayList<RoofCoating> getRoofCoatings() throws LoginSampleException {
        ArrayList<RoofCoating> linjer = new ArrayList<RoofCoating>();

        linjer = MaterialMapper.getRoofCoatings();

        return linjer;
    }

    public static ArrayList<TiltedRoofCoating> getTiltedRoofCoating() throws LoginSampleException {
        ArrayList<TiltedRoofCoating> linjer = new ArrayList<TiltedRoofCoating>();

        linjer = MaterialMapper.getTiltedRoofCoatings();

        return linjer;

    }
    public static ArrayList<ShedClothing> getShedclothing() throws LoginSampleException {
        ArrayList<ShedClothing> linjer = new ArrayList<ShedClothing>();

        linjer = MaterialMapper.getShedClothing();

        return linjer;
    }
    public static ArrayList<Wood> getWoods() throws LoginSampleException {
        ArrayList<Wood> linjer = new ArrayList<Wood>();

        linjer = MaterialMapper.getWoods();

        return linjer;
    }

    public static void updateWood(String type, String name, int price) throws LoginSampleException {
        MaterialMapper.updateWood(type,name,price);
    }

    public static void updateTRC(int tiltedroofID, String name, int price) throws LoginSampleException {
        MaterialMapper.updateTRC(tiltedroofID,name,price);
    }
    public static void updateRC(int roofID, String name, int price) throws LoginSampleException {
        MaterialMapper.updateRC(roofID,name,price);
    }
    public static void updateSC(int shedID, String name, int price) throws LoginSampleException {
        MaterialMapper.updateSC(shedID,name,price);
    }
}
