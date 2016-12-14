package gestioneAule;

import java.sql.Time;

public class OraAula {
	private String id;
	private Giorno giorno;
	private Time oraInizio;
	private Time oraFine;
	private boolean defaultStatus = false;
	private boolean feedStatus = false;
	
	public OraAula(){
	}
	
	public OraAula(String id, Giorno giorno, Time oraInizio, Time oraFine, boolean defaultStatus, boolean feedStatus) {
		this.id = id;
		this.giorno = giorno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.defaultStatus = defaultStatus;
		this.feedStatus = feedStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "OraAula [id=" + id + ", giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine
				+ ", defaultStatus=" + defaultStatus + ", feedStatus=" + feedStatus + "]";
	}	
}
