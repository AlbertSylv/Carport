package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.RoofCoating;
import FunctionLayer.User;
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
         PreparedStatement prepst = con.prepareStatement( SQL );
         ResultSet result = prepst.executeQuery();
         while ( result.next() ) {
             int roofID = result.getInt("roofID");
             String navn = result.getString("name");

             RoofCoating RC = new RoofCoating(roofID,navn);
             linjer.add(RC);
         }
    } catch ( ClassNotFoundException | SQLException ex ) {

    }
        return linjer;
    }
}