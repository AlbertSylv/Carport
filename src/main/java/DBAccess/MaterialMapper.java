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
                ShedClothing shedclothing = new ShedClothing(id,navn);
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
            String SQL = "select * from carport.tiltedroofcoating where tiltedroofID>1;";
            PreparedStatement prepst = con.prepareStatement(SQL);
            ResultSet result = prepst.executeQuery();
            while (result.next()) {
                int tiltedroofID = result.getInt("tiltedroofID");
                String name = result.getString("name");

                TiltedRoofCoating TRC = new TiltedRoofCoating(tiltedroofID, name);
                linjer.add(TRC);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }
        return linjer;
    }
}