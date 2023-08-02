package w18d2proveMattina.controllers;

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

import w18d2proveMattina.entities.User;
import w18d2proveMattina.exceptions.NotFoundException;
import w18d2proveMattina.services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UserService us;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody User body) {
		User createdUser = us.save(body);
		return createdUser;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	public List<User> getUsers() {
		return us.getUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) throws Exception {
		return us.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	@PutMapping("/{id}")

	public User getUserAndUpdate(@PathVariable int id, @RequestBody User body) throws Exception {
		return us.findByIdAndUpdate(id, body).orElseThrow(() -> new NotFoundException(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void getUserAndDelete(@PathVariable int id) {
		us.findBiIdAndDelete(id);
	}

}
