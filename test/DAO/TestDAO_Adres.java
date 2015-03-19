package test;
import java.sql.SQLException;

import DAO.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domein_klassen.Adres;

public class TestDAO_Adres {

	@Test
	public void testCreate() throws SQLException {
		Adres adres = new Adres();

		adres.setStraatnaam("Bloemensingel");
		adres.setHuisnummer(1312);
		adres.setToevoeging("b");
		adres.setPostcode("2353AC");
		adres.setWoonplaats("Utreg");
				
		DAO_Manager manager = new DAO_Manager();
		manager.getDAO_Adres().create(adres);
		
		int adresId = manager.getDAO_Adres().getAdresId(adres.getPostcode(), adres.getHuisnummer(), adres.getToevoeging());
		System.out.println(adresId);
		Adres adres2 = (Adres)manager.getDAO_Adres().read(adresId);
		System.out.println(adres2.getStraatnaam());
		assertEquals(adres, adres2);
		
	}

}
