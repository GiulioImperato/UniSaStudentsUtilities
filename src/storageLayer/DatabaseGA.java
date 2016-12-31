package storageLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import gestioneAule.Aula;
import gestioneAule.Giorno;
import gestioneAule.OraAula;

public class DatabaseGA {
/**
 * Metodo che ritorna un arraylist contenente tutte le Aule
 * @return Array di Aule
 * @author Tropeano Domenico Antonio
 * @throws SQLException 
 */
	public static ArrayList<Aula> getListaAule() throws SQLException {
		Connection connection = null;
		PreparedStatement psGetListaAule = null;
		ArrayList<Aula> listaAule = new ArrayList<Aula>();
		try {
			connection = Database.getConnection();
			psGetListaAule = connection.prepareStatement(queryGetListaAule);
			ResultSet rs = psGetListaAule.executeQuery();
			while (rs.next()) {
				Aula a = new Aula(rs.getString("Nome"), rs.getDouble("CoordinateX"), rs.getDouble("CoordinateY"));
				listaAule.add(a);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psGetListaAule != null)
					psGetListaAule.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return listaAule;
	}
/**
 * Metodo che ritorna un arrayList di aule libere
 * @param giorno
 * @param oraInizio
 * @param oraFine
 * @return ArrayList di aule libere
 * @author Tropeano Domenico Antonio
 * @throws SQLException 
 */
	public static ArrayList<Aula> ricercaAule(Giorno giorno, Time oraInizio, Time oraFine) throws SQLException {

		Connection connection = null;
		PreparedStatement psRicercaAula = null;
		ArrayList<Aula> listaAuleLibere = new ArrayList<Aula>();
		try {
			connection = Database.getConnection();
			psRicercaAula = connection.prepareStatement(queryRicercaAule);
			psRicercaAula.setString(1, giorno.name());
			psRicercaAula.setTime(2, oraInizio);
			psRicercaAula.setTime(3, oraFine);
			ResultSet rs = psRicercaAula.executeQuery();
			while (rs.next()) {
				Aula a = new Aula(rs.getString("Nome"), rs.getDouble("CoordinateX"), rs.getDouble("CoordinateY"));
				listaAuleLibere.add(a);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psRicercaAula != null)
					psRicercaAula.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return listaAuleLibere;

	}
/**
 * Metodo che ritorna un ArrayList di oreAula 
 * @param nome
 * @param giorno
 * @return array di OreAula
 * @author Tropeano Domenico Antonio
 * @throws SQLException 
 */
	public static ArrayList<OraAula> visualizzaInfoAula(String nome, Giorno giorno) throws SQLException {			
		Connection connection = null;
		PreparedStatement psVisualizzaInfoAula = null;
		ArrayList<OraAula> listaInfoAula = new ArrayList<OraAula>();
		try {
			connection = Database.getConnection();
			psVisualizzaInfoAula = connection.prepareStatement(queryVisualizzaInfoAule);
			psVisualizzaInfoAula.setString(1, nome);
			psVisualizzaInfoAula.setString(2, giorno.name()); 
			
			ResultSet rs = psVisualizzaInfoAula.executeQuery();
			while (rs.next()) {
				Giorno g = Giorno.valueOf(rs.getString("giorno"));
				OraAula a = new OraAula(rs.getString("Nome"), g, rs.getTime("oraInizio"), rs.getTime("oraFine"),
						rs.getBoolean("defaultStatus"), rs.getBoolean("feedStatus"), rs.getString("emailUtente"));
				listaInfoAula.add(a);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psVisualizzaInfoAula != null)
					psVisualizzaInfoAula.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return listaInfoAula;

	}
/**
 * Metodo che invia un feedback per un'aula
 * @param status
 * @param emailUtente
 * @param nome (Il nome dell'aula)
 * @param giorno (In quale giorno si sta settando lo stato dell'aula)
 * @return {@code true} se e' ok, {@code false}  altrimenti.
 * @throws SQLException 
 */
	public static boolean invioFeedback(boolean status, String emailUtente, String nome, Giorno giorno) throws SQLException {
		Connection connection = null;
		PreparedStatement psInvioFeedback = null;
		
		try {
			connection = Database.getConnection();
			psInvioFeedback = connection.prepareStatement(queryInvioFeedback);

			psInvioFeedback.setBoolean(1, status);
			psInvioFeedback.setString(2, emailUtente);
			psInvioFeedback.setString(3, nome);
			psInvioFeedback.setString(4, giorno.name());
			
			psInvioFeedback.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psInvioFeedback != null)
					psInvioFeedback.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	}
	
	/**
	 * Metodo che setta lo stato dell'aula di default dopo 1 ora
	 * @param status
	 * @param nome
	 * @param giorno
	 * @return
	 * @throws SQLException
	 */
	public static boolean resetFeedback(String nome, Giorno giorno) throws SQLException {
		Connection connection = null;
		PreparedStatement psInvioFeedback = null;

		try {
			connection = Database.getConnection();
			psInvioFeedback = connection.prepareStatement(queryResetFeedback);

			psInvioFeedback.setString(1, nome);
			psInvioFeedback.setString(2, giorno.name());
			
			psInvioFeedback.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psInvioFeedback != null)
					psInvioFeedback.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	}

	private static String queryGetListaAule;
	private static String queryRicercaAule;
	private static String queryVisualizzaInfoAule;
	private static String queryInvioFeedback;
	private static String queryResetFeedback;
	static {
		queryGetListaAule = "SELECT * FROM redteam.aula";
		queryRicercaAule = "SELECT distinct a.Nome,CoordinateX,CoordinateY "
				+ "FROM redteam.aula as a,redteam.oraaula as oa "
				+ "WHERE oa.giorno =?  and oa.oraInizio >= ? and oa.oraFine <= ? and oa.defaultStatus = true and a.nome = oa.nome";
		queryVisualizzaInfoAule = "SELECT Nome, Giorno ,OraInizio, OraFine, defaultStatus, feedStatus, emailUtente "
				+ "FROM redteam.oraaula " + "WHERE nome = ?  and giorno = ? and defaultStatus = false";
		queryInvioFeedback = "UPDATE redteam.oraaula " + "SET feedStatus = ?, emailUtente = ?"
				+ "where nome = ? and giorno = ?";
		queryResetFeedback = "UPDATE redteam.oraaula " + "SET feedStatus = defaultStatus, emailUtente = null"
				+ "where nome = ? and giorno = ?";
	}

}
