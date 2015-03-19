import domein_klassen.*;
import DAO.*;
import java.sql.SQLException;

public class Test_Class {
	public static void main(String[] args) throws SQLException {
		Persoon persoon = new Persoon();
		persoon.setVoornaam("Harthold");
		persoon.setTussenvoegsel("G.");
		persoon.setAchternaam("Jensen");

		persoon.setGeboortedatum("22-12-1985");

		Adres adres = new Adres();

		adres.setStraatnaam("Bloemenpark");
		adres.setHuisnummer(33);
		adres.setPostcode("2353FD");
		adres.setWoonplaats("Utrecht");
		persoon.setAdres(adres);

		DAO_Manager manager = new DAO_Manager();
		
		manager.getDAO_Adres().create(adres);
		manager.getDAO_Persoon().create(persoon);
		
		
	//	Adres a2 = ((Adres) manager.getDAO_Adres().read("2353FD", 33));
		Persoon p2 = ((Persoon) manager.getDAO_Persoon().read(39));
		p2.setTussenvoegsel("X.");
		manager.getDAO_Persoon().update(p2);

		Resultaat resultaat = new Resultaat();

		// resultaat.setIdPersoon(p2.getId());
		resultaat.setModulenaam("Java Programmer 1");
		resultaat.setResultaat(94);
		resultaat.setVoldoende(true);
		int id = manager.getDAO_Persoon().getPersoonId("Harthold", "Jensen");
		resultaat.setIdPersoon(id);
		manager.getDAO_Resultaat().create(resultaat);
		
		manager.closeConnection();
	}
}
