package onlyTest;

import java.sql.Date;
import java.sql.SQLException;

import gestioneMaterialeDidattico.Risorsa;
import gestioneUtente.Utente;
import storageLayer.DatabaseGM;
import storageLayer.DatabaseGU;

public class TestDBrisorsa {

	public static void main(String[] args) throws SQLException {
		
		Date d = new Date(0);
		String email =  "provaRisorsa";
		
		//DatabaseGU.AddUser(new Utente("NOME","COGNOME",  email, "PASSWORD", false, false));		
		//Utente u = DatabaseGU.GetUtenteByID(email);
		
		System.out.println(""+d);
		
		Risorsa r = new Risorsa("nome", email,33,d,0,0,"prova/risorsa");
		
		//DatabaseGM.insertRisorsa(r);
		
		Risorsa R= DatabaseGM.getRisorsaByID(0);
		
		System.out.println(r.toString());
		System.out.println(R.toString());
	//	System.out.println(" "+ u);
		

	}

}
