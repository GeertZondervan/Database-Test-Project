import domein_klassen.*;
import DAO.*;
import java.sql.SQLException;

public class Test_Class {
	public static void main(String[] args) throws SQLException {
            DAO_Manager manager = new DAO_Manager();
            
            
            int id = manager.getDAO_Adres().getAdresId("2345FL", 24);
            System.out.println(id);
            manager.closeConnection();
            
        }
}
