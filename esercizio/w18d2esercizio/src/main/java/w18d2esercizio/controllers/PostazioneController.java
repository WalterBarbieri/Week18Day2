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

import w18d2esercizio.entities.Postazione;
import w18d2esercizio.services.PostazioneService;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {
	@Autowired
	private PostazioneService ps;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione save(@RequestBody Postazione postazione) {
		Postazione newPostazione = ps.save(postazione);
		return newPostazione;
	}

	@GetMapping("")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Postazione> getPostazioni() {
		return ps.getPostazioni();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Postazione getPostazioneById(@PathVariable int id) throws Exception {
		return ps.getPostazione(id).orElseThrow(() -> new Exception("Postazione non trovato"));

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Postazione updatePostazioneById(@PathVariable int id, @RequestBody Postazione postazione) throws Exception {
		return ps.updatePostazione(id, postazione).orElseThrow(() -> new Exception("Postazione non trovato"));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePostazioneById(@PathVariable int id) {
		ps.deletePostazione(id);
	}
}
