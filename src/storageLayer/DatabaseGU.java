package storageLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gestioneUtente.Utente;

public class DatabaseGU {
	/**
	 * <b>Registra un utente nel database</b>
	 * @param utente
	 * @return {@code true} se la registrazione è ok, {@code false}  altrimenti.
	 * @throws SQLException
	 */
	public static boolean addUser(Utente utente) throws SQLException {

		Connection connection = null;
		PreparedStatement psAddUtente = null;

		try {
			connection = Database.getConnection();
			psAddUtente = connection.prepareStatement(queryAddUtente);

			psAddUtente.setString(1, utente.getNome());
			psAddUtente.setString(2, utente.getCognome());
			psAddUtente.setString(3, utente.getEmail());
			psAddUtente.setString(4, utente.getPassword());
			psAddUtente.setByte(5, utente.isStatus());
			psAddUtente.setByte(6, utente.isPrivilegioAdmin());
			System.out.println(psAddUtente.toString());
			psAddUtente.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (psAddUtente != null)
					psAddUtente.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	/**
	 * 
	 * @param email
	 * @return {@code true}  se l'eliminazione è ok, {@code false}  altrimenti.
	 * @throws SQLException
	 */
	public static boolean deleteUser(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryEliminaAccount);
			preparedStatement.setString(1, email);

			result = preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	private static String queryAddUtente;
	private static String queryEliminaAccount;
	private static String queryCambiaStatus;
	private static String queryIsValidMail;
	static {
		queryAddUtente = "INSERT INTO `redteam`.`utente` (`Nome`, `Cognome`, `Email`, `Password`, `Status`, `PrivilegioAdmin`) VALUES (?,?,?,?,?,?);";
		queryEliminaAccount = "DELETE FROM `redteam`.`utente` WHERE `email`=?;";
		queryCambiaStatus = "UPDATE `redteam`.`utente` SET `Status`=? WHERE `idUtente`=?;";
		queryIsValidMail = "SELECT * From redteam.utente WHERE utente.email=?;";
	}
}
