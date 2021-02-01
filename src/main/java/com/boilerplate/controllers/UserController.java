package com.boilerplate.controllers;

import com.boilerplate.entities.User;
import com.boilerplate.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class UserController {

	private final IUserService service;

	@Autowired
	public UserController(IUserService _service){
		this.service = _service;
	}

	@RequestMapping("/user")
	List<User> users(){
		return service.findAll();
	}

	@PostMapping("/user")
	ResponseEntity<User> newUser(@RequestBody User newUser)  {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newUser));
	}
	
	@GetMapping("/user/{id}")
	ResponseEntity<User> getOneUser(@PathVariable Long id) {
		User user = service.findOneById(id);
		if (user instanceof User) return ResponseEntity.status(HttpStatus.OK).body(user);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@DeleteMapping("/user/{id}")
	ResponseEntity deleteOneUser(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}

	@PutMapping("/user/{id}")
	ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) {
		User found = service.findOneById(id);
		if(found == null) return ResponseEntity.notFound().build();
		user.setId(found.getId());
		return ResponseEntity.ok().body(service.save(user));
	}
	
}
