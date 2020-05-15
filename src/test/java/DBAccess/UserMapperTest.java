package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES 
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "try1try2tryAgain";
    private static String DBNAME = "useradminTest";
    private static String HOST = "46.101.253.149";

    @BeforeClass
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test 
                Connector.setConnection( testConnection );
            } }
        catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }
    @Before
    public void beforeEachTest(){
        // reset test database
        try ( Statement stmt = testConnection.createStatement() ) {
            //roof coating
            stmt.execute( "drop table if exists roofcoating" );
            stmt.execute( "create table roofcoating like carport.roofcoating" );
            stmt.execute( "insert into roofcoating select * from carport.roofcoating" +
            "(1,'Tag med rejsning', 0)," +
            "(2,'Plasttrapezplade', 34);");

            //tilted roof coating
            stmt.execute( "drop table if exists tiltedroofcoating" );
            stmt.execute( "create table tiltedroofcoating like carport.tiltedroofcoating" );
            stmt.execute( "insert into tiltedroofcoating values"+
            "(1,'Fladt tag', 0),"+
            "(2,'RØDE VINGETAGSTEN GL. DANSK FORBRUG', 261);" );

            //shed clothing
            stmt.execute( "drop table if exists shedclothing" );
            stmt.execute( "create table shedclothing like carport.shedclothing" );
            stmt.execute( "insert into shedclothing values " +
            "(0,'Intet skur',0)," +
            "(0,'21X85 MM BLOKHUSBRÆDDER FYR MED VEKSELFALS',269)," +
            "(0,'29X142 MM SIBIRISK LÆRK KLINKBEKLÆDNING TP. AALBORG - RUSAVET',381);" );

            //Wood
            stmt.execute( "drop table if exists shedclothing" );
            stmt.execute( "create table shedclothing like carport.shedclothing" );
            stmt.execute( "insert into shedclothing values " +
            "('Pæl','97X97 MM FULDKANTET FYR IMPR. NTR/A TRYKIMPRÆGNERET',41.95)," +
            "('Spær','47X200 MM SPÆRTRÆ C18 HØVLET TIL 45X195MM',46.95)," +
            "('Regel','45X95 MM SIBIRISK LÆRK REGEL KVARTA, HØVLET 4 SIDER M/AFR. KANTER',59.95)," +
            "('UniversalBeslag','Højre og venstre universal beslag 190 mm',45)," +
            "('Vindskede','25X150 MM VTA TRYKIMPRÆGNERET',45)," +
            "('LøsholteBeslag','Vinkelbeslag til løsholter',5)," +
            "('BræddeBolt','Varmgalvaniseret bræddebolt 10x120mm og firkantskive 40x40x11mm',20)," +
            "('Lægte','38x73 mm. taglægte T1 ',18);");
        } catch (SQLException e) {
            System.out.println("Couldn't open connection to database: " + e.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }
/*
    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertTrue( user != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login( "jens@somewhere.com", "larsen" );
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "customer", user.getRole() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getRole() );
    }*/
}
