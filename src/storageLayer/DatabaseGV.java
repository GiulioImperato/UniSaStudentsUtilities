package storageLayer;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import gestioneVendite.Annuncio;
import gestioneVendite.CondizioneLibro;
import gestioneVendite.DettagliAnnuncio;

public class DatabaseGV {
	
	private static String queryAddAnnuncio;
	private static String queryDettagliAnnuncio;
	private static String queryListAnnunciUtente;
	
	/**
	 * @author Pasquale Settembre
	 * <b>Permette l'inserimento di un annuncio nel database</b>
	 * @param annuncio  annuncio che si vuole inserire
	 * @param dett      dettagliAnnunci 
	 * @return true		restituisce che l'annuncio è stato inserito correttamente
	 * @throws SQLException
	 */
	public static boolean addAnnuncio(Annuncio annuncio, DettagliAnnuncio dett) throws SQLException {
		Connection connection = null;
		PreparedStatement psAddAnnuncio= null;
		PreparedStatement psAddDettagliAnnuncio = null;
		int lastID=0;
		try {
			connection = Database.getConnection();
			psAddAnnuncio = connection.prepareStatement(queryAddAnnuncio, Statement.RETURN_GENERATED_KEYS);
			
			psAddAnnuncio.setString(1, annuncio.getTitolo());
			psAddAnnuncio.setString(2, annuncio.getAutore());
			psAddAnnuncio.setString(3, annuncio.getCorso());
			psAddAnnuncio.setString(4, annuncio.getProprietario());
			psAddAnnuncio.setString(5, annuncio.getCondizioneLibro().name());
			psAddAnnuncio.setDouble(6, annuncio.getPrezzo());
			System.out.println(psAddAnnuncio.toString());
			psAddAnnuncio.executeUpdate();
			
			ResultSet rs =psAddAnnuncio.getGeneratedKeys();
			if(rs.next()){
				lastID = rs.getInt(1);
				System.out.println("ID "+rs.getInt(1));
			}
			
			connection.commit();
			
			java.sql.Date sqlDate = new java.sql.Date(dett.getData().getTime());
			
			psAddDettagliAnnuncio = connection.prepareStatement(queryDettagliAnnuncio); 
			psAddDettagliAnnuncio.setInt(1, lastID);
			psAddDettagliAnnuncio.setString(2, dett.getEditore());
			psAddDettagliAnnuncio.setInt(3, dett.getAnno());
			psAddDettagliAnnuncio.setString(4, dett.getDescrizione());
			psAddDettagliAnnuncio.setDate(5, sqlDate);
			psAddDettagliAnnuncio.setString(6, dett.getFoto());
			System.out.println(psAddDettagliAnnuncio.toString());
			
			psAddDettagliAnnuncio.executeUpdate();
			
			connection.commit();
			
		} finally {
			try {
				if(psAddAnnuncio != null)
					psAddAnnuncio.close();
				if(psAddDettagliAnnuncio !=null)
					psAddDettagliAnnuncio.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			 finally {
				Database.releaseConnection(connection);
			}
		}
		return true;
	}
	
	/**
	 * @author Pasquale Settembre
	 * <b>Permette di prendere dal database la lista degli annunci di un determinato utente</b>
	 * @param email dell'utente 
	 * @return    restituisce la lista degli annunci 
	 * @throws SQLException
	 */
	public static ArrayList<String>getListaAnnunciUtente(String email) throws SQLException{
		Connection connection = null;
		PreparedStatement psListAnnunciUtente= null;
		ArrayList<String> listAnnunci = new ArrayList();
		try{
			connection = Database.getConnection();
			psListAnnunciUtente = connection.prepareStatement(queryListAnnunciUtente);
			
			psListAnnunciUtente.setString(1, email);
			ResultSet rs = psListAnnunciUtente.executeQuery();
			
			while(rs.next()){
				String title = rs.getString("Titolo");
				String autore = rs.getString("Autore");
				String corso = rs.getString("Corso");
				String proprietario = rs.getString("Proprietario");
				String condizione = rs.getString("condizioneLibro");
				double prezzo = rs.getDouble("prezzo");
				listAnnunci.add(title+autore+corso+proprietario+condizione+prezzo);	
			}
		}
		finally {
			try {
				if(psListAnnunciUtente != null)
					psListAnnunciUtente.close();
				if(psListAnnunciUtente !=null)
					psListAnnunciUtente.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			 finally {
				Database.releaseConnection(connection);
			}
		}
		return listAnnunci;
	}
	
	static {
		queryAddAnnuncio = "INSERT INTO redteam.annuncio (Titolo, Autore, Corso, Proprietario, CondizioneLibro,Prezzo) VALUES (?,?,?,?,?,?)";
		queryDettagliAnnuncio = "INSERT INTO redteam.dettagliannuncio (id, Editore, Anno, Descrizione, Data, Foto) VALUES (?,?,?,?,?,?)";
		queryListAnnunciUtente = "SELECT * FROM Annuncio WHERE Proprietario = ?";
	}
}
