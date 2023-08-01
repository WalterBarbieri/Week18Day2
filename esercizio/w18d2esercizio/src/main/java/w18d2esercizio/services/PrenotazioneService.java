package w18d2esercizio.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import w18d2esercizio.entities.Postazione;
import w18d2esercizio.entities.Prenotazione;
import w18d2esercizio.entities.Utente;

@Service
public class PrenotazioneService {
	List<Prenotazione> prenotazioni = new ArrayList<>();

	@Autowired
	private UtenteService us;

	@Autowired
	private PostazioneService ps;

	public Prenotazione save(LocalDate giornoPrenotazione, int utenteId, int postazioneId) throws Exception {
		Random rnd = new Random();
		Utente utente = us.getUtente(utenteId).orElseThrow(() -> new Exception("Utente non trovato"));
		Postazione postazione = ps.getPostazione(postazioneId)
				.orElseThrow(() -> new Exception("Postazione non trovata"));
		if (utenteDisponibile(utenteId, giornoPrenotazione) && postazioneDisponibile(postazioneId, giornoPrenotazione)
				&& dataInRange(giornoPrenotazione)) {
			Prenotazione newPrenotazione = new Prenotazione();
			newPrenotazione.setId(rnd.nextInt());
			newPrenotazione.setGiornoPrenotazione(giornoPrenotazione);
			newPrenotazione.setUtente(utente);
			newPrenotazione.setPostazione(postazione);
			this.prenotazioni.add(newPrenotazione);
			return newPrenotazione;
		} else {
			return null;
		}

	}

	public boolean utenteDisponibile(int utenteId, LocalDate giornoPrenotazione) {
		boolean result = prenotazioni.stream().filter(prenotazione -> prenotazione.getUtente().getId() == utenteId)
				.noneMatch(prenotazione -> prenotazione.getGiornoPrenotazione().equals(giornoPrenotazione));
		System.out.println("utente disponibile: " + result);
		return result;
	}

	public boolean postazioneDisponibile(int postazioneId, LocalDate giornoPrenotazione) {
		boolean result = prenotazioni.stream()
				.filter(prenotazione -> prenotazione.getPostazione().getId() == postazioneId)
				.noneMatch(prenotazione -> prenotazione.getGiornoPrenotazione().equals(giornoPrenotazione));
		System.out.println("utente disponibile: " + result);
		return result;
	}

	public boolean dataInRange(LocalDate giornoPrenotazione) {
		boolean result = LocalDate.now().isBefore(giornoPrenotazione.minusDays(2));
		System.out.println("utente disponibile: " + result);
		return result;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public Optional<Prenotazione> getPrenotazione(int id) {
		Prenotazione p = null;
		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == id) {
				p = prenotazione;
			}
		}

		return Optional.ofNullable(p);
	}
}
