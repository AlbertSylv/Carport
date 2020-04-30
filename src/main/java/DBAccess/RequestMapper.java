package DBAccess;

import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestMapper {
    public static void createRequest(String roof , String shedClothing, int width, int length, int shedWidth, int shedLength,int angle, String note, String email) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO carport.requests (roofid,shedid,width,length,shedWidth,shedLength,angle,note,email) VALUES (?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, roof);
            ps.setString(2, shedClothing);
            ps.setInt(3, width);
            ps.setInt(4, length);
            ps.setInt(5, shedWidth);
            ps.setInt(6, shedLength);
            ps.setInt(7, angle);
            ps.setString(8, note);
            ps.setString(9, email);



            ps.executeUpdate();



        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
