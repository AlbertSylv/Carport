package FunctionLayer;
import DBAccess.Connector;
import DBAccess.MaterialMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
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
            //requests
            stmt.execute("drop table if exists requests");
            stmt.execute("create table requests like carport.requests");
            stmt.execute("insert into requests values" +
                    "(1,1,2,2,200,200,200,150,0,'Halløj','jegerenged@gmail.com')," +
                    "(2,2,1,3,170,200,200,150,45,'Halloo','jegerenged@gmail.com');");


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
    //Jeg laver ikke test af alle calculator metoderr, jeg laver bare på nogle få for at vise at jeg forstår test konceptet.

    @Test
    public void testGetPole() throws LoginSampleException {
        //i virkeligheden burde man have mange forskellige tests af denne metode, fordi der er så mange if's i den. De fleste metoder i calculatoren er faktisk alt for store og burde koges ned i meget mindre dele.
        //Vil teste om beregnede antal pæl meter passer
        //Denne carport er 200 cm lang og bred med et skur der er 200 bred og 150 lang
        //Det skulle efter mine beregninger gerne give 8 pæle som hver er 3 meter lange.
        // 8 * 3 = 24
        int id = 1;
        Wood pæl = Calculator.getPole(id);

        assertEquals(24, pæl.meters);
        //Det var fandme rigtigt!

    }
@Test
    public void testGetSpær() throws LoginSampleException {
    //Vil teste om beregnede antal spær meter passer
    //først ligger der to spær oven på pælene de er 230 cm hver = 460 = 5 meter
    //så placeres spær oven på disse som remme
    //denne carport er med rejsning, så der er 89, cm mellem remmene. På 230 centimeters længde kan der være 89 cm ca. 2.5 gange. Det runder jeg op til 3 gange, så der skal ligge 4 remme på tværs af carporten.
    //4 remme af 200 cm = 8 meter
    //hver gang der er en rem på tværs skal der dog også være en trekant af spær, som former rejsningen.
    //trekanten har en vinkel på 45 grader, og er 200 cm bred.
    //Trekanten kan deles op i to retvinklede trekanter, som hver er 100 cm bredde hver.
    //længden af hypotenusen i trekanten findes ved at tage bredden divideret med cosinus til vinklen
    //1 meter / cos(45 grader) = 1.414213562373095
    //Der er en hypotenuse i hver side af trekanten
    //1.414213562373095 * 2 hypotenuser = 2.82842712474619
    //der var 4 remme på tværs, hvilket betyder at der skal bruges 4 trekanter
    //2.82842712474619 * 4 = 11.31370849898476 = 12 meter
    //5 + 8 + 12 = 25 meter
        int id = 2;
        Wood spær = Calculator.getSpær(id);

        assertEquals(25, spær.meters);
        //Det var fandme ikke rigtigt, men jeg har rettet i metoden, så det er det nu! Igen må jeg sige at jeg virkelig burde have delt metoden op i mindre bider... Virkelig svært at finde ud af hvor det er galt, når man smider så mange beregninger i en metode.

    }

    @Test
    public void testGetRegel() throws LoginSampleException {
        //Her tester jeg igen om antal meter stemmer, fordi det er det som er mest interessant at teste
        //Der ligger en øvre og en nedre regel hele vejen rundt på skurets væg
        //Det vil sige at det er omkredsen af skuret gange 2
        //Dimensionerne i dette skur er 200 x 150
        //beregningen lyder altså 200 x 4 = 800 = 8 meter
        //150 x 4 = 600 = 6 meter
        //8 + 5 = 14 meter

        int id = 2;

        Wood regel = Calculator.getRegel(id);

        assertEquals(14, regel.meters);
        //Den var fandme rigtig!

    }






}
