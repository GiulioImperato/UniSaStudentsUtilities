package gestioneAule;

import java.sql.Time;

public class OraAula {
	private String nome;
	private Giorno giorno;
	private Time oraInizio;
	private Time oraFine;
	private boolean defaultStatus = false;
	private boolean feedStatus = false;
	private String email;				//Far vedere al prof. Gravino
	
	public OraAula(){
	}
	
	public OraAula(String nome, Giorno giorno, Time oraInizio, Time oraFine, boolean defaultStatus, boolean feedStatus, String email) {
		this.nome = nome;
		this.giorno = giorno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.defaultStatus = defaultStatus;
		this.feedStatus = feedStatus;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean isFeedStatus() {
		return feedStatus;
	}

	public void setFeedStatus(boolean feedStatus) {
		this.feedStatus = feedStatus;
	}

	@Override
	public String toString() {
		return "OraAula [nome=" + nome + ", giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine
				+ ", defaultStatus=" + defaultStatus + ", feedStatus=" + feedStatus + ", email=" + email + "]";
	}
}
