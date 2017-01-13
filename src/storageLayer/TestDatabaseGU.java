package storageLayer;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import gestioneUtente.Utente;

public class TestDatabaseGU {

	/*
	 * Test inserisci utente
	 */
	@Test
	public void testAggiungiUtente() {
		Utente u = new Utente ( "TestNome", "TestCognome", "test@studenti.unisa.it", "test", false,
			false);
		try{
			Boolean done = DatabaseGU.addUser(u);
			assertEquals(true, done);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Test inserisci utente ripetuto fallito
	 */
	@Test
	public void testAggiungiUtenteFallito() {
		Utente u = new Utente ( "TestNome", "TestCognome", "test@studenti.unisa.it", "test", false,
			false);
		try{
			Boolean done = DatabaseGU.addUser(u);
			assertEquals(false, done);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Test elimina utente
	 */
	@Test
	public void testEliminaUtente(){
		String email = "test@studenti.unisa.it";
		try{
			Boolean done = DatabaseGU.deleteUser(email);
			assertEquals(true, done);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Test abilita privilegi admin utente
	 */
	@Test
	public void testdaiPrivilegiAdmin(){
		String email = "ciccio@studenti.unisa.it";
		Boolean status = true;
		try{
			assertEquals(true, DatabaseGU.changePrivilegiAdmin(email, status));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Test disabilita privilegi admin utente
	 */
	@Test
	public void testtogliPrivilegiAdmin() {
		String email = "ciccio@studenti.unisa.it";
		Boolean statu = false;
		try {
			assertEquals(true, DatabaseGU.changePrivilegiAdmin(email, statu));
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	/*
	 * Test abilita status account
	 */
	@Test
	public void testabilitaUtente(){
		String email = "ciccio@studenti.unisa.it";
		Boolean done = true;
		try {
			assertEquals(true, DatabaseGU.changeStatus(email, done));
			System.out.println("test abilita utente " + email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Test disabilita status account
	 */
	@Test
	public void testdiabilitaUtente() {
		String email = "ciccio@studenti.unisa.it";
		Boolean done = false;
		try {
			assertEquals(true, DatabaseGU.changeStatus(email, done));
			System.out.println("test disabilita utente  " + email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetUtenteById(){
		String email = "ciccio@studenti.unisa.it";
		try {
			String aspetto = "Utente [nome=Ciccio, cognome=Bello, email=ciccio@studenti.unisa.it, password=P@ssw0rd, status=true, privilegioAdmin=true]";
			String test = DatabaseGU.getUtenteByID(email).toString();
			assertEquals(aspetto, test);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * Test stampa tutti i test
	 */
	@Test
	public void testdoRetriveAll() {
		try{
			String aspetto = "[Utente [nome=antonio, cognome=esposito, email=a.esposito164@studenti.unisa.it, password=123456, status=true, privilegioAdmin=true], Utente [nome=Angelo, cognome=Settembre, email=a.settembre8@studenti.unisa.it, password=pass, status=true, privilegioAdmin=true], Utente [nome=Angelo, cognome=Settembre, email=ang@hotmail.it, password=9876543, status=true, privilegioAdmin=true], Utente [nome=Ciccio, cognome=Bello, email=ciccio@studenti.unisa.it, password=P@ssw0rd, status=true, privilegioAdmin=true], Utente [nome=Francesco, cognome=Garofalo, email=francescogarofalo@studenti.unisa.it, password=stargate, status=true, privilegioAdmin=false], Utente [nome=gius, cognome=q, email=g.adinolfi28@studenti.unisa.it, password=9030SM9W, status=true, privilegioAdmin=false], Utente [nome=Giulio, cognome=Imperato, email=g.imperato2@studenti.unisa.it, password=pm, status=true, privilegioAdmin=true], Utente [nome=Pasquale, cognome=Settembre, email=p.settembre1@studenti.unisa.it, password=pippo, status=true, privilegioAdmin=true], Utente [nome=NOME, cognome=COGNOME, email=sdfdsfds, password=PASSWORD, status=false, privilegioAdmin=true], Utente [nome=TestNome, cognome=TestCognome, email=test@studenti.unisa.it, password=test, status=false, privilegioAdmin=false], Utente [nome=tonicors, cognome=tonicors, email=tonicors@studenti.unisa.it, password=tonicors@studenti.unisa.it, status=true, privilegioAdmin=true]]";
			String test = DatabaseGU.doRetrieveAll().toString();
			System.out.println(test);
			assertEquals(aspetto, test);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
