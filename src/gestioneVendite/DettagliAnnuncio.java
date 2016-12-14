package gestioneVendite;

import java.util.Date;

public class DettagliAnnuncio {
	private int id;
	private String editore;
	private int anno;
	private String descrizione;
	private Date data;
	private String foto;
	
	public DettagliAnnuncio() {}
	
	public DettagliAnnuncio(String editore, int anno, String descrizione, Date data, String foto) {
		this.editore = editore;
		this.anno = anno;
		this.descrizione = descrizione;
		this.data = data;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "DettagliAnnuncio [id=" + id + ", editore=" + editore + ", anno=" + anno + ", descrizione=" + descrizione
				+ ", data=" + data + ", foto=" + foto + "]";
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
	
	
}
