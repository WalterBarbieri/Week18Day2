package w18d2esercizio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esercizio1")
public class Esercizio1Controller {

	@GetMapping("/{language}")
	public String getRules(@PathVariable String language) {
		if (language.equals("italiano")) {
			return "Una prentoazione vale solo per un giorno e può essere effettuata se la postazione risulta libera per quel giorno; l'utente può ricercare la postazione indicando tipo di postazione e città: un utente puù avere più prenotazioni ma non nella stessa data; una richiesta di prenotazione puù essere effettuata fino a due giorni prima.";
		} else if (language.equals("english")) {
			return "A booking last 1 day and can be issued if the location is free; user can search for a location by location type and city; a user can have multiple bookings, but not on the same day; a booking can be issued until 2 days prior the desidered date.";
		} else {
			return "Language not supported";
		}
	}
}
