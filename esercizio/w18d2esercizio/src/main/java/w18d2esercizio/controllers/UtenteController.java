package w18d2esercizio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import w18d2esercizio.entities.Utente;
import w18d2esercizio.services.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService us;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente save(@RequestBody Utente utente) {
		Utente newUtente = us.save(utente);
		return newUtente;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Utente> getUtenti() {
		return us.getUtenti();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Utente getUtenteById(@PathVariable int id) throws Exception {
		return us.getUtente(id).orElseThrow(() -> new Exception("Utente non trovato"));

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Utente updateUtenteById(@PathVariable int id, @RequestBody Utente utente) throws Exception {
		return us.updateUtente(id, utente).orElseThrow(() -> new Exception("Utente non trovato"));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUtenteById(@PathVariable int id) {
		us.deleteUtente(id);
	}
}
