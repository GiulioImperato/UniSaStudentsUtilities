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
		//Utente u = DatabaseGU.GetUtenteByID(email);
	///*
		Date d = new Date(0);
		String email =  "provaRisorsa";
		String emadddil =  "provaRisorsa";
		Risorsa r = new Risorsa("nomedddddeeee", email,33,d,0,0,"preeeeeeova/risorsa");		
		int id =DatabaseGM.insertRisorsa(r);
	//	dddddddd
	// */

		
		DatabaseGM.insertRisorsa(r);
		System.out.println("CONTROLLO CHE SIA STATO INSERITO");
		Risorsa R= DatabaseGM.getRisorsaByID(0);
		
		
	
	
		System.out.println(R);

		/*
		ArrayList<Risorsa> risorse = DatabaseGM.DoRetrieveAll();
		
		for(Risorsa rr : risorse){
			System.out.println(rr.toString());
		}*/

	}

}
