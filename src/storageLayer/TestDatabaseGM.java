package storageLayer;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.Test;

import gestioneMaterialeDidattico.Risorsa;

public class TestDatabaseGM {

	@Test
	public void TestGetRisorsaByID() {
		assertNotNull(DatabaseGM.getRisorsaByID(7));
	}

	@Test
	public void TestInsertRisorsa(){
		Date d=new Date(System.currentTimeMillis());
		Risorsa r=new Risorsa("For", "ang@hotmail.it", 100, d, 0, 0, "uelaa");
		int i=DatabaseGM.insertRisorsa(r);
		assertNotEquals(0, i);
	}

	@Test
	public void TestDeleteRisorsa(){
		int id=8;
		try {
			assertEquals(DatabaseGM.deleteRisorsa(id),true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void TestDeleteRisorseOfUtente(){
		try {
			assertEquals(DatabaseGM.deleteRisorseOfUtente("f.garofalo8@studenti.unisa.it"),true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**Testa il metodo doRetrieveAll() 
	 * nel caso in cui c'è almeno una risorsa nel database 
	 * @throws SQLException 
	 * @author Antonio Corsuto
	 * */

	@Test	
	public void test1DoRetrieveAll() throws SQLException {
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAll();		
		System.out.println("  "+r.size());
		assertNotNull(r);
	}

	/**Testa il metodo doRetrieveAll() 
	 * nel caso non c'è nessuna risorsa nel database 
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test2DoRetrieveAll() throws SQLException {
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAll();		
		System.out.println("  "+r.size());
		assertNull(r);
	}


	/**Testa il metodo doRetrieveAllByUtente 
	 * nel caso in cui non esiste l'utente passato come parametro
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test1doRetrieveAllByUtente() throws SQLException {
		String u="aa";
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAllByUtente(u);		
		//System.out.println("  "+r.size());
		assertNull(r);
	}

	/**Testa il metodo doRetrieveAllByUtente 
	 * nel caso in cui esiste l'utente passato come parametro ed ha publicato almeno una risorsa
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test2doRetrieveAllByUtente() throws SQLException {
		String u="ciccio@studenti.unisa.it";
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAllByUtente(u);		
		System.out.println("  "+r.size());
		assertTrue(r.size()>0);
		assertNotNull(r);
	}

	/**Testa il metodo doRetrieveAllByUtente 
	 * nel caso in cui esiste l'utente passato come parametro e
	 * non ha publicato nessuna risorsa
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test3doRetrieveAllByUtente() throws SQLException {
		String u="tonicors@studenti.unisa.it";
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAllByUtente(u);		
		//System.out.println("  "+r.size());		
		assertNull(r);
	}


	/**Testa il metodo doRetrieveAllByPath 
	 * nel caso in cui non esiste nessuna risorsa salvata con il path passato come parametro
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test1doRetrieveAllByPath() throws SQLException {
		String p="aa";
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAllByPath(p);	
	//System.out.println("  "+r.size());
		assertNull(r);
	}

	/**Testa il metodo doRetrieveAllByPath 
	 * nel caso in cui esiste almeno una risorsa salvata con il path passsato come parametro
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test2doRetrieveAllByPath() throws SQLException {
		String p="res/uni/Informatica/Triennale/Programmazione_1/Slides/";
		ArrayList<Risorsa> r =DatabaseGM.doRetrieveAllByPath(p);		
		System.out.println("  "+r.size());
		assertTrue(r.size()>0);
		assertNotNull(r);
	}


	/**Testa il metodo aggiornaLike
	 * nel caso in cui la risorsa esiste e il numerlo dei like è positivo
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test1aggiornaLike() throws SQLException {
		int l=10;
		int id=7;
		int res;
		try {
			res = DatabaseGM.aggiornaLike(id,l);
			assertEquals(l, res);
		} catch (Exception e) {
			fail("non doveva capitare");
		}	

	}

	/**Testa il metodo aggiornaLike
	 * nel caso in cui la risorsa esiste e il numerlo dei like è negativo
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test2aggiornaLike() throws SQLException {
		int l=-1;
		int id=7;
		boolean flag = false ;
		try {
			int res =DatabaseGM.aggiornaLike(id,l);
		} catch (Exception e) {
			flag=true;

		}finally{
			assertEquals(true, flag);
		}

	}

	/**Testa il metodo aggiornaLike
	 * nel caso in cui la risorsa non esiste e il numerlo dei like è negativo
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test
	public void test3aggiornaLike() throws SQLException {
		int l=-1;
		int id=5555555;
		boolean flag = false ;
		try {
			int res = DatabaseGM.aggiornaLike(id,l);
		} catch (Exception e) {
			flag = true ;

		}finally{
			assertEquals(true, flag);
		}
	}

	/**Testa il metodo aggiornaLike
	 * nel caso in cui la risorsa non esiste e il numerlo dei like è positivo
	 * @author Antonio Corsuto
	 * @throws SQLException 
	 * @throws Exception */

	@Test
	public void test4aggiornaLike() throws SQLException, Exception{
		int l=5;
		int id=5555555;
		int res =DatabaseGM.aggiornaLike(id,l);	
		assertEquals(l-1, res);
	}


	/**Testa il metodo aggiornaDislike
	 * nel caso in cui la risorsa esiste e il numerlo dei like è positivo
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test1aggiornaDislike() throws SQLException {
		int l=10;
		int id=7;
		int res;
		try {
			res = DatabaseGM.aggiornaDislike(id,l);
			assertEquals(l, res);
		} catch (Exception e) {
			fail("non doveva capitare");
		}	

	}

	/**Testa il metodo aggiornaDislike
	 * nel caso in cui la risorsa esiste e il numerlo dei like è negativo
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test	
	public void test2aggiornaDislike() throws SQLException {
		int l=-1;
		int id=7;
		boolean flag = false ;
		try {
			int res =DatabaseGM.aggiornaDislike(id,l);
		} catch (Exception e) {
			flag=true;

		}finally{
			assertEquals(true, flag);
		}

	}

	/**Testa il metodo aggiornaDislike
	 * nel caso in cui la risorsa non esiste e il numerlo dei like è negativo
	 * @throws SQLException 
	 * @author Antonio Corsuto*/

	@Test
	public void test3aggiornaDislike() throws SQLException {
		int l=-1;
		int id=5555555;
		boolean flag = false ;
		try {
			int res = DatabaseGM.aggiornaDislike(id,l);
		} catch (Exception e) {
			flag = true ;

		}finally{
			assertEquals(true, flag);
		}
	}

	/**Testa il metodo aggiornaDislike
	 * nel caso in cui la risorsa non esiste e il numerlo dei like è positivo
	 * @author Antonio Corsuto
	 * @throws SQLException 
	 * @throws Exception */

	@Test
	public void test4aggiornaDislike() throws SQLException, Exception{
		int l=5;
		int id=5555555;
		int res =DatabaseGM.aggiornaDislike(id,l);	
		assertEquals(l-1, res);
	}



}
