
package DAO;

import domein_klassen.POJO_Interface;
import domein_klassen.Persoon;
import java.sql.SQLException;
import javax.naming.ldap.ManageReferralControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAO_PersoonTest {
    static DAO_Manager manager;
    public DAO_PersoonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        manager = new DAO_Manager();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        try{
            manager.closeConnection();
        }
        catch(SQLException ex){
            System.out.println("Connection is not closed");
        }
    }
    
 //   @Before
//    public void setUp() {
 //   }
    
 //   @After
  //  public void tearDown() {
  //  }

    /**
     * Test of create method, of class DAO_Persoon.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Persoon obj = new Persoon();
        obj.setVoornaam("VoorNaam");
        obj.setAchternaam("AchterNaam");
        obj.setTussenvoegsel("TV");
        obj.setGeboortedatum("11-11-1911");
        DAO_Persoon instance = manager.getDAO_Persoon();
        instance.create(obj);
        
        Persoon result = (Persoon)instance.read(instance.getPersoonId("VoorNaam", "AchterNaam"));
        assertNotNull("obj, must not be null", obj);
        assertNotNull("Result, must not be null", result);
        assertEquals("id, must be equal", obj.getId(), result.getId());
        assertEquals("geboortedatum, must be equal", obj.getGeboortedatum(), result.getGeboortedatum());
        assertEquals("tussenvoegsel, must be equal", obj.getTussenvoegsel(), result.getTussenvoegsel());
    }

    /**
     * Test of update method, of class DAO_Persoon.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        POJO_Interface obj = null;
        DAO_Persoon instance = null;
        instance.update(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class DAO_Persoon.
     */
    @Test
    public void testRead_int() throws Exception {
        System.out.println("read");
        int id = 0;
        DAO_Persoon instance = null;
        POJO_Interface expResult = null;
        POJO_Interface result = instance.read(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class DAO_Persoon.
     */
    @Test
    public void testRead_String_String() throws Exception {
        System.out.println("read");
        String voorNaam = "";
        String achterNaam = "";
        DAO_Persoon instance = null;
        POJO_Interface expResult = null;
        POJO_Interface result = instance.read(voorNaam, achterNaam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersoonId method, of class DAO_Persoon.
     */
    @Test
    public void testGetPersoonId() throws Exception {
        System.out.println("getPersoonId");
        String voorNaam = "";
        String achterNaam = "";
        DAO_Persoon instance = null;
        int expResult = 0;
        int result = instance.getPersoonId(voorNaam, achterNaam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DAO_Persoon.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        DAO_Persoon instance = null;
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
