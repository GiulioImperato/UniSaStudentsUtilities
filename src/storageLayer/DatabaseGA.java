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

public static ArrayList<Aula> getListaAule(){
	Connection connection = null;
	PreparedStatement psInsertOraAula = null;
	ArrayList<Aula> listaAule=new ArrayList<Aula>();
	try {
		PreparedStatement psGetListaAule=connection.prepareStatement(queryGetListaAule);
		ResultSet rs=psGetListaAule.executeQuery();
		while (rs.next()) {
			Aula a=new Aula(rs.getString("Nome"),rs.getDouble("CoordinateX"),rs.getDouble("CoordinateY"));
			listaAule.add(a);
		}
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
	
	return listaAule;
}
public ArrayList<Aula> RicercaAule(Giorno giorno,Time oraInizio,Time oraFine){
	
	Connection connection = null;
	PreparedStatement psInsertOraAula = null;
	ArrayList<Aula> listaAuleLibere=new ArrayList<Aula>();
	try {
		PreparedStatement psGetListaAule=connection.prepareStatement(queryGetListaAule);
		psGetListaAule.setString(1, giorno.toString());
		psGetListaAule.setTime(2, oraInizio);
		psGetListaAule.setTime(3, oraFine);
		ResultSet rs=psGetListaAule.executeQuery();
		while (rs.next()) {
			Aula a=new Aula(rs.getString("Nome"),rs.getDouble("CoordinateX"),rs.getDouble("CoordinateY"));
			listaAuleLibere.add(a);
		}
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
	
	return listaAuleLibere;
	
}
public static ArrayList<OraAula> visualizzaInfoAula(String nome,Giorno giorno){
	Connection connection = null;
	PreparedStatement psInsertOraAula = null;
	ArrayList<OraAula> listaOreLibere=new ArrayList<OraAula>();
	try {
		PreparedStatement psGetListaAule=connection.prepareStatement(queryGetListaAule);
		psGetListaAule.setString(1, nome);
		psGetListaAule.setString(2, giorno.toString());
		ResultSet rs=psGetListaAule.executeQuery();
		while (rs.next()) {
			Giorno g=Giorno.valueOf(rs.getString("giorno"));
			OraAula a=new OraAula(rs.getString("Nome"),g,rs.getTime("oraInizio"),rs.getTime("oraFine"),rs.getBoolean("defaultStatus"),rs.getBoolean("feedStatus"),rs.getString("emailUtente"));
			listaOreLibere.add(a);
		}
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
	
	return listaOreLibere;
	
}
public static boolean invioFeedback(String Nome,boolean status,String emailUtente){
	Connection connection = null;
	PreparedStatement psInvioFeedback = null;
	
	try {
		connection=Database.getConnection();
		psInvioFeedback=connection.prepareStatement(queryInvioFeedback);
		
		psInvioFeedback.setString(1, Nome);
		psInvioFeedback.setBoolean(2, status);
		psInvioFeedback.setString(3, emailUtente);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

	public static String queryAddOraAula;
	public static String queryGetListaAule;
	public static String queryRicercaAule;
	public static String queryVisualizzaInfoAule;
	public static String queryInvioFeedback;
	static {
		queryAddOraAula = "INSERT INTO `redteam`.`oraaula` (`Nome`, `giorno`, `oraInizio`, `oraFine`, `defaultStatus`, `feedStatus`, `emailUtente`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		queryGetListaAule="SELECT * FROM redteam.aula";
		queryRicercaAule="SELECT distinct a.Nome,CoordinateX,CoordinateY "
				+ "FROM redteam.aula as a,redteam.oraaula as oa "
				+ "WHERE oa.giorno =?  and oa.oraInizio >= ? and oa.oraFine <= ? and oa.defaultStatus = true and a.nome = oa.nome";
		queryVisualizzaInfoAule="SELECT Nome, OraInizio, OraFine, defaultStatus, feedStatus, emailUtente"+
								"FROM redteam.oraaula "+
								"WHERE nome = ?  and giorno = ? and defaultStatus = true";
		queryInvioFeedback="UPDATE redteam.oraaula "
				+ "SET feedStatus = ?, emailUtente = ?"
				+ "where nome = ? and giorno = ?;";
	}

}
