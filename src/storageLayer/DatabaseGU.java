package storageLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gestioneUtente.Utente;

public class DatabaseGU {
	public static boolean addUser(Utente utente) {
		PreparedStatement psAddUtente = Database.getPreparedStatement(queryAddUtente);
		try {
			psAddUtente.setString(1, utente.getNome());
			psAddUtente.setString(2, utente.getCognome());
			psAddUtente.setString(3, utente.getEmail());
			psAddUtente.setString(4, utente.getPassword());
			psAddUtente.setByte(5, utente.isStatus());
			psAddUtente.setByte(6, utente.isPrivilegioAdmin());
			System.out.println(psAddUtente.toString());
			if (psAddUtente.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	public static boolean isValidMail(String email){
		PreparedStatement psIsValidMail=Database.getPreparedStatement(queryIsValidMail);
		try {
			psIsValidMail.setString(1, email);
			ResultSet rs=psIsValidMail.executeQuery();
			if (!rs.isBeforeFirst() ) {    
			    //Il result set è vuoto quindi l'email è valida
				return true;
			} else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static boolean deleteUser(String email){
		return false;
	}
	
	
	
	
	private static String queryAddUtente;
	private static String queryEliminaAccount;
	private static String queryCambiaStatus;
	private static String queryIsValidMail;
	static {
		queryAddUtente = "INSERT INTO `redteam`.`utente` (`Nome`, `Cognome`, `Email`, `Password`, `Status`, `PrivilegioAdmin`) VALUES (?,?,?,?,?,?);";
		queryEliminaAccount= "DELETE FROM `redteam`.`utente` WHERE `idUtente`=?;";
		queryCambiaStatus= "UPDATE `redteam`.`utente` SET `Status`=? WHERE `idUtente`=?;";
		queryIsValidMail="SELECT * From redteam.utente WHERE utente.email=?;";
	}
}
