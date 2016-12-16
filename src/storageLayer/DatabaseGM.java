package storageLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gestioneMaterialeDidattico.Risorsa;

public class DatabaseGM {

	public static Risorsa getRisorsaByID(int idRisorsa) {
		Connection connection = null;
		PreparedStatement psGetRisorsaByID = null;
		Risorsa risorsa = new Risorsa();
		try {
			connection = Database.getConnection();
			psGetRisorsaByID = connection.prepareStatement(queryGetRisorsa);
			psGetRisorsaByID.setInt(1, idRisorsa);
			ResultSet rs = psGetRisorsaByID.executeQuery();
			while (rs.next()) {

				risorsa.setNome(rs.getString("Nome"));
				risorsa.setDimensione(rs.getDouble("Dimensione"));
				risorsa.setDataUpload(rs.getDate("dataUpload"));
				risorsa.setProprietaio(rs.getString("Proprietario"));
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
			psGetRisorsaByID.setString(4, risorsa.getProprietaio());
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

	private static String queryGetRisorsa;
	private static String queryInsertRisorsa;
	static {
		queryGetRisorsa = "SELECT * FROM redteam.risorsa WHERE risorsa.idRisorsa=?";
		queryInsertRisorsa = "INSERT INTO `redteam`.`risorsa` (`Nome`, `Dimensione`, `dataUpload`, `Proprietario`, `Like`, `Dislike`, `PathCaricamento`) VALUES (?,?,?,?,?,?,?);";
	}
}
