package test;

import java.sql.SQLException;

import random_info.Namen;
import DAO.DAO_Manager;
import domein_klassen.Adres;
import domein_klassen.Persoon;

public class Tester {

	public static void main(String[] args) throws SQLException {
		//
		// Persoon persoon = new Persoon();
		// persoon.setId(7);
		// persoon.setVoornaam("James");
		// persoon.setAchternaam("Bond");
		// persoon.setGeboortedatum("22-12-1975");
		//
		// Adres adres = new Adres();
		// adres.setId(9);
		// adres.setStraatnaam("Bloemenlaan");
		// adres.setHuisnummer(007);
		// adres.setPostcode("3854XF");
		// adres.setWoonplaats("Utrecht");
		//
		// persoon.setAdres(adres);
		//
		// DAO_Manager manager = new DAO_Manager();
		// manager.getDAO_Adres().create(adres);
		// manager.getDAO_Persoon().create(persoon);
		DAO_Manager manager = new DAO_Manager();
		try {
			for (int i = 1; i <= 5000; i++) {
				Persoon persoon = new Persoon();
				Adres adres = new Adres();

				adres.setId(i);
				adres.setHuisnummer((int) (Math.random() * 200));
				adres.setToevoeging(Namen.getToevoeging((int) (Math.random() * 6)));
				adres.setStraatnaam(Namen.getStraatnaam((int) (Math.random() * 44)));
				String s2 = "";
				s2 += (int) (Math.random() * 8888 + 1111);
				s2 += (char) ('A' + (int) (Math.random() * 26));
				s2 += (char) ('A' + (int) (Math.random() * 26));
				adres.setPostcode(s2);

				adres.setWoonplaats(Namen.getWoonplaats((int) (Math.random() * 16)));

				persoon.setAdres(adres);

				persoon.setId(i);
				persoon.setVoornaam(Namen.getVoornaam(i % 2,
						(int) (Math.random() * 1000)));
				persoon.setAchternaam(Namen.getAchternaam((int) (Math.random() * 100)));

				String s = "";
				int dag = (int) (Math.random() * 28 + 1);
				if (dag < 10) {
					s += 0;
				}
				s += dag;
				s += "-";
				int maand = (int) (Math.random() * 12 + 1);
				if (maand < 10) {
					s += 0;
				}
				s += maand;
				s += "-";
				s += (int) (Math.random() * 39 + 1960);
				persoon.setGeboortedatum(s);
				persoon.setTussenvoegsel(Namen.getTussenvoegsel((int) (Math
						.random() * 5)));

				// Persoon en adres naar database schrijven
				manager.getDAO_Adres().create(adres);
				manager.getDAO_Persoon().create(persoon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.closeConnection();
		}
	}

}
