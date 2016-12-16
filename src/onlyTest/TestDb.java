package onlyTest;

import java.util.Date;

import gestioneUtente.Utente;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import gestioneVendite.CondizioneLibro;
import gestioneVendite.GestoreLibri;
import storageLayer.DatabaseGU;

public class TestDb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		//boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco", "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		Utente c=DatabaseGU.getUtenteByID("ang@hotmail.it");
		System.out.println(c);
		//boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		//System.out.println(b);
				
		GestoreLibri gst = new GestoreLibri();
			
	
		//if(gst.inserisciAnnuncio("qwe", "Something", CondizioneLibro.nuovo, "Prog Distribuita", 40, "Gigi", 2016, "Libro di prog distr", new Date(), "JavaEE", "pas@hotmail.it"))
		//	System.out.println("inserimento avvenuto");
		/*if(gst.inserisciAnnuncio("qwe", "qwe", CondizioneLibro.nuovo, "qwe", 40, "Gigi", 2016, "Libro di prog distr", new Date(2016, 12, 12), "JavaEE", "pas@hotmail.it"))
			System.out.println("inserimento avvenuto2");*/
	}

}
