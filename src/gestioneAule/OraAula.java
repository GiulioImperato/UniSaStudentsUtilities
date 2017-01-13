package gestioneAule;

import java.sql.Time;
/**
 * Oggetto OraAula contiene tutte le informazioni di un'aula 
 * @param nome indica il nome dell'aula
 * @param giorno indica il giorno in cui l'aula è libera
 * @param oraInizio indica l'orario di inizio in cui l'aula è libera
 * @param oraFine indica l'orario di fine in cui l'aula risulta libera
 * @param defaultStatus indica lo stato di default dell'aula
 * @param feedStatus indica lo stato che l'utente sceglie per liberare/occupare un'aula
 * @param emailUtente indica l'email dell'utente che ha inserito il feedback
 * @author Angelo Settembre
 *
 */
public class OraAula {
	private String nome;
	private Giorno giorno;
	private Time oraInizio;
	private Time oraFine;
	private boolean defaultStatus;
	private boolean feedStatus;
	private String emailUtente;				
	
	public OraAula(){
	}
	
	public OraAula(String nome, Giorno giorno, Time oraInizio, Time oraFine, boolean defaultStatus, boolean feedStatus, String emailUtente) {
		this.nome = nome;
		this.giorno = giorno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.defaultStatus = defaultStatus;
		this.feedStatus = feedStatus;
		this.emailUtente = emailUtente;
	}

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Giorno getGiorno() {
		return giorno;
	}

	public void setGiorno(Giorno giorno) {
		this.giorno = giorno;
	}

	public Time getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(Time oraInizio) {
		this.oraInizio = oraInizio;
	}

	public Time getOraFine() {
		return oraFine;
	}

	public void setOraFine(Time oraFine) {
		this.oraFine = oraFine;
	}

	public boolean getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(boolean defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public boolean getFeedStatus() {
		return feedStatus;
	}

	public void setFeedStatus(boolean feedStatus) {
		this.feedStatus = feedStatus;
	}

	@Override
	public String toString() {
		return "OraAula [nome=" + nome + ", giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine
				+ ", defaultStatus=" + defaultStatus + ", feedStatus=" + feedStatus + ", emailUtente=" + emailUtente + "]";
	}
}
