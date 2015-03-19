import domein_klassen.*;
import DAO.*;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		Persoon persoon = new Persoon();
		persoon.setVoornaam("James");
		persoon.setAchternaam("Bond");
		persoon.setId(7);
		persoon.setGeboortedatum("22-12-1975");

		Adres adres = new Adres();
		adres.setId(9);
		adres.setStraatnaam("Bloemenlaan");
		adres.setHuisnummer(007);
		adres.setPostcode("3854XF");
		adres.setWoonplaats("Utrecht");

//		Resultaat resultaat = new Resultaat();
//		resultaat.setId(1);
//		resultaat.setIdPersoon(1);
//		resultaat.setModulenaam("Java Programmer 1");
//		resultaat.setResultaat(94);
//		resultaat.setVoldoende(true);

		//persoon.setAdres(adres);
		
		DAO_Manager manager = new DAO_Manager();
		try {
			manager.getDAO_Persoon().create(persoon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
