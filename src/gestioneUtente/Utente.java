package gestioneUtente;

public class Utente {

	public Utente() {
	}

	/**
	 * Costruttore utente
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param password
	 * @param status
	 * @param privilegioAdmin
	 */
	public Utente( String nome, String cognome, String email, String password,boolean status,
			boolean privilegioAdmin) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.status = status;
		this.privilegioAdmin = privilegioAdmin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isPrivilegioAdmin() {
		return privilegioAdmin;
	}

	public void setPrivilegioAdmin(boolean privilegioAdmin) {
		this.privilegioAdmin = privilegioAdmin;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password=" + password
				+ ", status=" + status + ", privilegioAdmin=" + privilegioAdmin + "]";
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

	private String nome;
	private String cognome;
	private String email;
	private String password;
	private boolean status;
	private boolean privilegioAdmin;
}
