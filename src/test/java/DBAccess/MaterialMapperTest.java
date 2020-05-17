package DBAccess;

import FunctionLayer.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MaterialMapperTest {
    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "1234fem";
    private static String DBNAME = "carport_test?serverTimezone=CET&useSSL=false";
    private static String HOST = "localhost";

    @BeforeClass
    public static void setUp() {
        try {
            // awoid making a new connection for each test
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                Connector.setConnection(testConnection);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Before
    public void beforeEachTest() {
        // reset test database
        try (Statement stmt = testConnection.createStatement()) {
            //roof coating
            stmt.execute("drop table if exists roofcoating");
            stmt.execute("create table roofcoating like carport.roofcoating");
            stmt.execute("insert into roofcoating values" +
                    "(1,'Tag med rejsning', 0)," +
                    "(2,'Plasttrapezplade', 34);");

            //tilted roof coating
            stmt.execute("drop table if exists tiltedroofcoating");
            stmt.execute("create table tiltedroofcoating like carport.tiltedroofcoating");
            stmt.execute("insert into tiltedroofcoating values" +
                    "(1,'Fladt tag', 0)," +
                    "(2,'RØDE VINGETAGSTEN GL. DANSK FORBRUG', 261);");

            //shed clothing
            stmt.execute("drop table if exists shedclothing");
            stmt.execute("create table shedclothing like carport.shedclothing");
            stmt.execute("insert into shedclothing values " +
                    "(0,'Intet skur',0)," +
                    "(0,'21X85 MM BLOKHUSBRÆDDER FYR MED VEKSELFALS',269)," +
                    "(0,'29X142 MM SIBIRISK LÆRK KLINKBEKLÆDNING TP. AALBORG - RUSAVET',381);");

            //Wood
            stmt.execute("drop table if exists wood");
            stmt.execute("create table wood like carport.wood");
            stmt.execute("insert into wood values " +
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

    //regressions testing
    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }


    @Test
    public void testGetShedClothing() throws LoginSampleException {
        // Can we retrieve a list of all shed clothing objects, except the first one
        ArrayList<ShedClothing> shedClothings = MaterialMapper.getShedClothing();
        assertThat(shedClothings, hasSize(2));
        assertThat(shedClothings, hasItem(hasProperty("shedID", equalTo(2))));
        assertThat(shedClothings, hasItem(hasProperty("shedID", equalTo(3))));
    }

    @Test
    public void testGetRoofCoating() throws LoginSampleException {
        // Can we retrieve a list of all roof coating objects, except the first one
        ArrayList<RoofCoating> roofCoatingss = MaterialMapper.getRoofCoatings();
        assertThat(roofCoatingss, hasSize(1));
        assertThat(roofCoatingss, hasItem(hasProperty("roofID", equalTo(2))));

    }

    @Test
    public void testGetTiltedRoofCoating() throws LoginSampleException {
        // Can we retrieve a list of all tilted roof coating objects, except the first one
        ArrayList<TiltedRoofCoating> tiltedRoofCoatings = MaterialMapper.getTiltedRoofCoatings();
        assertThat(tiltedRoofCoatings, hasSize(1));
        assertThat(tiltedRoofCoatings, hasItem(hasProperty("shedID", equalTo(2))));
    }

    @Test
    public void testGetWood() throws LoginSampleException {
        // Can we retrieve wood objects of different types
        //type=Pæl
        Wood pæl = MaterialMapper.getWood("Pæl");
        assertEquals("97X97 MM FULDKANTET FYR IMPR. NTR/A TRYKIMPRÆGNERET", pæl.getWoodName());

        //type=Vindskede
        Wood vindskede = MaterialMapper.getWood("Vindskede");
        assertEquals("25X150 MM VTA TRYKIMPRÆGNERET", vindskede.getWoodName());
    }

    //////////
    //Her fra prøver vi at bruge TDD(test driven development) dvs at vi ikke har skrevet metoderne som vi skal teste endnu
    //////////

    @Test
    public void testGetWoods() throws LoginSampleException {
        // Can we retrieve a list of all wood objects
        ArrayList<Wood> woods = MaterialMapper.getWoods();
        assertThat(woods, hasSize(8));
        assertThat(woods, hasItem(hasProperty("type", equalTo("Pæl"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("Regel"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("Spær"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("UniversalBeslag"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("BræddeBolt"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("LøsholteBeslag"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("Vindskede"))));
        assertThat(woods, hasItem(hasProperty("type", equalTo("Lægte"))));
    }


    @Test
    public void testUpdateWood() throws LoginSampleException {
        // Can we update a wood objects name and price
        String type="Pæl";
        String newName = "Ny lækker pæl";
        int newPrice = 20000;

        MaterialMapper.updateWood(type, newName,newPrice);

        Wood pæl = MaterialMapper.getWood("Pæl");
        assertEquals("Ny lækker pæl", pæl.getWoodName());
        assertEquals(20000, pæl.getPricePrM());

    }

    @Test
    public void testUpdateRoofCoating() throws LoginSampleException {
        // Can we update a roofCoating objects name and price
        int id=2;
        String newName = "Græs tag";
        int newPrice = 200;

        MaterialMapper.updateRC(id, newName,newPrice);

        ArrayList<RoofCoating> roofCoatings = MaterialMapper.getRoofCoatings();
        assertThat(roofCoatings, hasSize(1));
        assertThat(roofCoatings,hasItem(hasProperty("name",equalTo("Græs tag"))));
        assertThat(roofCoatings,hasItem(hasProperty("price",equalTo(200))));


        //Man behøver ikke den her, fordi vi allerede tester om arraylistens size er 1, men vil gerne lige flexe at jeg kan finde ud af at teste om den gamle string er forsvundet. Det er også første gang der laves en negativ test.
        assertThat(roofCoatings, not(hasItem(hasProperty("name",equalTo("Plasttrapezplade")))));

    }

    @Test
    public void testUpdateTiltedRoofCoating() throws LoginSampleException {
        // Can we update a TiltedRoofCoating objects name and price
        int id=2;
        String newName = "Græs tag";
        int newPrice = 200;

        MaterialMapper.updateTRC(id, newName,newPrice);

        ArrayList<TiltedRoofCoating> TiltedRoofCoatings = MaterialMapper.getTiltedRoofCoatings();
        assertThat(TiltedRoofCoatings, hasSize(1));
        assertThat(TiltedRoofCoatings,hasItem(hasProperty("name",equalTo("Græs tag"))));
        assertThat(TiltedRoofCoatings,hasItem(hasProperty("price",equalTo(200))));

    }

    @Test
    public void testUpdateShedClothing() throws LoginSampleException {
        // Can we update a ShedClothing objects name and price
        int id=2;
        String newName = "Falsk mursten";
        int newPrice = 5;

        MaterialMapper.updateSC(id, newName,newPrice);

        ArrayList<ShedClothing> ShedClothings = MaterialMapper.getShedClothing();
        assertThat(ShedClothings, hasSize(2));
        assertThat(ShedClothings,hasItem(hasProperty("name",equalTo("Falsk mursten"))));
        assertThat(ShedClothings,hasItem(hasProperty("price",equalTo(5))));

    }

   /* @Test
    public void testAddRoofCoating() throws LoginSampleException {
        // Can we update a roofCoating objects name and price
        String newName = "Græs tag";
        int newPrice = 200;

        MaterialMapper.addRoofCoating(newName,newPrice);

        ArrayList<RoofCoating> roofCoatings = MaterialMapper.getRoofCoatings();
        assertThat(roofCoatings, hasSize(2));
        assertThat(roofCoatings,hasItem(hasProperty("name",equalTo("Græs tag"))));
        assertThat(roofCoatings,hasItem(hasProperty("price",equalTo(200))));

    }

    @Test
    public void testAddTiltedRoofCoating() throws LoginSampleException {
        // Can we update a TiltedRoofCoating objects name and price
        String newName = "Græs tag";
        int newPrice = 200;

        MaterialMapper.addTiltedRoofCoating(newName,newPrice);

        ArrayList<TiltedRoofCoating> TiltedRoofCoatings = MaterialMapper.getTiltedRoofCoatings();
        assertThat(TiltedRoofCoatings, hasSize(1));
        assertThat(TiltedRoofCoatings,hasItem(hasProperty("name",equalTo("Græs tag"))));
        assertThat(TiltedRoofCoatings,hasItem(hasProperty("price",equalTo(200))));

    }

    @Test
    public void testAddShedClothing() throws LoginSampleException {
        // Can we update a ShedClothing objects name and price
        String newName = "Falsk mursten";
        int newPrice = 5;

        MaterialMapper.addShedClothing(newName,newPrice);

        ArrayList<ShedClothing> ShedClothings = MaterialMapper.getShedClothing();
        assertThat(ShedClothings, hasSize(2));
        assertThat(ShedClothings,hasItem(hasProperty("name",equalTo("Falsk mursten"))));
        assertThat(ShedClothings,hasItem(hasProperty("price",equalTo(5))));

    }
*/

}