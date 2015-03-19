
package random_info;
import DAO.*;
import domein_klassen.*;
import java.sql.SQLException;
public class Random_Generator {
    public static void main(String[] args) throws SQLException {
        DAO_Manager manager = new DAO_Manager();
        try {
            for (int i = 1; i <= 5000; i++) {
                Persoon persoon = new Persoon();
                Adres adres = new Adres();
                persoon.setId(i);
                persoon.setVoornaam(Namen.getVoornaam(i % 2, (int) (Math.random() * 1000)));
                persoon.setAchternaam(Namen.getAchternaam((int) (Math.random() * 100)));
                persoon.setAdres(adres);
                String s = "";
                int dag = (int) (Math.random() * 28 + 1);
                if (dag < 10) {
                    s += 0;
                }
                s += dag;
                s += "-";
                s += (int) (Math.random() * 12 + 1);
                s += "-";
                s += (int) (Math.random() * 39 + 1960);
                persoon.setGeboortedatum(s);
                persoon.setTussenvoegsel(Namen.getTussenvoegsel((int) (Math.random() * 5)));
                adres.setHuisnummer((int) (Math.random() * 200));
                adres.setToevoeging(Namen.getToevoeging((int)(Math.random() * 6)));
                adres.setStraatnaam(Namen.getStraatnaam((int) (Math.random() * 44)));
                String s2 = "";
                s2 += (int) (Math.random() * 8888 + 1111);
                s2 += (char) ('A' + (int) (Math.random() * 26));
                s2 += (char) ('A' + (int) (Math.random() * 26));
                adres.setPostcode(s2);
                adres.setId(i);
                adres.setWoonplaats(Namen.getWoonplaats((int) (Math.random() * 16)));

                //Persoon en adres naar database schrijven
                manager.getDAO_Persoon().create(persoon);
                manager.getDAO_Adres().create(adres);
            }
            for(int i = 1; i <= 2000; i++){
                Resultaat resultaat = new Resultaat();
                resultaat.setId(i);
                resultaat.setIdPersoon((int)(Math.random()*5000 + 1));
                resultaat.setModulenaam(Namen.getModule((int)(Math.random() * 3)));
                float cijfer = (float)(Math.random() * 10);
                resultaat.setResultaat(cijfer);
                resultaat.setVoldoende(cijfer >= 5.5 ? true : false);
                
                manager.getDAO_Resultaat().create(resultaat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.closeConnection();
        }
    }
}

