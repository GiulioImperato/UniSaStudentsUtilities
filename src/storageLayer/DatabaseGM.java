package storageLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import gestioneMaterialeDidattico.Risorsa;


public class DatabaseGM {

	
	
	/**
	 * Restituisce ,se esiste, un oggetto Risorsa data un ID
	 * @param idRisorsa
	 * @return {@code null}  se l'utene non esiste, {@code Risorsa Utente }  altrimenti.
	 * @throws SQLException
	  * @author Domenico Tropeano
	 */

	public static Risorsa getRisorsaByID(int idRisorsa) {
		Connection connection = null;
		PreparedStatement psGetRisorsaByID = null;
		Risorsa risorsa = new Risorsa();
		try {
			connection = Database.getConnection();
			psGetRisorsaByID = connection.prepareStatement(queryGetRisorsa);
			
			psGetRisorsaByID.setInt(1, idRisorsa);
			System.out.println(psGetRisorsaByID);
			ResultSet rs = psGetRisorsaByID.executeQuery();
			
			
			if (!rs.isBeforeFirst() ) {    
			    return null; 
			} 
											
			while (rs.next()) {
				risorsa.setIdRisorsa(rs.getInt("idRisorsa"));
				risorsa.setNome(rs.getString("Nome"));
				risorsa.setDimensione(rs.getDouble("Dimensione"));
				risorsa.setDataUpload(rs.getDate("dataUpload"));
				risorsa.setProprietario(rs.getString("Proprietario"));
				risorsa.setLike(rs.getInt("Like"));
				risorsa.setDislike(rs.getInt("Dislike"));
				risorsa.setPathCaricamento(rs.getString("PathCaricamento"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psGetRisorsaByID != null)
					psGetRisorsaByID.close();
				Database.releaseConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return risorsa;
	}

	/**
	 * <b>Salva una risorsa nel database</b>
	 * @param risorsa
	 * @return {@code true} se il salvataggio è ok, {@code false}  altrimenti.
	 * @throws SQLException
	 * @author Domenico Tropeano
	 */
	public static int insertRisorsa(Risorsa risorsa) {
		Connection connection = null;
		PreparedStatement psGetRisorsaByID = null;
		int lastID = 0;
		try {
			connection = Database.getConnection();
			psGetRisorsaByID = connection.prepareStatement(queryInsertRisorsa, Statement.RETURN_GENERATED_KEYS);
			psGetRisorsaByID.setString(1, risorsa.getNome());
			psGetRisorsaByID.setDouble(2, risorsa.getDimensione());
			psGetRisorsaByID.setDate(3, risorsa.getDataUpload());
			psGetRisorsaByID.setString(4, risorsa.getProprietario());
			psGetRisorsaByID.setInt(5, risorsa.getLike());
			psGetRisorsaByID.setInt(6, risorsa.getDislike());
			psGetRisorsaByID.setString(7, risorsa.getPathCaricamento());
			psGetRisorsaByID.executeUpdate();
			connection.commit();
			ResultSet rs = psGetRisorsaByID.getGeneratedKeys();
			if (rs.next()) {
				lastID = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastID;
	}

	/**
	 * <b>Elimina una Risorsa dal database</b>
	 * @param id 
	 * @return {@code true}  se l'eliminazione è ok, {@code false}  altrimenti.
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static boolean deleteRisorsa(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryDeleteRisorsa);
			preparedStatement.setInt(1, id);

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
	
	/**
	 * <b>Elimina tutte le Risorsa publicate da un utente</b>
	 * @param idUtente email utente
	 * @return {@code true}  se l'eliminazione è ok, {@code false}  altrimenti.
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static boolean deleteRisorseOfUtente(String idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryDeleteRisorsaOfUtente);
			preparedStatement.setString(1, idUtente);

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

	/**
	 * Restituisce tutti le risorse del database
	 * @return {@code null}  se non esistono risorse, {@code ArrayListRisorse }  altrimenti.
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static ArrayList<Risorsa> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Risorsa> risorse = new ArrayList<Risorsa>();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetAllRisorse);

			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();

			while (rs.next()) {
				Risorsa risorsa = new Risorsa();	
				
				risorsa.setIdRisorsa(rs.getInt("idRisorsa"));
				risorsa.setNome(rs.getString("Nome"));
				risorsa.setDimensione(rs.getDouble("Dimensione"));
				risorsa.setDataUpload(rs.getDate("dataUpload"));
				risorsa.setProprietario(rs.getString("Proprietario"));
				risorsa.setLike(rs.getInt("Like"));
				risorsa.setDislike(rs.getInt("Dislike"));
				risorsa.setPathCaricamento(rs.getString("PathCaricamento"));	

				risorse.add(risorsa);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		if(risorse.size()<1)
			return null;
		else  		
			return risorse ;
	}


	/**
	 * Restituisce tutti le risorse pubblicate da un utente
	 * @return {@code null}  se non esistono risorse, {@code ArrayListRisorse }  altrimenti.
	 * @param idUtente emeil del utente 
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static ArrayList<Risorsa> doRetrieveAllByUtente(String idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Risorsa> risorse = new ArrayList<Risorsa>();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetRisorseUtente);
			preparedStatement.setString(1, idUtente);

			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();

			while (rs.next()) {
				Risorsa risorsa = new Risorsa();	

				risorsa.setIdRisorsa(rs.getInt("idRisorsa"));
				risorsa.setNome(rs.getString("Nome"));
				risorsa.setDimensione(rs.getDouble("Dimensione"));
				risorsa.setDataUpload(rs.getDate("dataUpload"));
				risorsa.setProprietario(rs.getString("Proprietario"));
				risorsa.setLike(rs.getInt("Like"));
				risorsa.setDislike(rs.getInt("Dislike"));
				risorsa.setPathCaricamento(rs.getString("PathCaricamento"));	

				risorse.add(risorsa);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		if(risorse.size()<1)
			return null;
		else  		
			return risorse ;
	}


	/**
	 * Restituisce tutti le risorse in un determinata directory
	 * @return {@code null}  se non esistono risorse, {@code ArrayListRisorse }  altrimenti.
	 * @param path directory
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static ArrayList<Risorsa> doRetrieveAllByPath(String path) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Risorsa> risorse = new ArrayList<Risorsa>();

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryGetRisorsePath);
			preparedStatement.setString(1, path);

			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();

			while (rs.next()) {
				Risorsa risorsa = new Risorsa();	

				risorsa.setIdRisorsa(rs.getInt("idRisorsa"));
				risorsa.setNome(rs.getString("Nome"));
				risorsa.setDimensione(rs.getDouble("Dimensione"));
				risorsa.setDataUpload(rs.getDate("dataUpload"));
				risorsa.setProprietario(rs.getString("Proprietario"));
				risorsa.setLike(rs.getInt("Like"));
				risorsa.setDislike(rs.getInt("Dislike"));
				risorsa.setPathCaricamento(rs.getString("PathCaricamento"));	

				risorse.add(risorsa);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		if(risorse.size()<1)
			return null;
		else  		
			return risorse ;
	}


	/**
	 * Aggiorna i like di una risorsa
	  *@return il numero dei like aggiornato se la modifica è ok, 0  altrimenti.
	 * @param id id della risorsa 
	 * @param like  valore aggiornato
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static int aggiornaLike(int id ,int like) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryAggiornaLike);
			preparedStatement.setInt(1,like);			
			preparedStatement.setInt(2,id);

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

		if(result != 0)
			return like;
		else return 0;

	}


	/**
	 * Aggiorna i dislike di una risorsa
	 *@return il numero dei dislike aggiornato se la modifica è ok, 0  altrimenti.
	 * @param id identificativo della risorsa 
	 * @param like valore aggiornato
	 * @throws SQLException
	 * @author Antonio Corsuto
	 */
	public synchronized static int aggiornaDislike(int id ,int like) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		try {
			connection = Database.getConnection();
			preparedStatement = connection.prepareStatement(queryAggiornaDislike);
			preparedStatement.setInt(1,like);			
			preparedStatement.setInt(2,id);

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

		if(result != 0)
			return like;
		else return 0;

	}





	private static String queryGetRisorsa;
	private static String queryInsertRisorsa;	
	private static String queryDeleteRisorsa;
	private static String queryDeleteRisorsaOfUtente;
	private static String queryGetAllRisorse;	
	private static String queryGetRisorseUtente;
	private static String queryGetRisorsePath;
	private static String queryAggiornaLike;
	private static String queryAggiornaDislike;

	static {
		queryGetRisorsa = "SELECT * FROM redteam.risorsa WHERE risorsa.idRisorsa=?";
		queryInsertRisorsa = "INSERT INTO `redteam`.`risorsa` (`Nome`, `Dimensione`, `dataUpload`, `Proprietario`, `Like`, `Dislike`, `PathCaricamento`) VALUES (?,?,?,?,?,?,?);";
		queryDeleteRisorsa = "DELETE FROM `redteam`.`risorsa` WHERE `idRisorsa`=?;";
		queryDeleteRisorsaOfUtente = "DELETE FROM `redteam`.`risorsa` WHERE `proprietario`=?;";
		
		queryGetAllRisorse = "SELECT * From redteam.risorsa";		
		queryGetRisorseUtente = "SELECT * FROM `redteam`.`risorsa` WHERE `proprietaio`=?;";
		queryGetRisorsePath = "SELECT * FROM `redteam`.`risorsa` WHERE `pathCaricamento`=?;";
		queryAggiornaLike =  "UPDATE `redteam`.`risorsa` SET `like`=? WHERE `idRisorsa`=?;";
		queryAggiornaDislike ="UPDATE `redteam`.`risorsa` SET `dislike`=? WHERE `idRisorsa`=?;";
	}
}