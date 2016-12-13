package gestioneUtente;

public class Utente {

	public Utente() {
	}

	public Utente( String nome, String cognome, String email, String password,byte status,
			byte privilegioAdmin) {
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

	public byte isStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public byte isPrivilegioAdmin() {
		return privilegioAdmin;
	}

	public void setPrivilegioAdmin(byte privilegioAdmin) {
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
	private byte status;
	private byte privilegioAdmin;
}
