
package DAO;

import java.sql.Connection;
import java.sql.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAO_ManagerTest {
    
    public DAO_ManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initializeDB method, of class DAO_Manager.
     */
    @Test
    public void testInitializeDB() {

        System.out.println("initializeDB");
        Connection result = null;

        try {
            String expResult = "jdbc:mysql://localhost/studenten_db";

            result = DAO_Manager.initializeDB();
            assertNotNull("Must not return null", result);
            DatabaseMetaData dbMetaData = result.getMetaData();
            assertEquals(expResult, dbMetaData.getURL());
        }
        catch(SQLException ex) {
            System.out.println("SQLException in metadata");
        }
        finally {
            try {
                result.close();

            } catch (SQLException ex) {
                System.out.println("COnnection not closed");
            }
        }
    }
    /**
     * Test of closeConnection method, of class DAO_Manager.
     */
    @Test
    public void testCloseConnection() throws Exception {
        System.out.println("closeConnection");
        DAO_Manager instance = new DAO_Manager();
        Connection connection = DAO_Manager.initializeDB();
        instance.closeConnection();
       
        assertTrue("Connection is not closed",connection.isClosed());
    }

    /**
     * Test of getDAO_Persoon method, of class DAO_Manager.
     */
    @Test
    public void testGetDAO_Persoon() {
        System.out.println("getDAO_Persoon");
        DAO_Manager instance = new DAO_Manager();
        DAO_Persoon expResult = instance.getDAO_Persoon();
        DAO_Persoon result = instance.getDAO_Persoon();
        assertNotNull("result must not be null", result);
        assertSame("They are not the same",expResult, result);
       
    }

    /**
     * Test of getDAO_Adres method, of class DAO_Manager.
     */
    @Test
    public void testGetDAO_Adres() {
        System.out.println("getDAO_Adres");
        DAO_Manager instance = new DAO_Manager();
        DAO_Adres expResult = instance.getDAO_Adres();
        DAO_Adres result = instance.getDAO_Adres();
        assertNotNull("result must not be null", result);
        assertSame("They are not the same",expResult, result);
       
    }
    

    /**
     * Test of getDAO_Resultaat method, of class DAO_Manager.
     */
    @Test
    public void testGetDAO_Resultaat() {
        System.out.println("getDAO_Resultaat");
        DAO_Manager instance = new DAO_Manager();
        DAO_Resultaat expResult = instance.getDAO_Resultaat();
        DAO_Resultaat result = instance.getDAO_Resultaat();
        assertNotNull("result must not be null", result);
        assertSame("They are not the same",expResult, result);
       
    }
    }
    

