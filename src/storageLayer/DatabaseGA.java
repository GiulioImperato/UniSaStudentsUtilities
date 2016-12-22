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
//public static Arra
	public static String queryAddOraAula;
	public static String queryGetListaAule;
	public static String queryRicercaAule;
	public static String queryVisualizzaInfoAule;
	static {
		queryAddOraAula = "INSERT INTO `redteam`.`oraaula` (`Nome`, `giorno`, `oraInizio`, `oraFine`, `defaultStatus`, `feedStatus`, `emailUtente`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		queryGetListaAule="SELECT * FROM redteam.aula";
		queryRicercaAule="SELECT distinct a.Nome,CoordinateX,CoordinateY "
				+ "FROM redteam.aula as a,redteam.oraaula as oa "
				+ "WHERE oa.giorno =?  and oa.oraInizio >= ? and oa.oraFine <= ? and oa.defaultStatus = true and a.nome = oa.nome";
		queryVisualizzaInfoAule="SELECT Nome, OraInizio, OraFine, defaultStatus, feedStatus, emailUtente"+
								"FROM redteam.oraaula "+
								"WHERE nome = ?  and giorno = ? and defaultStatus = ?";
	}

}
