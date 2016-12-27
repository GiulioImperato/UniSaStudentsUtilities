package onlyTest;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import gestioneMaterialeDidattico.Risorsa;
import gestioneUtente.Utente;
import storageLayer.DatabaseGM;
import storageLayer.DatabaseGU;

public class TestDBrisorsa {

	public static void main(String[] args) throws SQLException {	
		
		//DatabaseGU.AddUser(new Utente("NOME","COGNOME",  email, "PASSWORD", false, false));		
		//Utente u = DatabaseGU.getUtenteByID(email);
	/*
		Date d = new Date(0);
		String email =  "provaRisorsa";
		Risorsa r = new Risorsa("nomedddddeeee", email,33,d,0,0,"preeeeeeova/risorsa");		
		int id =DatabaseGM.insertRisorsa(r);
		System.out.println(" "+id);
	
	
	 */
		
		int ID = 38;
		
	/*
		System.out.println("CONTROLLO CHE SIA STATO INSERITO");
		Risorsa R= DatabaseGM.getRisorsaByID(id);
		System.out.println(R);
		
		
		System.out.println("Elimino");
		DatabaseGM.deleteRisorsa(id);
		
		
		System.out.println("CONTROLLO CHE SIA STATO eliminato");
		Risorsa Rr= DatabaseGM.getRisorsaByID(id);
		System.out.println(Rr); */
		
		
		
		/*
		 System.out.println("test lke dislike");
		System.out.println(DatabaseGM.getRisorsaByID(ID));
		
		DatabaseGM.aggiornaLike(ID, 30);
		DatabaseGM.aggiornaDislike(ID, 40);		
		System.out.println(DatabaseGM.getRisorsaByID(ID));
		
		DatabaseGM.aggiornaLike(ID, 0);
		DatabaseGM.aggiornaDislike(ID, 0);	
		System.out.println(DatabaseGM.getRisorsaByID(ID));
		*/
		
		
		/*
		
		System.out.println("risorse publicate da provarisorsa");
		String email =  "provaRisorsa";
		
		ArrayList<Risorsa> risorse = DatabaseGM.doRetrieveAllByUtente(email);
		
		for(Risorsa rr : risorse){
			System.out.println(rr.toString());
		}	*/	
		
	/*	
		System.out.println("risorse in una directori");
		String path =  "preeeeeeova/risorsa";
		
		ArrayList<Risorsa> risorse = DatabaseGM.doRetrieveAllByPath(path);
		
		for(Risorsa rr : risorse){
			System.out.println(rr.toString());
		}	
		*/

		/*
		ArrayList<Risorsa> risorse = DatabaseGM.doRetrieveAll();
		
		for(Risorsa rr : risorse){
			System.out.println(rr.toString());
		}*/

	}

}
