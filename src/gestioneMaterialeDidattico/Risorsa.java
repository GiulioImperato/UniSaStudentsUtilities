package gestioneMaterialeDidattico;

import java.sql.Date;

public class Risorsa {
//hello
	private int idRisorsa;
	private String nome;
	private String proprietaio;
	private double dimensione;
	private Date dataUpload;
	private int like;
	private int dislike;
	private String pathCaricamento;


	/**
	 * Costruttore vuoto
	 * @author Antonio Corsuto
	 */


	public Risorsa() {
		super();
	}

	/**
	 * Costurttore con parmaetri :
	 * @param idRisorsa indica l'identificativo della risorsa
	 * @param nome indica il nome della risorsa
	 * @param proprietaio indica chi ha publicato la risorsa
	 * @param dimensione indicala le dimensioni della risorsa
	 * @param dataUpload indiaca la data dell upload
	 * @param like indica il numero di like
	 * @param dislike indica il numero di dislike
	 * @param pathCaricamento indica il path dove è stata ccaricata
	 * @author Antonio Corsuto
	 */

	public Risorsa(int idRisorsa, String nome, String proprietaio, double dimensione, Date dataUpload, int like,
			int dislike, String pathCaricamento) {
		super();
		this.idRisorsa = idRisorsa;
		this.nome = nome;
		this.proprietaio = proprietaio;
		this.dimensione = dimensione;
		this.dataUpload = dataUpload;
		this.like = like;
		this.dislike = dislike;
		this.pathCaricamento = pathCaricamento;
	}




	/**
	 * Restituisce il path della risorsa
	 * @return il path della risorsa
	 * @author Antonio Corsuto 
	 */

	public String getPathCaricamento() {
		return pathCaricamento;
	}


	/**
	 * Setta il path della risorsa
	 * @param pathCaricamento indica il nuovo path
	 * @author Antonio Corsuto 
	 */

	public void setPathCaricamento(String pathCaricamento) {
		this.pathCaricamento = pathCaricamento;
	}

	/**
	 * Restitusce l' ID della risorsa
	 * @return id risorsa
	 * @author Antonio Corsuto  
	 */


	public int getIdRisorsa() {
		return idRisorsa;
	}

	/**
	 * Setta l' ID della risorsa
	 * @param idRisorsa indica il nuovo ID
	 * @author Antonio Corsuto  
	 */

	public void setIdRisorsa(int idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	/**
	 * Restituisce il nome della risorsa
	 * @return nome risorsa
	 * @author Antonio Corsuto  
	 */



	public String getNome() {
		return nome;
	}

	/**
	 * Setta il nome della risorsa
	 * @param nome indica il nuovo nome 
	 * @author Antonio Corsuto  
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce l'identificativo del proprietario
	 * @return
	 * @author Antonio Corsuto 
	 */

	public String getProprietaio() {
		return proprietaio;
	}

	/**
	 * Setta un nuovo proprietario
	 * @param proprietaio indica il nuovo proprietario
	 * @author Antonio Corsuto 
	 */


	public void setProprietaio(String proprietaio) {
		this.proprietaio = proprietaio;
	}


	/**
	 * Restituisce le dimensioni della risorsa
	 * @return dimensioni risorsa
	 * @author Antonio Corsuto 
	 */

	public double getDimensione() {
		return dimensione;
	}

	/**
	 * Setta le dimensioni della risorsa
	 * @param dimensione indica le nuove dimensioni
	 * @author Antonio Corsuto  
	 */

	public void setDimensione(double dimensione) {
		this.dimensione = dimensione;
	}

	/**
	 * Restituisce la data di upload
	 * @return data upload
	 * @author Antonio Corsuto 
	 */


	public Date getDataUpload() {
		return dataUpload;
	}

	/**
	 * Setta la data di upload
	 * @param dataUpload indica la nuova data
	 * @author Antonio Corsuto 
	 */

	public void setDataUpload(Date dataUpload) {
		this.dataUpload = dataUpload;
	}

	/**
	 * Restituisce il numero di like della risorsa
	 * @return numero like risorsa
	 * @author Antonio Corsuto 
	 */

	public int getLike() {
		return like;
	}
	/**
	 * Setta il numero di like della Risorsa
	 * @param like indica il nuovo numero di like
	 * @author Antonio Corsuto  
	 */


	public void setLike(int like) {
		this.like = like;
	}

	/**
	 * Incrementa il numero dei like
	 * @return il numero dei like aggiornato
	 * @author Antonio Corsuto  
	 */
	
	public synchronized int addLike(){		
		like++;
		return like;

	}

	/**
	 * Restituisce il numero di dislike della risorsa
	 * @return numero dislike risorsa
	 * @author Antonio Corsuto 
	 */
	public int getDislike() {
		return dislike;
	}

	/**
	 * Setta il numero di dislike della Risorsa
	 * @param dislike indica il nuovo numero di dislike
	 * @author Antonio Corsuto  
	 */


	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	/**
	 * Incrementa il numero di dislike
	 * @return il numero dei dislike aggiornato
	 * @author Antonio Corsuto 
	 */
	
	public synchronized int addDisike(){		
		dislike++;
		return dislike;

	}




}
