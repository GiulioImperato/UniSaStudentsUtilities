package gestioneVendite;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import gestioneUtente.Utente;
import storageLayer.DatabaseGV;

public class GestoreLibri {

	private ArrayList<Annuncio> listaAnnunci;
	
	/**
	 * <b>Creazione del GestoreLibri senza parametri</b>
	 */
	public GestoreLibri() {}
	
	/**
	 * @author Pasquale Settembre
	 * <b>Permette l'inserimento di un annuncio chiamando l'interfaccia del database DatabaseGV</b>
	 * @param titolo
	 * @param autore
	 * @param condizione
	 * @param corso
	 * @param prezzo
	 * @param editore
	 * @param anno
	 * @param descrizione
	 * @param data
	 * @param foto
	 * @param proprietario
	 * @return
	 * @throws SQLException
	 */
	public boolean inserisciAnnuncio(String titolo, String autore, CondizioneLibro condizione, String corso, double prezzo, 
			String editore, int anno, String descrizione, Date data, String foto, String proprietario) throws SQLException {
		
		
		/* VERRA' UTILIZZATA ALL'INTERNO DELLA JSP
		Data data = new Data();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf.format(data));
		*/
		
		DettagliAnnuncio dt = new DettagliAnnuncio(editore, anno, descrizione, data, foto);

		Annuncio ann = new Annuncio(titolo, autore, corso, proprietario, condizione, prezzo, dt);
		
		//listaAnnunci.add(ann); 

		
		if(DatabaseGV.addAnnuncio(ann,dt))
			return true;
		else
			return false;

	}
	
	public void rimuoviAnnunci(int idAnnuncio){
	
	}
	
	public Annuncio getAnnuncio() {
		return null;
		
	}
	
	public ArrayList <Annuncio> getListaAnnunci(String parolaChiave) {
		return null;
	}
	
	public void contattaVenditore(Utente u) {
		
	}
	
	public ArrayList <Annuncio> getAnnunciUtente(String username) {
		return null;
	}
	
	public boolean controllaDati(String titolo, String autore, String condizione, String corso, double prezzo){
		return false;
	}
	
	/*
	 *  public Notifica notificaInserimento() {
	 *  
	 *  }
	 */
	
	/*
	 * public Notifica notificaVendita() {
	 * 
	 * }
	 */
}
