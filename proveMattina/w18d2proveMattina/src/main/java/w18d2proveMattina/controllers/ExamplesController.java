package w18d2proveMattina.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import w18d2proveMattina.entities.User;

@RestController
@RequestMapping("/examples")
public class ExamplesController {

	@GetMapping("") // path se vuoto è opzionale
	public String index() {
		return "Pagina Principale";
	}

	@GetMapping("/about")
	public String about() {
		return "Pagina About";
	}

	@PostMapping("/index")
	public String postExample() {
		return "Ciao sono un post";
	}

	@PutMapping("/index")
	public String putExample() {
		return "Ciao sono una put";
	}

	@DeleteMapping("/index")
	public String deleteExample() {
		return "Ciao sono una delete";
	}

	@GetMapping("/queryParamExample")
	public String queryParams(@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname) {

		System.out.println("Query: ");
		System.out.println(name);
		System.out.println(surname);

		if (name != null && surname != null) {
			return "i'm a query " + name + " " + surname;
		} else {
			return "Ciao querycreator, non mi hai dato i tuoi dati";
		}

	}

	@GetMapping("/pathParamExample/{parameter}")
	public String pathParam(@PathVariable String parameter) {
		return "Ciao sei sull'endpoint pathParamExample/" + parameter;
	}

	@GetMapping("/pathParamExample")
	public String pathParam() {
		return "Ciao sei sull'endpoint pathParamExample/";
	}

	@PostMapping("/payloadExample")
	public String payload(@RequestBody User user) {
		System.out.println(user);
		return "Utente Salvato";
	}

	@GetMapping("/example")
	@ResponseStatus(HttpStatus.FOUND)
	public String example() {
		return "example";
	}

	@GetMapping("/customResponseExample")
	public ResponseEntity<User> customResponse() {
		User body = new User(5, "Noce", "Robusto");

		HttpHeaders header = new HttpHeaders();
		header.add("CustomHeader", "CustomValue");
		return new ResponseEntity<User>(body, header, HttpStatus.OK);
	}

}
