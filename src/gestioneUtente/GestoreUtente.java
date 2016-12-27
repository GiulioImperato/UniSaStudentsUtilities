package gestioneUtente;

import java.sql.SQLException;
import java.util.ArrayList;

import storageLayer.DatabaseGU;

public class GestoreUtente {
	
	
	public GestoreUtente() {}
	
	public boolean registraUtente(String n, String c, String e, String p, Boolean s, Boolean pa) throws SQLException{
		Utente u = new Utente(n,c,e,p,s,pa);
		return DatabaseGU.addUser(u);
	}
	
	
	public boolean deregistraUtente(String e) throws SQLException{
		return DatabaseGU.deleteUser(e);
	}
	
	public boolean cambiaStatus(String email, boolean newStatus) throws SQLException {
		return DatabaseGU.changeStatus(email, newStatus);
	}
	
	public boolean cambiaPrivilegiAdmin(String email, boolean newPrivilegi) throws SQLException {
		return DatabaseGU.changePrivilegiAdmin(email, newPrivilegi);
	}
	
	public Utente getUtenteByID(String email) throws SQLException {
		return DatabaseGU.getUtenteByID(email);
	}
	
	public ArrayList<Utente> getUtentiRegistrati() throws SQLException {
		return DatabaseGU.doRetrieveAll();
	}
	
	

}
