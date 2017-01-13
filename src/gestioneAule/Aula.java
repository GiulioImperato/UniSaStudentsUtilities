package gestioneAule;

import java.util.ArrayList;
/**
 * Oggetto Aula che identifica un'aula
 * @param nome indica il nome dell'aula
 * @param coordinateX indica la latitudine
 * @param coordinateY indica la longitudine
 * @author Angelo Settembre
 *
 */
public class Aula {
	private String nome;
	private double coordinateX;
	private double coordinateY;
	private ArrayList<OraAula> oraAula;
	
	public Aula(){
	}
	
	public Aula(String nome, double coordinateX, double coordinateY) {
		this.nome = nome;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		oraAula = new ArrayList<OraAula>();
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<OraAula> getOraAula() {
		return oraAula;
	}

	public void setOraAula(ArrayList<OraAula> oraAula) {
		this.oraAula = oraAula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	@Override
	public String toString() {
		return "Aula [nome=" + nome + ", coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + ", oraAula="
				+ oraAula + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	
}
