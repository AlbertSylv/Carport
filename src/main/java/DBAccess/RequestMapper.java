package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Request;
import FunctionLayer.TiltedRoofCoating;

import java.sql.*;
import java.util.ArrayList;

public class RequestMapper {
    public static void createRequest(int roofid , int tiltedroofid, int shedID, int width, int length, int shedWidth, int shedLength,int angle, String note, String email) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO carport.requests (roofid, tiltedroofid, shedid, width, length, shedWidth, shedLength, angle, note, email) VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, roofid);
            ps.setInt(2, tiltedroofid);
            ps.setInt(3, shedID);
            ps.setInt(4, width);
            ps.setInt(5, length);
            ps.setInt(6, shedWidth);
            ps.setInt(7, shedLength);
            ps.setInt(8, angle);
            ps.setString(9, note);
            ps.setString(10, email);



            ps.executeUpdate();



        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static Request getRequest4Styklist(int id) throws LoginSampleException {
        Request request = null;
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT requests.*, roofcoating.name as RCname,roofcoating.price as RCprice, " +
                    "shedclothing.name as SCname, shedclothing.price as SCprice, tiltedroofcoating.name as TRCname," +
                    " tiltedroofcoating.price as TRCprice FROM carport.requests " +
                    "join roofcoating on requests.roofid=roofcoating.roofid " +
                    "join shedclothing on requests.shedID=shedclothing.shedID " +
                    "join tiltedroofcoating on requests.tiltedroofID=tiltedroofcoating.tiltedroofID " +
                    "where requests.id=?  ORDER BY id DESC LIMIT 1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            prepst.setInt(1, id);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                String email = result.getString("email");
                String SCname = result.getString("SCname");
                int SCprice = result.getInt("SCprice");
                String RCname = result.getString("rCname");
                int RCprice = result.getInt("RCprice");
                String TRCname = result.getString("TRCname");
                int TRCprice = result.getInt("TRCprice");
                int width = result.getInt("width");
                int length = result.getInt("length");
                int shedWidth = result.getInt("shedWidth");
                int shedLength = result.getInt("shedLength");
                int angle = result.getInt("angle");
                String note = result.getString("note");


                request = new Request(id, width, length, shedWidth, shedLength, angle, note, email, SCname, RCname,TRCname, SCprice, RCprice, TRCprice);


            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return request;
    }

    public static Request getRequest(String email) throws LoginSampleException {
        Request request = null;
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT requests.*, roofcoating.name as RCname,roofcoating.price as RCprice, " +
                    "shedclothing.name as SCname, shedclothing.price as SCprice, tiltedroofcoating.name as TRCname," +
                    " tiltedroofcoating.price as TRCprice FROM carport.requests " +
                    "join roofcoating on requests.roofid=roofcoating.roofid " +
                    "join shedclothing on requests.shedID=shedclothing.shedID " +
                    "join tiltedroofcoating on requests.tiltedroofID=tiltedroofcoating.tiltedroofID " +
                    "where requests.email=?  ORDER BY id DESC LIMIT 1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            prepst.setString(1, email);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String SCname = result.getString("SCname");
                int SCprice = result.getInt("SCprice");
                String RCname = result.getString("rCname");
                int RCprice = result.getInt("RCprice");
                String TRCname = result.getString("TRCname");
                int TRCprice = result.getInt("TRCprice");
                int width = result.getInt("width");
                int length = result.getInt("length");
                int shedWidth = result.getInt("shedWidth");
                int shedLength = result.getInt("shedLength");
                int angle = result.getInt("angle");
                String note = result.getString("note");


                 request = new Request(id, width, length, shedWidth, shedLength, angle, note, email, SCname, RCname,TRCname, SCprice, RCprice, TRCprice);


            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return request;
    }
    public static void deleteRequest(String email) {

        try {

            Connection con = Connector.connection();
            String query = "delete from carport.requests where requests.email=? ORDER BY id DESC LIMIT 1;";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setString(1, email);

            pstatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Request> getRequests() {
        ArrayList<Request> bestillinger = new ArrayList<Request>();
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT requests.*, roofcoating.name as RCname,roofcoating.price as RCprice, " +
                    "shedclothing.name as SCname, shedclothing.price as SCprice, tiltedroofcoating.name as TRCname," +
                    " tiltedroofcoating.price as TRCprice FROM carport.requests " +
                    "join roofcoating on requests.roofid=roofcoating.roofid " +
                    "join shedclothing on requests.shedID=shedclothing.shedID " +
                    "join tiltedroofcoating on requests.tiltedroofID=tiltedroofcoating.tiltedroofID " +
                    " ORDER BY id DESC;";
            PreparedStatement prepst = con.prepareStatement(SQL);

            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String SCname = result.getString("SCname");
                int SCprice = result.getInt("SCprice");
                String RCname = result.getString("rCname");
                int RCprice = result.getInt("RCprice");
                String TRCname = result.getString("TRCname");
                int TRCprice = result.getInt("TRCprice");
                int width = result.getInt("width");
                int length = result.getInt("length");
                int shedWidth = result.getInt("shedWidth");
                int shedLength = result.getInt("shedLength");
                int angle = result.getInt("angle");
                String note = result.getString("note");
                String email = result.getString("email");


                Request request = new Request(id, width, length, shedWidth, shedLength, angle, note, email, SCname, RCname,TRCname, SCprice, RCprice, TRCprice);

                bestillinger.add(request);

            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return bestillinger;
    }

    public static void adminDeleteRequest(int id) {
        try {

            Connection con = Connector.connection();
            String query = "delete from carport.requests where requests.id=?;";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setString(1, String.valueOf(id));

            pstatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
