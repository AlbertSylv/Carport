package DBAccess;

import FunctionLayer.LoginSampleException;
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
        try {
            ArrayList mat = new ArrayList();

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM carport.shedclothing where name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);


            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String navn = rs.getString("name");
                Material material = new Material(navn);
                mat.add(material);

                return mat;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}