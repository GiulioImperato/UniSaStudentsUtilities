package gestioneAule;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

import storageLayer.DatabaseGA;

public class TestDatabaseGA {
	@Test
	public void testGetListaAule() {
		ArrayList<Aula> array = null;
		try {
			array = DatabaseGA.getListaAule();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(array);
	}
	@Test
	public void testVisualizzaInfoAula() {
		ArrayList<OraAula> array = null;
		try { 
			array = DatabaseGA.visualizzaInfoAula("F1", Giorno.gio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(array);
	}
	@Test
	public void testStatusAulaFuoriOrario(){
		try {
			Time i = new Time(18, 0, 0);
			Time f = new Time(8, 0, 0);
			assertEquals(false, DatabaseGA.getStatusAula("F1", i, f, Giorno.lun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testStatusAulaLibera(){
		try {
			Time i = new Time(16, 0, 0);
			Time f = new Time(17, 0, 0);
			assertEquals(false, DatabaseGA.getStatusAula("F1", i, f, Giorno.lun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testStatusAulaOccupata(){
		try {
			Time i = new Time(17, 0, 0);
			Time f = new Time(18, 0, 0);
			assertEquals(true, DatabaseGA.getStatusAula("F1", i, f, Giorno.ven));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
