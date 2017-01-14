package gestioneAule;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

import storageLayer.DatabaseGA;

/**
 * Test sull'unità database per la gestione aule
 */
public class TestDatabaseGA {
	/**
	 * Test sul metodo che ritorna la lista delle aule con i nomi e le
	 * coordinate(x/y)
	 * 
	 * @author Angelo Settembre
	 */
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

	/**
	 * Test sul metodo che ritorna la lista delle informazioni rispetto un'aula
	 * 
	 * @author Angelo Settembre
	 */
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

	/**
	 * Test sul metodo getStatusAula dove in questo caso si testa un orario
	 * fuori dal range. Il risultato aspettato è che sulla mappa risulteranno
	 * tutte le aule, libere (false).
	 * 
	 * @author Angelo Settembre
	 */
	@Test
	public void testStatusAulaFuoriOrario() {
		try {
			@SuppressWarnings("deprecation")
			Time i = new Time(18, 0, 0);
			@SuppressWarnings("deprecation")
			Time f = new Time(8, 0, 0);
			assertEquals(false, DatabaseGA.getStatusAula("F1", i, f, Giorno.lun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test sul metodo getStatusAula dove in questo caso si testa un orario in
	 * cui è libera. Il risultato aspettato è che il lunedi, l'aula testata sarà
	 * libera.
	 * 
	 * @author Angelo Settembre
	 */
	@Test
	public void testStatusAulaLibera() {
		try {
			@SuppressWarnings("deprecation")
			Time i = new Time(16, 0, 0);
			@SuppressWarnings("deprecation")
			Time f = new Time(17, 0, 0);
			assertEquals(false, DatabaseGA.getStatusAula("F1", i, f, Giorno.lun));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test sul metodo getStatusAula dove in questo caso si testa un orario in
	 * cui è occupata. Il risultato aspettato è che il venerdi, l'aula testata
	 * sarà occupata.
	 * 
	 * @author Angelo Settembre
	 */
	@Test
	public void testStatusAulaOccupata() {
		try {
			@SuppressWarnings("deprecation")
			Time i = new Time(17, 0, 0);
			@SuppressWarnings("deprecation")
			Time f = new Time(18, 0, 0);
			assertEquals(true, DatabaseGA.getStatusAula("F1", i, f, Giorno.ven));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
