package storageLayer;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
/*
 * Classe per i test di unità DatabaseGU
 * @author Francesco Garofalo
 */
public class TestDatabaseGUPrinta {

	/*
	 * Test stampa tutti i test
	 */
	@Test
	public void testdoRetriveAll() {
		try{
			String aspetto = "[Utente [nome=Antonio, cognome=Esposito, email=a.esposito164@studenti.unisa.it, password=SLRTM8IV, status=true, privilegioAdmin=false], Utente [nome=Angelo, cognome=Settembre, email=a.settembre8@studenti.unisa.it, password=pass, status=true, privilegioAdmin=true], Utente [nome=Angelo, cognome=Settembre, email=ang@hotmail.it, password=9876543, status=true, privilegioAdmin=true], Utente [nome=Anna, cognome=Rossi, email=arossi@studenti.unisa.it, password=paperino00, status=true, privilegioAdmin=true], Utente [nome=Ciccio, cognome=Bello, email=ciccio@studenti.unisa.it, password=P@ssw0rd, status=true, privilegioAdmin=true], Utente [nome=Domenico, cognome=Tropeano, email=d.tropeano@studenti.unisa.it, password=P@ssw0rd, status=true, privilegioAdmin=false], Utente [nome=Francesco, cognome=Garofalo, email=francescogarofalo@studenti.unisa.it, password=stargate, status=true, privilegioAdmin=false], Utente [nome=gius, cognome=q, email=g.adinolfi28@studenti.unisa.it, password=AJHB7JL7, status=true, privilegioAdmin=false], Utente [nome=Giulio, cognome=Imperato, email=g.imperato2@studenti.unisa.it, password=pm, status=true, privilegioAdmin=true], Utente [nome=Pasquale, cognome=Settembre, email=p.settembre1@studenti.unisa.it, password=pippo, status=true, privilegioAdmin=true], Utente [nome=NOME, cognome=COGNOME, email=sdfdsfds, password=PASSWORD, status=false, privilegioAdmin=true], Utente [nome=tonicors, cognome=tonicors, email=tonicors@studenti.unisa.it, password=tonicors@studenti.unisa.it, status=true, privilegioAdmin=true]]";
			String test = DatabaseGU.doRetrieveAll().toString();
			System.out.println(test);
			assertEquals(aspetto, test);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
