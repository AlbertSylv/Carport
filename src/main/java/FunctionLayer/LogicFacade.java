package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.RequestMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;


public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static void createRequest(int roofID,int tiltedroofID, int shedID, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) throws LoginSampleException {

        RequestMapper.createRequest(roofID, tiltedroofID, shedID, width, length, shedWidth, shedLength, angle, note, email);

    }

    public static Request getRequest(String email) throws LoginSampleException {

       return RequestMapper.getRequest(email);

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
    public static ArrayList<ShedClothing> getShedclothing() throws LoginSampleException {
        ArrayList<ShedClothing> linjer = new ArrayList<ShedClothing>();

        linjer = MaterialMapper.getShedClothing();

        return linjer;
    }


    public static ArrayList<Request> getRequests() {
        ArrayList<Request> bestillinger=new ArrayList<Request>();
        bestillinger=RequestMapper.getRequests();
        return bestillinger;
    }
}
