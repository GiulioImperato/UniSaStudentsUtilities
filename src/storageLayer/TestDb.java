package storageLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database.openConnection();
		PreparedStatement selectUser = Database.getPreparedStatement(
				"INSERT INTO redteam.utente (`Nome`, `Cognome`, `Email`, `Password`, `Status`, `PrivilegioAdmin`) VALUES (?,?,?,?, ?, ?);");
		
		try {
			selectUser.setString(1, "Domenico");
			selectUser.setString(2, "Tropeano");
			selectUser.setString(3, "dtropeano@hotmail.it");
			selectUser.setString(4, "P@ssw0rd");
			selectUser.setInt(5, 0);
			selectUser.setInt(6, 0);
			selectUser.executeUpdate();
			//DBTablePrinter.printResultSet(output);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
