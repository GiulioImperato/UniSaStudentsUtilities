/**
 * 
 */
package onlyTest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import gestioneVendite.Annuncio;
import gestioneVendite.CondizioneLibro;
import gestioneVendite.DettagliAnnuncio;
import storageLayer.DatabaseGV;

/**
 * @author Francesco Garofalo
 *
 */
public class TestUnitaInserisciAnnuncio {
	
	/*
	 * TestUnità inserimento annuncio
	 * Classi: Annuncio, DettagliAnnuncio, DatabaseGV (metodo addAnnuncio)
	 * Input: Annuncio, DettagliAnnuncio.
	 * Oracolo: Inserimento nel database avvenuto con successo
	 */
	@Test
	public void testInserimentoSuccesso(){
		Date data=new Date(2016, 12, 16);
		
		DettagliAnnuncio dt = new DettagliAnnuncio("editore", 1950, "descrizione", data, "path");
		Annuncio annuncio = new Annuncio("titoloLibro", "autore", "corso", null, CondizioneLibro.Nuovo, new BigDecimal(20.00), dt);
		System.out.println(annuncio.toString());
		
		try {
			Boolean aspetto = DatabaseGV.addAnnuncio(annuncio, dt);
			assertEquals(true, aspetto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * TestUnità inserimento annuncio (Campo non compilato)
	 * Classi: Annuncio, DettagliAnnuncio, DatabaseGV (metodo addAnnuncio)
	 * Input: Annuncio, DettagliAnnuncio.
	 * Oracolo: Errore inserimento annuncio, campo non compilato.
	 */
	@Test
	public void testInserimentoFallito(){
		Date data=new Date(2016, 12, 16);
		
		DettagliAnnuncio dt = new DettagliAnnuncio("editore", 1950, "descrizione", data, "path");
		Annuncio annuncio = new Annuncio(null, "autore", "corso", null, CondizioneLibro.Nuovo, new BigDecimal(20.00), dt);
		System.out.println(annuncio.toString());
		
		try {
			Boolean aspetto = DatabaseGV.addAnnuncio(annuncio, dt);
			assertEquals(false, aspetto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
