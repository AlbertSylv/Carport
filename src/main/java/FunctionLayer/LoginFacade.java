package FunctionLayer;

import DBAccess.UserMapper;

public class LoginFacade {
    public static User login( String email, String password, String role, String name, String adress, String zipCity, String phone) throws LoginSampleException {
        return UserMapper.login( email, password, role, name, adress, phone);
    }
}
