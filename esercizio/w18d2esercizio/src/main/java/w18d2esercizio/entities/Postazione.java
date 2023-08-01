package w18d2esercizio.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Postazione {
	private int id;
	private String descrizione;
	private TipoPostazione tipoPostazione;
	private int numeroMassimo;
	private String citta;

	public Postazione(String descrizione, TipoPostazione tipoPostazione, int numeroMassimo, String citta) {
		this.setDescrizione(descrizione);
		this.setTipoPostazione(tipoPostazione);
		this.setNumeroMassimo(numeroMassimo);
		this.setCitta(citta);

	}

	@Override
	public String toString() {
		return "Postazione [Id: " + id + ", Descrizione: " + descrizione + ", Tipo Postazione: " + tipoPostazione
				+ ", Numero Massimo Occupanti: " + numeroMassimo + "]";
	}
}
