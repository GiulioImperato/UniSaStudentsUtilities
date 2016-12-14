package onlyTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import gestioneUtente.Utente;
import storageLayer.DatabaseGU;

public class TestUnitaUtente {

	
	
	@Test
	public void test1() {
		byte a = 1;
		byte b = 0;
		try {
			Boolean aspetto = DatabaseGU.addUser(new Utente("NOME","COGNOME", "EMAIL1", "PASSWORD", a, b ));
			assertEquals(true, aspetto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		assertEquals(true, false);
		
	}
	
}
