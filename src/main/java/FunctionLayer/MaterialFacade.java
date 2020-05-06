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
}
