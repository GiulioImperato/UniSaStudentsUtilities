package gestioneVendite;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import gestioneUtente.Utente;
import storageLayer.Database;
import storageLayer.DatabaseGV;

public class GestoreLibri {

	private ArrayList<Annuncio> listaAnnunci;
	//fsdfdsfdsfds
	public GestoreLibri() {}
	
	public GestoreLibri(ArrayList<Annuncio> listaAnnunci) {
		this.listaAnnunci = listaAnnunci;
	}
	
	public boolean inserisciAnnuncio(String titolo, String autore, CondizioneLibro condizione, String corso, double prezzo, 
			String editore, int anno, String descrizione, Date data, String foto, String proprietario) throws SQLException {

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
