package gestioneVendite;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import gestioneVendite.Annuncio;

import storageLayer.DatabaseGV;

public class testUnitaRicercaAnnuncio {

	/*
	 * TestUnità ricerca annuncio titolo Classi: Annuncio, DettagliAnnuncio,
	 * DatabaseGV (metodo addAnnuncio) Input: String titolo. Oracolo: Ricerca
	 * dell'annuncio nel database avvenuta con successo
	 */

	@Test
	public void testRicercaSuccessoTitolo() {

		String titolo = "Programmazione 1";
		String autore = null;
		try {
			System.out.println("test Ricerca Titolo");

			ArrayList<Annuncio> list = DatabaseGV.getListaAnnunciRicerca(titolo, autore);
			System.out.println(list.toString());

			String aspetto = "[Annuncio [idAnnuncio=154, titolo=Programmazione 1, autore=Fischetti, corso=Programmazione 1, proprietario=p.settembre1@studenti.unisa.it, condizioneLibro=Fotocopie, prezzo=15.00]]";

			assertEquals(aspetto, list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * TestUnità ricerca annuncio Classi: Annuncio, DettagliAnnuncio, DatabaseGV
	 * (metodo addAnnuncio) Input: String autore. Oracolo: Ricerca dell'annuncio
	 * nel database avvenuta con successo
	 */
	@Test
	public void testRicercaSuccessoAutore() {

		String corso = null;
		try {
			System.out.println("test Ricerca per gigi");

			ArrayList<Annuncio> list = DatabaseGV.getListaAnnunciRicercaByCorso(corso);
			System.out.println(list.toString());

			String aspetto = "[Annuncio [idAnnuncio=154, titolo=Programmazione 1, autore=Fischetti, corso=Programmazione 1, proprietario=p.settembre1@studenti.unisa.it, condizioneLibro=Fotocopie, prezzo=15.00]]";

			assertEquals(aspetto, list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRicercaSuccessoCorso() {

		String corso = "Programmazione 1";
		try {
			System.out.println("test Ricerca");

			ArrayList<Annuncio> listCorsi = DatabaseGV.getListaAnnunciRicercaByCorso(corso);
			System.out.println(listCorsi.toString());

			String aspetto = "[Annuncio [idAnnuncio=154, titolo=Programmazione 1, autore=Fischetti, corso=Programmazione 1, proprietario=p.settembre1@studenti.unisa.it, condizioneLibro=Fotocopie, prezzo=15.00]]";

			assertEquals(aspetto, listCorsi.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
