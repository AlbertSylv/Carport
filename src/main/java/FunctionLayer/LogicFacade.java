package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.RequestMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static void createRequest(String roof, String shedClothing, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) throws LoginSampleException {

        RequestMapper.createRequest(roof, shedClothing, width, length, shedWidth, shedLength, angle, note, email);

    }


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

    public static ArrayList<Rejsning> getRejsning() throws LoginSampleException {
        ArrayList<Rejsning> linjer = new ArrayList<Rejsning>();

        linjer = MaterialMapper.getRejsning();

        return linjer;

    }
    public static ArrayList<RejsningSkur> getRejsningSkur() throws LoginSampleException {
        ArrayList<RejsningSkur> linjer = new ArrayList<RejsningSkur>();

        linjer = MaterialMapper.getRejsningSkur();

        return linjer;

    }
    public static ArrayList<FladtTag> getFladtTag() throws LoginSampleException {
        ArrayList<FladtTag> linjer = new ArrayList<FladtTag>();

        linjer = MaterialMapper.getFladtTag();

        return linjer;

    }
    public static ArrayList<FladtTagSkur> getFladtTagSkur() throws LoginSampleException {
        ArrayList<FladtTagSkur> linjer = new ArrayList<FladtTagSkur>();

        linjer = MaterialMapper.getFladtTagSkur();

        return linjer;

    }
}
