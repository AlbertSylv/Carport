package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import PresentationLayer.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO accounts (email, password, role, name, address, zipCity, phone) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.setString( 4, user.getName());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getZipCity());
            ps.setString(7, user.getPhone());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
        } catch ( SQLException | ClassNotFoundException ex ) {

            if(ex.getMessage().contains("Duplicate entry")){

                Log.finest("Lav bruger:" + "''" + user.getEmail() + "''" + " findes allerede.");

                throw new LoginSampleException("Bruger findes allerede.");
            }

            if(ex.getMessage().contains("Communication link failure")){

                Log.info("Lav ny bruger: " + ex.getMessage());
                throw new LoginSampleException("Databasen er nede, kontakt venligst Admin.");


            }

            Log.severe("Lav bruger " + ex.getMessage());
            throw new LoginSampleException("Der er fejl på siden, kontakt admin.");
        }
    }

    public static User login(String email, String password,String name,String address, String zipCity, String phone ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM carport.accounts "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                name = rs.getString( "name" );

                User user = new User( email, password, role, name, address, zipCity, phone);

                return user;
            } else {

                Log.info("Login: " + "Indtastede oplysninger matcher ikke eller findes ikke."); // Denne kører hvis man skriver forkerte loginoplysninger

                throw new LoginSampleException( "Forkert email eller password - Prøv igen eller registrer dig som ny bruger.");
            }
        } catch ( ClassNotFoundException | SQLException ex ) {

            if (ex.getMessage().contains("Kommunikationsfejl - Tjek database")){ //Denne kører hvis databasen ikke er online eller ved ingen forbindelse
                Log.severe("Login: " + ex.getMessage());
                throw new LoginSampleException("Databasen er nede, kontakt venligst Admin.");
            }

            Log.severe("Login" + ex.getMessage());

            throw new LoginSampleException(ex.getMessage());
        }
    }

}
