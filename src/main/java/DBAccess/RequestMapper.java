package DBAccess;

import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestMapper {
   // public static void createRequest(int roofid ,int shedid,int width, int length, int shedWidth, int shedLength,int angle, String note, String email) throws LoginSampleException {
        public static void createRequest(int width) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
//            String SQL = "INSERT INTO carport.requests (roofid,shedid,width,length,shedWidth,shedLength,angle,note,email) VALUES (?,?,?,?,?,?,?,?,?);";
            //PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, roofid);
            //ps.setInt(2, shedid);
            //ps.setInt(3, width);
            //ps.setInt(4, length);
            //ps.setInt(5, shedWidth);
            //ps.setInt(6, shedLength);
            //ps.setInt(7, angle);
            //ps.setString(8, note);
            //ps.setString(9, email);



            String SQL = "INSERT INTO carport.requests (width) VALUES (?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, width);



            ps.executeUpdate();



        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
