package storageLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestioneAule.Aula;
import gestioneAule.OraAula;

public class DatabaseGA {
public static boolean InsertAula(OraAula oraAula){
	Connection connection = null;
	PreparedStatement psInsertOraAula = null;
	
	try {
		connection=Database.getConnection();
		psInsertOraAula=connection.prepareStatement(queryAddOraAula);
		psInsertOraAula.setString(1, oraAula.getNome());
		psInsertOraAula.setString(2, "mer");//da cambiare
		psInsertOraAula.setTime(3, oraAula.getOraInizio());
		psInsertOraAula.setTime(4, oraAula.getOraFine());
		psInsertOraAula.setBoolean(5, false);//da cambiare
		psInsertOraAula.setBoolean(6, oraAula.getFeedStatus());
		psInsertOraAula.setString(7, oraAula.getEmailUtente());
		System.out.println(psInsertOraAula);
		psInsertOraAula.executeUpdate();
		connection.commit();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			Database.releaseConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return true;
}
	public static String queryAddOraAula;
	static {
		queryAddOraAula = "INSERT INTO `redteam`.`oraaula` (`Nome`, `giorno`, `oraInizio`, `oraFine`, `defaultStatus`, `feedStatus`, `emailUtente`) VALUES (?, ?, ?, ?, ?, ?, ?);";
	}

}
