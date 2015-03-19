package DAO;
import java.sql.SQLException;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domein_klassen.Adres;

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
	        try{
	            manager.closeConnection();
	        }
	        catch(SQLException ex){
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
		Adres adres2 = (Adres)manager.getDAO_Adres().read(adresId);
		assertNotNull("Address from database not null?", adres2);
		System.out.println(adres2.getStraatnaam());
		assertEquals(adres, adres2);
		
	}

}
