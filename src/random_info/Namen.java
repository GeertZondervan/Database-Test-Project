package random_info;

import java.util.*;
import java.io.*;

public class Namen {
	private static String[][] voornamen = new String[2][1000];
	private static String[] achternamen = new String[100];
        private static String[] tussenvoegsel = {"", "van", "van de", "van der", "de"};
        private static String[] typeStraat = {"straat", "plein", "laan", "pad"};
        private static String[] straatnaam = new String[44];
	private static String[] woonplaatsen = {"Leeuwarden", "Groningen", "Assen", "Arnhem", "Lelystad", "Zwolle", "Utrecht",
            "Haarlem", "Den Haag", "Middelburg", "Den Bosch", "Maastricht", "Hilversum", "Amersfoort", "Driebergen", "Leiden"};
        private static String[] toevoeging = {"", "a", "b", "I", "II", "III"};
        private static String[] modules = {"Java basics", "Database", "Wiskunde"};
        
        
        private static String filename = "src/Babynamesranking2010.txt";
	private static String filename2 = "src/surnames.txt";
        private static String filename3 = "src/presidents.txt";
        
        
	
	static {
		try (Scanner input = new Scanner(new File(filename))) {
			int i = 0;
			while (input.hasNext()) {
				input.nextInt(); // Skip the ranking
				voornamen[0][i] = input.next();
				input.next(); // Skip the number of boy's name
				voornamen[1][i] = input.next();
				input.next(); // Skip the number of girl's name
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	static {
		try (Scanner input = new Scanner(new File(filename2))) {
			int i = 0;
			while (input.hasNext()) {
				input.nextInt(); // Skip the ranking
				achternamen[i] = input.next();
				input.next();
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
        static{
            try (Scanner input = new Scanner(new File(filename3))) {
			int i = 0;
			while (input.hasNext()) {
				straatnaam[i] = input.nextLine();
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
        
	public static String getVoornaam(int i, int j) {
		return voornamen[i][j];
	}
	public static String getAchternaam(int i) {
		return achternamen[i];
	}
        public static String getTussenvoegsel(int i) {
		return tussenvoegsel[i];
	}
        
        public static String getStraatnaam(int i){
            return straatnaam[i] + typeStraat[(int)(Math.random() * 4)];
        }
        
        public static String getWoonplaats(int i) {
		return woonplaatsen[i];
	}
        public static String getModule(int i){
            return modules[i];
        }
        public static String getToevoeging(int i){
            return toevoeging[i];
        }
}