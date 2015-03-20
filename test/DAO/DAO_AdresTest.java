package DAO;

import java.sql.SQLException;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domein_klassen.Adres;
import domein_klassen.Persoon;

public class DAO_AdresTest {

    static DAO_Manager manager;

    public DAO_AdresTest() {
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
        Adres adres = new Adres();

        adres.setStraatnaam("Bloemensingel");
        adres.setHuisnummer(1312);
        adres.setToevoeging("b");
        adres.setPostcode("2353AC");
        adres.setWoonplaats("Utreg");

        manager.getDAO_Adres().create(adres);

        int adresId = manager.getDAO_Adres().getAdresId(adres.getPostcode(), adres.getHuisnummer(), adres.getToevoeging());
        System.out.println(adresId);
        Adres adres2 = (Adres) manager.getDAO_Adres().read(adresId);
        assertNotNull("Address from database not null?", adres2);
        System.out.println(adres2.getStraatnaam());
        assertEquals(adres, adres2);

    }
    
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateException() throws SQLException{
                      
        manager.getDAO_Adres().create(new Persoon());
          
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNull() throws SQLException{
        Adres adres = new Adres();
        manager.getDAO_Adres().create(adres);
    }

    @Test
    public void testUpdate() throws SQLException {
        Adres adres = new Adres();

        adres.setStraatnaam("Bloemensingel");
        adres.setHuisnummer(1312);
        adres.setToevoeging("b");
        adres.setPostcode("2353AC");
        adres.setWoonplaats("Utreg");

        manager.getDAO_Adres().create(adres);

        int adresId = manager.getDAO_Adres().getAdresId(adres.getPostcode(), adres.getHuisnummer(), adres.getToevoeging());
        Adres adres2 = (Adres) manager.getDAO_Adres().read(adresId);
        assertNotNull("Address from database not null?", adres2);
        adres2.setHuisnummer(666);
        adres2.setStraatnaam("Oeleboelestraat");
        adres2.setWoonplaats("Schubbekutteveen");
        adres2.setToevoeging("");
        adres2.setPostcode("1234AB");
        manager.getDAO_Adres().update(adres2);
        Adres adres3 = (Adres)manager.getDAO_Adres().read(adresId);
        assertTrue(adres != adres3);
        
    }
    
    @Test
    public void testRead() throws SQLException {
        Adres adres = new Adres();

        adres.setStraatnaam("Bloemensingel");
        adres.setHuisnummer(1312);
        adres.setToevoeging("b");
        adres.setPostcode("2353AC");
        adres.setWoonplaats("Utreg");

        manager.getDAO_Adres().create(adres);

        int adresId = manager.getDAO_Adres().getAdresId(adres.getPostcode(), adres.getHuisnummer(), adres.getToevoeging());
        Adres adres2 = (Adres) manager.getDAO_Adres().read(adresId);
        assertNotNull("Straatnaam from database not null?", adres2.getStraatnaam());
        assertNotNull("Huisnummer  from database not null?", adres2.getHuisnummer());
        assertNotNull("Toevoeging from database not null?", adres2.getToevoeging());
        assertNotNull("Postcode from database not null?", adres2.getPostcode());
        assertNotNull("Woonplaats from database not null?", adres2.getWoonplaats());
        
        assertEquals(adres, adres2);
        
    }
    
    @Test
    public void testDelete() throws SQLException {
        Adres adres = new Adres();

        adres.setStraatnaam("Bloemensingel");
        adres.setHuisnummer(1312);
        adres.setToevoeging("b");
        adres.setPostcode("2353AC");
        adres.setWoonplaats("Utreg");

        manager.getDAO_Adres().create(adres);

        int adresId = manager.getDAO_Adres().getAdresId(adres.getPostcode(), adres.getHuisnummer(), adres.getToevoeging());
        manager.getDAO_Adres().delete(adresId);
        Adres adres2 = (Adres)manager.getDAO_Adres().read(adresId);
        assertNull(adres2);
        
    }
    
}
