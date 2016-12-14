package gestioneAule;

public class Aula {
	private String nome;
	private double coordinateX;
	private double coordinateY;
	private OraAula oraAula;
	
	public Aula(){
	}
	
	public Aula(String nome, double coordinateX, double coordinateY, OraAula oraAula) {
		this.nome = nome;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.oraAula = oraAula;
	}

	public String getNome() {
		return nome;
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

	public OraAula getOraAula() {
		return oraAula;
	}

	public void setOraAula(OraAula oraAula) {
		this.oraAula = oraAula;
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
