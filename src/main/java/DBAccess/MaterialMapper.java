package DBAccess;

import FunctionLayer.*;
import models.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MaterialMapper {


    public static ArrayList getMaterials(String name) throws LoginSampleException {
        ArrayList mat = null;
        try {
            mat = new ArrayList();

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM carport.shedclothing where name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String navn = rs.getString("name");
                Material material = new Material(navn);
                mat.add(material);

            }


        } catch (SQLException | ClassNotFoundException e) {


        }
        return mat;
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

                RoofCoating RC = new RoofCoating(roofID, navn);
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
            String SQL = "select * from carport.tiltedroofcoating where roofID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int roofID = result.getInt("roofID");
                String navn = result.getString("name");
                int pris = result.getInt("pris");

                TiltedRoofCoating TRC = new TiltedRoofCoating(roofID, navn, pris);
                linjer.add(TRC);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }
    public static ArrayList getRejsning() throws LoginSampleException {
        ArrayList<Rejsning> linjer = new ArrayList<Rejsning>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.rejsning where rejsningID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int roofID = result.getInt("roofID");
                String navn = result.getString("name");
                int pris = result.getInt("pris");

                Rejsning Rejs = new Rejsning(roofID, navn, pris);
                linjer.add(Rejs);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }

    public static ArrayList getRejsningSkur() throws LoginSampleException {
        ArrayList<RejsningSkur> linjer = new ArrayList<RejsningSkur>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.rejsning where rejsningSkurID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int roofID = result.getInt("roofID");
                String navn = result.getString("name");
                int pris = result.getInt("pris");

                RejsningSkur RejsSkur = new RejsningSkur(roofID, navn, pris);
                linjer.add(RejsSkur);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }
    public static ArrayList getFladtTag() throws LoginSampleException {
        ArrayList<FladtTag> linjer = new ArrayList<FladtTag>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.rejsning where fladtTagID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int fladtTagID = result.getInt("fladtTagID");
                String navn = result.getString("name");
                int pris = result.getInt("pris");

                FladtTag fladtTag = new FladtTag(fladtTagID, navn, pris);
                linjer.add(fladtTag);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }
    public static ArrayList getFladtTagSkur() throws LoginSampleException {
        ArrayList<FladtTagSkur> linjer = new ArrayList<FladtTagSkur>();
        try {

            Connection con = Connector.connection();
            String SQL = "select * from carport.rejsning where fladtTagSkurID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int fladtTagSkurID = result.getInt("fladtTagSkurID");
                String navn = result.getString("name");
                int pris = result.getInt("pris");

                FladtTagSkur fladtTagSkur = new FladtTagSkur(fladtTagSkurID, navn, pris);
                linjer.add(fladtTagSkur);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }
}