package FunctionLayer;

import DBAccess.RequestMapper;
import DBAccess.UserMapper;

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
    // public static void createRequest(int roofid, int shedid, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) throws LoginSampleException {
    public static void createRequest(int width) throws LoginSampleException {


        //RequestMapper.createRequest(roofid,shedid,width,length,shedWidth,shedLength,angle,note,email);
        RequestMapper.createRequest(width);


    }

}
