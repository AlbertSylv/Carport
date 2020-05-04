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

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    public static void createRequest(String roof, String shedClothing, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) throws LoginSampleException {

             RequestMapper.createRequest(roof,shedClothing,width,length,shedWidth,shedLength,angle,note,email);

    }


    public static ArrayList<RoofCoating> getRoofCoatings() throws LoginSampleException {
        ArrayList<RoofCoating> linjer = new ArrayList<RoofCoating>();

        linjer = MaterialMapper.getRoofCoatings();

        return linjer;
    }

}
