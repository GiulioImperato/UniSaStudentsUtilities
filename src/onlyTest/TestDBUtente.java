package onlyTest;

import java.sql.SQLException;
import java.util.ArrayList;

import gestioneUtente.Utente;
import storageLayer.DatabaseGU;

public class TestDBUtente {

	public static void main(String[] args) throws SQLException {

		ArrayList<Utente> utenti = new ArrayList<Utente>();
		Boolean aspetto;
		Utente u ;

		System.out.println("INSERISCO UN UTENTE");

		
		aspetto = DatabaseGU.addUser(new Utente("NOME","COGNOME", "email", "PASSWORD", false, false));


		System.out.println("CONTROLLO CHE SIA STATO INSERITO");

		u = DatabaseGU.getUtenteByID("email");

		if(u!= null){
			System.out.println("L' utene essite \n "+ u.toString());
			//aspetto = DatabaseGU.DeleteUser("email");
			
			}


			else{
				System.out.println("non c'è nel db !!");
			}
		
		
		System.out.println("IMPOSTO ENTRAMBI I PRIVILIEGI A TRUE");
		
		DatabaseGU.changePrivilegiAdmin("email", true);
		DatabaseGU.changeStatus("email", true);

		u = DatabaseGU.getUtenteByID("email");

		if(u!= null){
			System.out.println("L' utene essite \n "+ u.toString());
			aspetto = DatabaseGU.deleteUser("email");
			
			}


			else{
				System.out.println("non c'è nel db !!");
			}
		


			/*
		System.out.println("CONTROLLO CHE SIA STATO INSERITO");

		utenti = DatabaseGU.doRetrieveAll();

		if(utenti != null){

			for(int i=0; i<utenti.size();i++){
				System.out.println(utenti.get(i).toString());
			}
		}

		else{
			System.out.println("non ci sono utenti dnel db !!");
		}




		System.out.println("ELIMINO L'UTENTE INSERITO UTENTE");

		aspetto = DatabaseGU.deleteUser("email");

		System.out.println("CONTROLLO CHE SIA STATO ELIMINATO");

		utenti = DatabaseGU.doRetrieveAll();

		if(utenti != null){

			for(int i=0; i<utenti.size();i++){
				System.out.println(utenti.get(i).toString());
			}
		}

		else{
			System.out.println("non ci sono utenti nel db (quindi è stato eliminato) !!");
		}
			 */

		}

	}
