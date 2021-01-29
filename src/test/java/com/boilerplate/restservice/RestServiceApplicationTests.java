package com.boilerplate.restservice;

import com.boilerplate.entities.User;
import com.boilerplate.interfaces.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestServiceApplicationTests {
@Autowired
	IUserService userService;
	private User user = new User("unitTestUser", "UnitTestPassword123!");
	@Test
	@DisplayName("Checking for preloaded users")
	public void testForTwoUsersPreloaded() {
		var users = this.userService.findAll();
		assertTrue(users.size() > 1,"checking if more than 1");
	}

	@Test
	@DisplayName("Checking for adding new user")
	public void testForAddingUser() {
		this.userService.save(user);
		var found = this.userService.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		assertEquals(user.getUsername(), found.getUsername());
		assertEquals(user.getPassword(), found.getPassword());
	}

}
