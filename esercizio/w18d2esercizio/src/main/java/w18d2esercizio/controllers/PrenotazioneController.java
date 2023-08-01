package w18d2esercizio.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import w18d2esercizio.entities.Prenotazione;
import w18d2esercizio.entities.payload.PrenotazionePayload;
import w18d2esercizio.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService ps;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione save(@RequestBody PrenotazionePayload pl) throws Exception {
		LocalDate giornoPrenotazione = pl.getGiornoPrenotazione();
		int utenteId = pl.getUtenteId();
		int postazioneId = pl.getPostazioneId();

		Prenotazione newPrenotazione = ps.save(giornoPrenotazione, utenteId, postazioneId);
		return newPrenotazione;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Prenotazione> getPrenotazioni() {
		return ps.getPrenotazioni();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Prenotazione getPrenotazioneById(@PathVariable int id) throws Exception {
		return ps.getPrenotazione(id).orElseThrow(() -> new Exception("Postazione non trovato"));

	}
}
