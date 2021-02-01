package com.boilerplate.components;

import com.boilerplate.entities.User;
import com.boilerplate.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public final class UserCommandLineRunner implements CommandLineRunner {
@Autowired
	IUserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		// @TODO: place for migrations
		var users = this.userRepository.findAll();
		for (User u : users) System.out.println("Preloaded username: " + u.getUsername());
	}

}
