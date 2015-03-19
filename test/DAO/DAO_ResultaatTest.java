package DAO;

import static DAO.DAO_AdresTest.manager;
import domein_klassen.Resultaat;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAO_ResultaatTest {

    static DAO_Manager manager;

    public DAO_ResultaatTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        manager = new DAO_Manager();
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            manager.closeConnection();
        } catch (SQLException ex) {
            System.out.println("Connection is not closed");
        }
    }

    @Test
    public void testCreate() throws SQLException {
        Resultaat resultaat = new Resultaat();
        resultaat.setModulenaam("Java Programmer 1");
        resultaat.setResultaat(94);
        resultaat.setVoldoende(true);
        int id = manager.getDAO_Persoon().getPersoonId("Harthold", "Jensen");
        resultaat.setIdPersoon(id);
        manager.getDAO_Resultaat().create(resultaat);

        int resultaatId = manager.getDAO_Resultaat().getResultaatId(id, resultaat.getModulenaam());
        Resultaat resultaat2 = (Resultaat) manager.getDAO_Resultaat().read(resultaatId);
        assertNotNull("Resultaat from database not null?", resultaat2);
        assertEquals(resultaat, resultaat2);

    }
    
    @Test
    public void testUpdate() throws SQLException {
        Resultaat resultaat = new Resultaat();
        resultaat.setModulenaam("Java Programmer 1");
        resultaat.setResultaat(94);
        resultaat.setVoldoende(true);
        int id = manager.getDAO_Persoon().getPersoonId("Harthold", "Jensen");
        resultaat.setIdPersoon(id);
        manager.getDAO_Resultaat().create(resultaat);
        
        int resultaatId = manager.getDAO_Resultaat().getResultaatId(id, resultaat.getModulenaam());
        Resultaat resultaat2 = (Resultaat) manager.getDAO_Resultaat().read(resultaatId);
        assertNotNull("Resultaat from database not null?", resultaat2);
        resultaat2.setIdPersoon(5);
        resultaat2.setModulenaam("Java Programmer 2");
        resultaat2.setResultaat(30);
        resultaat2.setVoldoende(false);
        
        manager.getDAO_Resultaat().update(resultaat2);
        
        Resultaat resultaat3 = (Resultaat)manager.getDAO_Resultaat().read(id);
        assertTrue(resultaat != resultaat3);
    }
    
    @Test
    public void testRead() throws SQLException {
        Resultaat resultaat = new Resultaat();
        resultaat.setModulenaam("Java Programmer 1");
        resultaat.setResultaat(94);
        resultaat.setVoldoende(true);
        int id = manager.getDAO_Persoon().getPersoonId("Harthold", "Jensen");
        resultaat.setIdPersoon(id);
        
        manager.getDAO_Resultaat().create(resultaat);
        
        int resultaatId = manager.getDAO_Resultaat().getResultaatId(id, resultaat.getModulenaam());
        
        Resultaat resultaat2 = (Resultaat) manager.getDAO_Resultaat().read(resultaatId);
        
        assertNotNull("PersoonId from database not null?", resultaat2.getIdPersoon());
        assertNotNull("Modulenaam from database not null?", resultaat2.getModulenaam());
        assertNotNull("Resultaat from database not null?", resultaat2.getResultaat());
        assertNotNull("IsVoldoende from database not null?", resultaat2.isVoldoende());
        
        assertEquals(resultaat, resultaat2); 
    }
    
    public void testDelete() throws SQLException {
        Resultaat resultaat = new Resultaat();
        resultaat.setModulenaam("Java Programmer 1");
        resultaat.setResultaat(94);
        resultaat.setVoldoende(true);
        int id = manager.getDAO_Persoon().getPersoonId("Harthold", "Jensen");
        resultaat.setIdPersoon(id);
        
        manager.getDAO_Resultaat().create(resultaat);
        
        int resultaatId = manager.getDAO_Resultaat().getResultaatId(id, resultaat.getModulenaam());
        manager.getDAO_Resultaat().delete(resultaatId);
        
        Resultaat resultaat2 = (Resultaat) manager.getDAO_Resultaat().read(resultaatId);
        
        assertNull(resultaat2);
        
    }
    
}
