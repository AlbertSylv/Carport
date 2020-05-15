package DBAccess;

import FunctionLayer.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MaterialMapper {


    public static ArrayList getShedClothing() throws LoginSampleException {
        ArrayList<ShedClothing> SC = new ArrayList();
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM carport.shedclothing where shedID > 1";
            PreparedStatement ps = con.prepareStatement(SQL);



            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("shedID");
                String navn = rs.getString("name");
                int pricePrM = rs.getInt("price");

                ShedClothing shedclothing = new ShedClothing(id,navn, pricePrM);
                SC.add(shedclothing);
            }


        } catch (SQLException | ClassNotFoundException e) {


        }
        return SC;
    }

    public static ArrayList getRoofCoatings() throws LoginSampleException {
        ArrayList<RoofCoating> linjer = new ArrayList<RoofCoating>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.roofcoating where roofID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int roofID = result.getInt("roofID");
                String navn = result.getString("name");
                int pricePrM = result.getInt("price");

                RoofCoating RC = new RoofCoating(roofID, navn, pricePrM);
                linjer.add(RC);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }

    public static ArrayList getTiltedRoofCoatings() throws LoginSampleException {

        ArrayList<TiltedRoofCoating> linjer = new ArrayList<TiltedRoofCoating>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.tiltedroofcoating where tiltedroofID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int tiltedroofID = result.getInt("tiltedroofID");
                String name = result.getString("name");
                int pricePrM = result.getInt("price");

                TiltedRoofCoating TRC = new TiltedRoofCoating(tiltedroofID, name, pricePrM);
                linjer.add(TRC);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }

    public static ArrayList getWoods() throws LoginSampleException {

        ArrayList<Wood> linjer = new ArrayList<Wood>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.wood;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                int pricePrM = result.getInt("pricePrM");

                Wood wood = new Wood(name, pricePrM);
                wood.setType(result.getString("type"));
                linjer.add(wood);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }

    public static Wood getWood(String Type) throws LoginSampleException {
        Wood wood = null;
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM wood where wood.type=?;";

            PreparedStatement prepst = con.prepareStatement(SQL);
            prepst.setString(1, Type);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                int pricePrM = result.getInt("pricePrM");


                wood = new Wood(name, pricePrM);
                wood.setType(result.getString("type"));


            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return wood;
    }

    public static void updateTRC(int tiltedroofID, String name, int price) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE tiltedroofcoating SET name = ?, price = ? WHERE tiltedroofID=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1,  name);
            ps.setInt( 2, price );
            ps.setInt( 3,tiltedroofID );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    public static void updateRC(int roofID, String name, int price) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE shedclothing SET name = ?, price = ? WHERE roofID=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 3, roofID );
            ps.setString( 1, name );
            ps.setInt( 2, price );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    public static void updateSC(int shedID, String name, int price) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE shedclothing SET name = ?, price = ? WHERE shedID=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt( 3, shedID );
            ps.setString( 1, name );
            ps.setInt( 2, price );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static void updateWood(String type, String name, int price) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE wood SET wood.name = ?, pricePrM = ? WHERE wood.type=?;";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );

            ps.setString( 1, name );
            ps.setInt( 2, price );
            ps.setString( 3, type );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
}