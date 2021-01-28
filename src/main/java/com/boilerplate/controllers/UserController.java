package com.boilerplate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boilerplate.interfaces.IUserService;
import com.boilerplate.entities.User;

@RestController
public final class UserController {
	@Autowired
	private IUserService service;

	@RequestMapping("/user")
	List<User> users(){
		return this.service.findAll();
	}
	
	@PostMapping("/user")
	void newUser(@RequestBody User newUser) {
		this.service.save(newUser);
	}
	
	@GetMapping("/user/{id}")
	User getOneUser(@PathVariable Long id) {
		return this.service.findOneById(id);
	}
	
	@DeleteMapping("/user/{id}")
	void deleteOneUser(@PathVariable Long id) {
	this.service.delete(id);	
	}
	
}
