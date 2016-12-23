package onlyTest;



import gestioneMaterialeDidattico.Risorsa;
import gestioneUtente.Utente;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import gestioneVendite.CondizioneLibro;
import gestioneVendite.GestoreLibri;
import storageLayer.DatabaseGA;
import storageLayer.DatabaseGM;
import storageLayer.DatabaseGU;
import storageLayer.DatabaseGM;
import storageLayer.DatabaseGU;

public class TestDb {

	public static void main(String[] args) throws SQLException {
		
		
		/*ArrayList<Aula> array=DatabaseGA.getListaAule();
		for(int i=0;i<array.size();i++){
			System.out.println(array.get(i));
		}
		*/
		/*Time i=new Time(9, 00, 00);
		Time f=new Time(10, 00, 00);
		ArrayList<OraAula> array=new ArrayList<>();
		array=DatabaseGA.visualizzaInfoAula("F1", Giorno.lun);
		for(int z=0;z<array.size();z++){
			System.out.println(array.get(z));
		}
		*/
		// boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco",
		// "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		// Utente c=DatabaseGU.getUtenteByID("ang@hotmail.it");
		// System.out.println(c);
		// boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		// System.out.println(b);

		// GestoreLibri gst = new GestoreLibri();
		//Risorsa r = DatabaseGM.getRisorsaByID(0);
		//System.out.println(r);
		//Date data=new Date(2016, 12, 16);
	//	Risorsa risorsa=new Risorsa("materiale", "ang@hotmail.it", 10, data, 5, 0, "src/banana");
		/*Time i=new Time(15, 00, 00);
		Time f=new Time(16,00,00);
		OraAula o=new OraAula("F1",Giorno.gio, i, f, false, true, "ang@hotmail.it");
		DatabaseGA.InsertAula(o);
		*/
		
		//System.out.println(DatabaseGM.insertRisorsa(risorsa));
		// if(gst.inserisciAnnuncio("qwe", "Something", CondizioneLibro.nuovo,
		// "Prog Distribuita", 40, "Gigi", 2016, "Libro di prog distr", new
		// Date(), "JavaEE", "pas@hotmail.it"))
		// System.out.println("inserimento avvenuto");
		/*
		 * if(gst.inserisciAnnuncio("qwe", "qwe", CondizioneLibro.nuovo, "qwe",
		 * 40, "Gigi", 2016, "Libro di prog distr", new Date(2016, 12, 12),
		 * "JavaEE", "pas@hotmail.it"))
		 * System.out.println("inserimento avvenuto2");
		 */
		//boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco", "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		//Utente c=DatabaseGU.GetUtenteByID("ang@hootmail.it");
		//System.out.println(c);
		// TODO Auto-generated method stub

		// boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco",
		// "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		// Utente c=DatabaseGU.getUtenteByID("ang@hotmail.it");
		// System.out.println(c);
		// boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		// System.out.println(b);

		// GestoreLibri gst = new GestoreLibri();
		//Risorsa r = DatabaseGM.getRisorsaByID(0);
		//System.out.println(r);
		//Date data=new Date(2016, 12, 16);
		//Risorsa risorsa=new Risorsa("materiale", "ang@hotmail.it", 10, data, 5, 0, "src/banana");
		//System.out.println(DatabaseGM.insertRisorsa(risorsa));
		// if(gst.inserisciAnnuncio("qwe", "Something", CondizioneLibro.nuovo,
		// "Prog Distribuita", 40, "Gigi", 2016, "Libro di prog distr", new
		// Date(), "JavaEE", "pas@hotmail.it"))
		// System.out.println("inserimento avvenuto");
		/*
		 * if(gst.inserisciAnnuncio("qwe", "qwe", CondizioneLibro.nuovo, "qwe",
		 * 40, "Gigi", 2016, "Libro di prog distr", new Date(2016, 12, 12),
		 * "JavaEE", "pas@hotmail.it"))
		 * System.out.println("inserimento avvenuto2");
		 */
		//boolean b=DatabaseGU.addUser(new Utente("erfre", "Brgrgco", "giggdsfdsgdsgl.it", "cucccabacucco",true ,false));
		//Utente c=DatabaseGU.getUtenteByID("ang@hootmail.it");
		//System.out.println(c);
		//boolean b=DatabaseGU.deleteUser("giggimiticol@hotmail.it");
		//System.out.println(b);
				
		//GestoreLibri gst = new GestoreLibri();
			
	
		//if(gst.inserisciAnnuncio("qwe", "Something", CondizioneLibro.nuovo, "Prog Distribuita", 40, "Gigi", 2016, "Libro di prog distr", new Date(), "JavaEE", "pas@hotmail.it"))
		//	System.out.println("inserimento avvenuto");
		/*if(gst.inserisciAnnuncio("qwe", "qwe", CondizioneLibro.nuovo, "qwe", 40, "Gigi", 2016, "Libro di prog distr", new Date(2016, 12, 12), "JavaEE", "pas@hotmail.it"))
			System.out.println("inserimento avvenuto2");*/
	}

}
