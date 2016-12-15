package gestioneAule;

import java.sql.Time;

public class OraAula {
	private String nome;
	private Giorno giorno;
	private Time oraInizio;
	private Time oraFine;
	private boolean defaultStatus = false;
	private boolean feedStatus = false;
	private String emailUtente;				//Far vedere al prof. Gravino
	
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

	public boolean isDefaultStatus() {
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
