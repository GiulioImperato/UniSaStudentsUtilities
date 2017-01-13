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
	 * Metodo che ritorna un boolean che indica lo stato dell'aula (false = "libera", true = "occupata")
	 * @param nomeAula nome dell'aula
	 * @param oraInizio ora di inizio in cui l'aula è libera/occupata
	 * @param oraFine ora di fine in cui l'aule è libera/occuppata
	 * @param giorno giorno in cui l'aula è libera/occupata
	 * @return stato dell'aula
	 * @author Settembre Angelo
	 * @throws SQLException 
	 */
	public static boolean getStatusAula(String nomeAula,Time oraInizio, Time oraFine, Giorno giorno) throws SQLException{
		Connection connection = null;
		PreparedStatement psStatusAula = null;
		boolean stato = false ;
		try {
			connection = Database.getConnection();
			psStatusAula = connection.prepareStatement(queryStatusMappa);
			psStatusAula.setString(1, nomeAula);
			psStatusAula.setString(2, giorno.name());
			psStatusAula.setTime(3, oraInizio);
			psStatusAula.setTime(4, oraFine);
			ResultSet rs = psStatusAula.executeQuery();
			connection.commit();
			while(rs.next()){
				stato = rs.getBoolean("defaultStatus");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (psStatusAula != null)
					psStatusAula.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				Database.releaseConnection(connection);
			}
		}
		return stato;
	}

	private static String queryGetListaAule;
	private static String queryStatusMappa;
	private static String queryVisualizzaInfoAule;

	static {
		queryGetListaAule = "SELECT * FROM redteam.aula";
		queryStatusMappa = "select oraaula.defaultStatus "
				+ "from redteam.oraaula "
				+ "where oraaula.nome=? and oraaula.giorno=? and oraaula.oraInizio>=? and oraaula.oraFine<=?";
		queryVisualizzaInfoAule = "SELECT Nome, Giorno ,OraInizio, OraFine, defaultStatus, feedStatus, emailUtente "
				+ "FROM redteam.oraaula " + "WHERE nome = ?  and giorno = ? and defaultStatus = false";
	}

}
