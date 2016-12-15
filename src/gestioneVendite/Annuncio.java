package gestioneVendite;
/**
 * @author Pasquale Settembre
 */
public class Annuncio {
	private int idAnnuncio;
	private String titolo;
	private String autore;
	private String corso;
	private String proprietario;
	private CondizioneLibro condizioneLibro;
	private double prezzo;
	private DettagliAnnuncio dettagliAnnuncio;
	
	/**
	 * <b>Creazione annuncio senza parametri</b>
	 */
	public Annuncio(){}
	
	/**
	 * <b>Creazione di un annuncio</b>
	 * @param titolo
	 * @param autore
	 * @param corso
	 * @param proprietario
	 * @param condizioneLibro
	 * @param prezzo
	 * @param dettagliAnnuncio oggetto dettagliAnnuncio collegato all'annuncio
	 */
	public Annuncio(String titolo, String autore, String corso, String proprietario,
			CondizioneLibro condizioneLibro, double prezzo, DettagliAnnuncio dettagliAnnuncio) {
		this.titolo = titolo;
		this.autore = autore;
		this.corso = corso;
		this.proprietario = proprietario;
		this.condizioneLibro = condizioneLibro;
		this.prezzo = prezzo;
		this.dettagliAnnuncio = dettagliAnnuncio;
	}
	
	public int getIdAnnuncio() {
		return idAnnuncio;
	}
	public void setIdAnnuncio(int idAnnuncio) {
		this.idAnnuncio = idAnnuncio;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public CondizioneLibro getCondizioneLibro() {
		return condizioneLibro;
	}
	public void setCondizioneLibro(CondizioneLibro condizioneLibro) {
		this.condizioneLibro = condizioneLibro;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public DettagliAnnuncio getDettagliAnnuncio() {
		return dettagliAnnuncio;
	}
	public void setDettagliAnnuncio(DettagliAnnuncio dettagliAnnuncio) {
		this.dettagliAnnuncio = dettagliAnnuncio;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	public String toString() {
		return "Annuncio [idAnnuncio=" + idAnnuncio + ", titolo=" + titolo + ", autore=" + autore + ", corso=" + corso
				+ ", proprietario=" + proprietario + ", condizioneLibro=" + condizioneLibro + ", prezzo=" + prezzo
				+ "]";
	}


	

	
	
	
	
	
}
