package org.hunter.userservice.controller;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.hunter.userservice.model.HealthStatus;
import org.hunter.userservice.model.User;
import org.hunter.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
public class UserServiceController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/", produces = "application/json")
	public HealthStatus getHealthStatus() {
		return new HealthStatus();
	}

	@GetMapping(path = "/user/{id}", produces = "application/json")
	public User getUser(@PathVariable UUID id) {
		try {
			return userRepository.findById(id).get();
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
	}

	@PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}
