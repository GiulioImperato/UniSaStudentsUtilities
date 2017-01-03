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
	private static String queryDettagliAnnunci;
	private static String queryRicercaTitolo;
	private static String queryRicercaTitoloAutore;
	private static String queryRicercaByCorso;
	static ArrayList<DettagliAnnuncio>listDettagli;
	static ArrayList<Annuncio>listAnnunci;
	static ArrayList<Annuncio>listAnnunciSearch;
	static ArrayList<Annuncio>listAnnunciTitleAutore;
	static ArrayList<Annuncio>listAnnunciCorso;

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
			psAddAnnuncio.setBigDecimal(6, annuncio.getPrezzo());
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
	public static ArrayList<Annuncio>getListaAnnunciUtente(String email) throws SQLException{
		Connection connection = null;
		PreparedStatement psListAnnunciUtente= null;
		listAnnunci = new ArrayList<>();
		listDettagli = new ArrayList<>();
		try{
			connection = Database.getConnection();
			psListAnnunciUtente = connection.prepareStatement(queryListAnnunciUtente);
			
			psListAnnunciUtente.setString(1, email);
			ResultSet rs = psListAnnunciUtente.executeQuery();
			
			while(rs.next()){
				Annuncio ann = new Annuncio();
				ann.setTitolo(rs.getString("Titolo"));
				ann.setPrezzo(rs.getBigDecimal("prezzo"));
				listAnnunci.add(ann);
				selectDettagliAnnuncio(rs.getInt("idAnnuncio"));    //chiamata al metodo, per effettuare la query su quel determinato annuncio
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
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return listAnnunci;
	}
	
	/**
	 * @author Pasquale Settembre
	 * <b>Effettua la query al db dei dettagli di un determinato annuncio</b>
	 * @param id dell'annuncio
	 * @throws SQLException
	 */
	public static void selectDettagliAnnuncio(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement psListAnnunciUtente= null;
		
		try{
			connection = Database.getConnection();
			psListAnnunciUtente = connection.prepareStatement(queryDettagliAnnunci);
			
			psListAnnunciUtente.setInt(1, id);
			ResultSet rs = psListAnnunciUtente.executeQuery();
			
			while(rs.next()){
				DettagliAnnuncio dett = new DettagliAnnuncio();
				dett.setData(rs.getDate("Data"));
				dett.setFoto(rs.getString("Foto"));
				listDettagli.add(dett);	
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
	}
	
	/**
	 * @author Pasquale Settembre
	 * <b>Restituisce la lista dei dettagli di un annuncio</b>
	 * @return arraylist di tipo DettagliAnnuncio
	 */
	public static ArrayList<DettagliAnnuncio>getListaDettagli(){
		return listDettagli;
	}
	
	/**
	 * @author Francesco Garofalo
	 * <b>Permette di cercare nel database la lista degli annunci tramite il titolo o autore desiderato</b>
	 * @param titolo dell'annuncio 
	 * @return restituisce la lista degli annunci correlati al titolo o l'autore inserito
	 * @throws SQLException
	 */
	public static ArrayList<Annuncio>getListaAnnunciRicerca(String titolo,String autore) throws SQLException{
		Connection connection = null;
		PreparedStatement psListAnnunciTitolo = null;
		listAnnunciSearch = new ArrayList();
		try{
			connection = Database.getConnection();
			psListAnnunciTitolo = connection.prepareStatement(queryRicercaTitolo);
			
			psListAnnunciTitolo.setString(1, titolo);
			psListAnnunciTitolo.setString(2, autore);
			ResultSet rs = psListAnnunciTitolo.executeQuery();
			
			while(rs.next()){
				Annuncio ann = new Annuncio();
				ann.setIdAnnuncio(Integer.parseInt(rs.getString("idAnnuncio")));
				ann.setTitolo(rs.getString("Titolo"));
				ann.setAutore(rs.getString("Autore"));
				ann.setCorso(rs.getString("Corso"));
				ann.setProprietario(rs.getString("Proprietario"));
				String cond = rs.getString("CondizioneLibro");
				String upperLetter=cond.substring(0, 1).toUpperCase();
				cond = upperLetter+cond.substring(1);
				ann.setCondizioneLibro(CondizioneLibro.valueOf(cond));
				ann.setPrezzo(rs.getBigDecimal("prezzo"));
				
				listAnnunciSearch.add(ann);
			}
			
		}
		finally {
			try {
				if(psListAnnunciTitolo != null)
					psListAnnunciTitolo.close();
				if(psListAnnunciTitolo !=null)
					psListAnnunciTitolo.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			 finally {
				Database.releaseConnection(connection);
			}
		}
		return listAnnunciSearch;
	}
	
	/**
	 * @author Francesco Garofalo
	 * <b>Permette di cercare nel database la lista degli annunci con il titolo e autore desiderato</b>
	 * @param autore del libro 
	 * @return restituisce la lista degli annunci correlati al titolo e autore inserito
	 * @throws SQLException
	 */
	public static ArrayList<Annuncio>getListaAnnunciRicercaTitleAuthor(String titolo,String autore) throws SQLException{
		Connection connection = null;
		PreparedStatement psListAnnunciAutore = null;
		listAnnunciTitleAutore = new ArrayList();
		try{
			connection = Database.getConnection();
			psListAnnunciAutore = connection.prepareStatement(queryRicercaTitoloAutore);
			
			psListAnnunciAutore.setString(1, titolo);
			psListAnnunciAutore.setString(2, autore);
			ResultSet rs = psListAnnunciAutore.executeQuery();
			
			while(rs.next()){
				Annuncio ann = new Annuncio();
				ann.setIdAnnuncio(Integer.parseInt(rs.getString("idAnnuncio")));
				ann.setTitolo(rs.getString("Titolo"));
				ann.setAutore(rs.getString("Autore"));
				ann.setCorso(rs.getString("Corso"));
				ann.setProprietario(rs.getString("Proprietario"));
				String cond = rs.getString("CondizioneLibro");
				String upperLetter=cond.substring(0, 1).toUpperCase();
				cond = upperLetter+cond.substring(1);
				ann.setCondizioneLibro(CondizioneLibro.valueOf(cond));
				ann.setPrezzo(rs.getBigDecimal("prezzo"));

				listAnnunciTitleAutore.add(ann);
			}
		}
		finally {
			try {
				if(psListAnnunciAutore != null)
					psListAnnunciAutore.close();
				if(psListAnnunciAutore !=null)
					psListAnnunciAutore.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			 finally {
				Database.releaseConnection(connection);
			}
		}
		return listAnnunciTitleAutore;
	}
	
	/**
	 * @author Pasquale Settembre
	 * <b>Effettua la ricerca di annunci in base al corso</b>
	 * @param corso scelto per la ricerca
	 * @return lista di annunci
	 * @throws SQLException
	 */
	public static ArrayList<Annuncio>getListaAnnunciRicercaByCorso(String corso) throws SQLException{
		Connection connection = null;
		PreparedStatement psListAnnunciCorso = null;
		listAnnunciCorso = new ArrayList();
		try{
			connection = Database.getConnection();
			psListAnnunciCorso = connection.prepareStatement(queryRicercaByCorso);
			
			psListAnnunciCorso.setString(1, corso);
			ResultSet rs = psListAnnunciCorso.executeQuery();
			
			while(rs.next()){
				Annuncio ann = new Annuncio();
				ann.setIdAnnuncio(Integer.parseInt(rs.getString("idAnnuncio")));
				ann.setTitolo(rs.getString("Titolo"));
				ann.setAutore(rs.getString("Autore"));
				ann.setCorso(rs.getString("Corso"));
				ann.setProprietario(rs.getString("Proprietario"));
				String cond = rs.getString("CondizioneLibro");
				String upperLetter=cond.substring(0, 1).toUpperCase();
				cond = upperLetter+cond.substring(1);
				ann.setCondizioneLibro(CondizioneLibro.valueOf(cond));
				ann.setPrezzo(rs.getBigDecimal("prezzo"));

				listAnnunciCorso.add(ann);
			}
		}
		finally {
			try {
				if(psListAnnunciCorso != null)
					psListAnnunciCorso.close();
				if(psListAnnunciCorso !=null)
					psListAnnunciCorso.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			 finally {
				Database.releaseConnection(connection);
			}
		}
		return listAnnunciCorso;
	}
	
	static {
		queryAddAnnuncio = "INSERT INTO redteam.annuncio (Titolo, Autore, Corso, Proprietario, CondizioneLibro,Prezzo) VALUES (?,?,?,?,?,?)";
		queryDettagliAnnuncio = "INSERT INTO redteam.dettagliannuncio (id, Editore, Anno, Descrizione, Data, Foto) VALUES (?,?,?,?,?,?)";
		queryDettagliAnnunci = "SELECT data,foto FROM dettagliannuncio WHERE id=?";
		queryListAnnunciUtente = "SELECT a.idAnnuncio,a.titolo,a.prezzo,det.data,det.foto from Annuncio as a, Dettagliannuncio as det where a.proprietario=? and a.idAnnuncio=det.id;";
		queryRicercaTitolo = "SELECT * FROM Annuncio WHERE titolo = ? or autore = ?";
		queryRicercaTitoloAutore = "SELECT * FROM Annuncio WHERE titolo = ? and autore = ?";
		queryRicercaByCorso = "SELECT * FROM Annuncio WHERE corso = ?";

	}
}
