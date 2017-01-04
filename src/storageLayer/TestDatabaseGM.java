package storageLayer;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.junit.Test;

import gestioneMaterialeDidattico.Risorsa;

public class TestDatabaseGM {
	@Test
	public void TestGetRisorsaByID() {
		assertNotNull(DatabaseGM.getRisorsaByID(7));
	}
	public void TestInsertRisorsa(){
		Date d=new Date(System.currentTimeMillis());
		Risorsa r=new Risorsa("For", "ang@hotmail.it", 100, d, 0, 0, "uelaa");
		int i=DatabaseGM.insertRisorsa(r);
		assertNotEquals(0, i);
	}
	public void TestDeleteRisorsa(){
		int id=8;
		try {
			assertEquals(DatabaseGM.deleteRisorsa(id),true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void TestDeleteRisorseOfUtente(){
		
	}
}
