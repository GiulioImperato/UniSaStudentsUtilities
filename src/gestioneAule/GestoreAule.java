package gestioneAule;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import storageLayer.DatabaseGA;

/**
 * 
 * @author Angelo Settembre
 *
 */
public class GestoreAule {
	
	/**
	 *  <b> Creazione del Gestore Aule senza parametri </b>
	 */
	public GestoreAule() {}
	
	/** Metodo che ritorna una ArrayList di aule
	 * @author Angelo Settembre
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Aula> getListaAule() throws SQLException{
		return DatabaseGA.getListaAule();
	}
	
	/**
	 * Metodo che ritorna una lista di aule disponibili per il giorno e l'orario cercato
	 * @param giorno
	 * @param oraInzio
	 * @param oraFine
	 * @return lista delle aule
	 * @throws SQLException 
	 */
	public ArrayList<Aula> ricercaAule(Giorno giorno, Time oraInizio, Time oraFine) throws SQLException{
		return DatabaseGA.ricercaAule(giorno, oraInizio, oraFine);
	}
	
	/**
	 * Metodo che ritorna un oggetto di tipo OraAula
	 * @param nome
	 * @param giorno
	 * @return
	 * @throws SQLException
	 */
	public OraAula visualizzaInfoAula(String nome, Giorno giorno) throws SQLException{
		return DatabaseGA.visualizzaInfoAula(nome, giorno);
	}
	
	/**
	 * Metodo che permette di cambiare lo stato di un'aula; dopo un'ora si ripristina lo stato dell'aula
	 * @param status
	 * @param emailUtente
	 * @param nome
	 * @param giorno
	 * @return
	 * @throws SQLException
	 */
	public boolean invioFeedback(boolean status, String emailUtente, String nome, Giorno giorno) throws SQLException{
		long start = System.currentTimeMillis();
		long end = start + 360*10000; // 360 seconds * 10000 ms/sec = 1ora
		while (System.currentTimeMillis() < end)											//Fin quando non è passata un'ora
		{
			DatabaseGA.invioFeedback(status, emailUtente, nome, giorno);
		}
		return DatabaseGA.resetFeedback(nome, giorno);
	}
}
