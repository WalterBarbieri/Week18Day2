package w18d2esercizio.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
	private int id;
	private LocalDate giornoPrenotazione;
	private Postazione postazione;
	private Utente utente;

	public Prenotazione(LocalDate giornoPrenotazione, Postazione postazione, Utente utente) {
		this.setGiornoPrenotazione(giornoPrenotazione);
		this.setPostazione(postazione);
		this.setUtente(utente);
	}

	@Override
	public String toString() {
		return "Prenotazione [Id: " + id + ", Data Prenotazione: " + giornoPrenotazione + ", Postazione"
				+ postazione.getTipoPostazione() + " in " + postazione.getCitta() + ", Utente: "
				+ utente.getNomeCompleto() + "]";
	}
}
