package onlyTest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import gestioneVendite.Annuncio;
import storageLayer.DatabaseGV;

public class TestUnitaMieiAnnunci {
	/*
	 * TestUnità  MieiAnnunci ()
	 * Classi: Annuncio, DettagliAnnuncio, DatabaseGV (metodo addAnnuncio)
	 * Input: Annuncio, DettagliAnnuncio
	 * Oracolo: 
	 */
	@Test
	public void testMieiAnnunci() {
		String email = "f.garofalo8@studenti.unisa.it";
		try {
			ArrayList<Annuncio> listByEmail = DatabaseGV.getListaAnnunciUtente(email);
			System.out.println(listByEmail.toString());
			String aspetto = "[Annuncio [idAnnuncio=0, titolo=Programmazione Distribuita, autore=null, corso=null, proprietario=null, condizioneLibro=null, prezzo=10.00]]";
			assertEquals(aspetto, listByEmail.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
