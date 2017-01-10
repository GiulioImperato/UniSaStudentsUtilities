package storageLayer;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;
import gestioneAule.Aula;
import gestioneAule.Giorno;
import gestioneAule.OraAula;

public class TestDatabaseGA {
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

	public void testRicercaAule() {
		Time i = new Time(10, 0, 0);
		Time f = new Time(12, 0, 0);
		ArrayList<Aula> array = null;
		try {
			array = DatabaseGA.ricercaAule(Giorno.lun, i, f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(array);
	}

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

	public void testInvioFeedback() {
		try {
			assertEquals(true, DatabaseGA.invioFeedback(true, "ang@hotmail.it", "F4", Giorno.mar));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testResetFeedback() {
		try {
			assertEquals(true, DatabaseGA.resetFeedback("F4", Giorno.mar));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
