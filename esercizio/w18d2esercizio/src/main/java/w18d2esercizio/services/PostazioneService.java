package w18d2esercizio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import w18d2esercizio.entities.Postazione;
import w18d2esercizio.entities.TipoPostazione;

@Service
public class PostazioneService {

	List<Postazione> postazioni = new ArrayList<>();

	public Postazione save(Postazione postazione) {
		Random rnd = new Random();
		postazione.setId(rnd.nextInt());
		this.postazioni.add(postazione);
		return postazione;
	}

	public List<Postazione> getPostazioni() {
		return this.postazioni;
	}

	public Optional<Postazione> getPostazione(int id) {
		Postazione p = null;
		for (Postazione postazione : postazioni) {
			if (postazione.getId() == id) {
				p = postazione;
			}
		}

		return Optional.ofNullable(p);
	}

	public Optional<Postazione> updatePostazione(int id, Postazione postazione) {
		Postazione p = null;
		for (Postazione updatePostazione : postazioni) {
			if (updatePostazione.getId() == id) {
				p = updatePostazione;
				p.setId(id);
				p.setDescrizione(postazione.getDescrizione());
				p.setTipoPostazione(postazione.getTipoPostazione());
				p.setNumeroMassimo(postazione.getNumeroMassimo());
				p.setCitta(postazione.getCitta());
			}
		}

		return Optional.ofNullable(p);
	}

	public void deletePostazione(int id) {
		ListIterator<Postazione> iterator = this.postazioni.listIterator();
		while (iterator.hasNext()) {
			Postazione currentPostazione = iterator.next();
			if (currentPostazione.getId() == id) {
				iterator.remove();
			}
		}
	}

	public List<Postazione> getPostazioneByTipoAndCitta(TipoPostazione tipoPostazione, String citta) {
		return postazioni.stream().filter(postazione -> postazione.getTipoPostazione() == tipoPostazione
				&& postazione.getCitta().equalsIgnoreCase(citta)).collect(Collectors.toList());
	}

}
