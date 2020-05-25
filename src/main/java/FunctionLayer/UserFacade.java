package FunctionLayer;

import DBAccess.UserMapper;

public class UserFacade {

    public static User login( String email, String password,String name,String address, String zipCity, String phone) throws LoginSampleException {
        return UserMapper.login(email, password, name,address, zipCity, phone);
    }

    public static User createUser( String email, String password,String name,String address, String zipCity, String phone) throws LoginSampleException {
        User user = new User(email, password, "customer", name,address, zipCity, phone);
        UserMapper.createUser(user);
        return user;
    }
    public static User createEmployeeUser( String email, String password,String name,String address, String zipCity, String phone) throws LoginSampleException {
        User user = new User(email, password, "employee", name,address, zipCity, phone);
        UserMapper.createUser(user);
        return user;
    }


}
