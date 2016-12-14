package onlyTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestioneUtente.Utente;
import storageLayer.DatabaseGU;

public class TestDb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		byte a=1;
		byte c=0;
		//boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco", "giggimiticol@hotmail.it", "cucccabacucco",a ,c));
		boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		System.out.println(b);
		//System.out.println(DatabaseGU.isValidMail("cicciobello@hotmail.it"));
	}

}
