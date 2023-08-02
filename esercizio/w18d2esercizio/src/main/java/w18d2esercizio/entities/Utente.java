package w18d2esercizio.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Utente {
	private int id;
	private String userName;
	private String nomeCompleto;
	private String email;

	public Utente(String userName, String nomeCompleto, String email) {
		this.setUserName(userName);
		this.setNomeCompleto(nomeCompleto);
		this.setEmail(email);
	}

	@Override
	public String toString() {
		return "Utente [Id: " + id + ", UserName: " + userName + ", Nome Completo: " + nomeCompleto + ", Email: "
				+ email + "]";
	}
}
