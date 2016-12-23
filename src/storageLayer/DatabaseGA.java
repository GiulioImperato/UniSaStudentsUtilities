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
 */
	public static ArrayList<Aula> getListaAule() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				Database.releaseConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
 */
	public static ArrayList<Aula> RicercaAule(Giorno giorno, Time oraInizio, Time oraFine) {

		Connection connection = null;
		PreparedStatement psRicercaAula = null;
		ArrayList<Aula> listaAuleLibere = new ArrayList<Aula>();
		try {
			connection = Database.getConnection();
			psRicercaAula = connection.prepareStatement(queryRicercaAule);
			psRicercaAula.setString(1, giorno.name());// cosa devo prendere qui?
			psRicercaAula.setTime(2, oraInizio);
			psRicercaAula.setTime(3, oraFine);
			ResultSet rs = psRicercaAula.executeQuery();
			while (rs.next()) {
				Aula a = new Aula(rs.getString("Nome"), rs.getDouble("CoordinateX"), rs.getDouble("CoordinateY"));
				listaAuleLibere.add(a);
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				Database.releaseConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
 */
	public static ArrayList<OraAula> visualizzaInfoAula(String nome, Giorno giorno) {
		Connection connection = null;
		PreparedStatement psVisualizzaInfoAula = null;
		ArrayList<OraAula> listaOreLibere = new ArrayList<OraAula>();
		try {
			connection = Database.getConnection();
			psVisualizzaInfoAula = connection.prepareStatement(queryVisualizzaInfoAule);
			psVisualizzaInfoAula.setString(1, nome);
			psVisualizzaInfoAula.setString(2, giorno.name()); //cosa devo prendere qui?
			System.out.println(psVisualizzaInfoAula);
			ResultSet rs = psVisualizzaInfoAula.executeQuery();
			while (rs.next()) {
				Giorno g = Giorno.valueOf(rs.getString("giorno"));
				OraAula a = new OraAula(rs.getString("Nome"), g, rs.getTime("oraInizio"), rs.getTime("oraFine"),
						rs.getBoolean("defaultStatus"), rs.getBoolean("feedStatus"), rs.getString("emailUtente"));
				listaOreLibere.add(a);
			}
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				Database.releaseConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listaOreLibere;

	}
/**
 * Metodo che invia un feedback per un aula
 * @param Nome
 * @param status
 * @param emailUtente
 * @return {@code true} se e' ok, {@code false}  altrimenti.
 */
	public static boolean invioFeedback(String Nome, boolean status, String emailUtente) {
		Connection connection = null;
		PreparedStatement psInvioFeedback = null;

		try {
			connection = Database.getConnection();
			psInvioFeedback = connection.prepareStatement(queryInvioFeedback);

			psInvioFeedback.setString(1, Nome);
			psInvioFeedback.setBoolean(2, status);
			psInvioFeedback.setString(3, emailUtente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private static String queryAddOraAula;
	private static String queryGetListaAule;
	private static String queryRicercaAule;
	private static String queryVisualizzaInfoAule;
	private static String queryInvioFeedback;
	static {
		queryAddOraAula = "INSERT INTO `redteam`.`oraaula` (`Nome`, `giorno`, `oraInizio`, `oraFine`, `defaultStatus`, `feedStatus`, `emailUtente`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		queryGetListaAule = "SELECT * FROM redteam.aula";
		queryRicercaAule = "SELECT distinct a.Nome,CoordinateX,CoordinateY "
				+ "FROM redteam.aula as a,redteam.oraaula as oa "
				+ "WHERE oa.giorno =?  and oa.oraInizio >= ? and oa.oraFine <= ? and oa.defaultStatus = true and a.nome = oa.nome";
		queryVisualizzaInfoAule = "SELECT Nome, Giorno ,OraInizio, OraFine, defaultStatus, feedStatus, emailUtente "
				+ "FROM redteam.oraaula " + "WHERE nome = ?  and giorno = ? and defaultStatus = true";
		queryInvioFeedback = "UPDATE redteam.oraaula " + "SET feedStatus = ?, emailUtente = ?"
				+ "where nome = ? and giorno = ?;";
	}

}
