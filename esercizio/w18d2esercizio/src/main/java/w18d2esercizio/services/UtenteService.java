package w18d2esercizio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import w18d2esercizio.entities.Utente;

@Service
public class UtenteService {
	private List<Utente> utenti = new ArrayList<>();

	public Utente save(Utente utente) {
		Random rnd = new Random();
		utente.setId(rnd.nextInt());
		this.utenti.add(utente);
		return utente;
	}

	public List<Utente> getUtenti() {
		return this.utenti;
	}

	public Optional<Utente> getUtente(int id) {
		Utente u = null;
		for (Utente utente : utenti) {
			if (utente.getId() == id) {
				u = utente;
			}
		}

		return Optional.ofNullable(u);
	}

	public void deleteUtente(int id) {
		ListIterator<Utente> iterator = this.utenti.listIterator();

		while (iterator.hasNext()) {
			Utente currentUtente = iterator.next();
			if (currentUtente.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Utente> updateUtente(int id, Utente utente) {
		Utente u = null;
		for (Utente updateUtente : utenti) {
			if (updateUtente.getId() == id) {
				u = updateUtente;
				u.setId(id);
				u.setUserName(utente.getUserName());
				u.setNomeCompleto(utente.getNomeCompleto());
				u.setEmail(utente.getEmail());
			}
		}

		return Optional.ofNullable(u);
	}
}
