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
public class UserServiceTests {
@Autowired

	IUserService userService;

	@Test
	@DisplayName("Checking preloaded")
	public void testForTwoUsersPreloaded() {
		final var users = this.userService.findAll();
		assertTrue(users.size() > 1,"checking if more than 1");
	}

	@Test
	@DisplayName("Adding")
	public void testForAddingUser() {
		final User user = new User("unitTestUser", "UnitTestPassword123!");
		this.userService.save(user);
		final var found = this.userService.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		assertEquals(user.getUsername(), found.getUsername());
		assertEquals(user.getPassword(), found.getPassword());
	}

	@Test
	@DisplayName("Deletion")
	public void testForUserDeletion() {
		final User user = new User("UserForDeletion", "PasswrdForDeletion");
		this.userService.save(user);
		int initCount = this.userService.findAll().size();
		this.userService.delete(user.getId());
		int finalCount = this.userService.findAll().size();
		assertEquals(initCount -1, finalCount );
	}
	@Test
	@DisplayName("Get by user/pass")
	public void testForUserAuth() {
		User user = new User("BrandNewUser", "HisPassword");
		user = this.userService.save(user);
		final User auth = this.userService.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		assertEquals(user.getId(), auth.getId());
	}
	@Test
	@DisplayName("Get by active user/pass")
	public void testForActiveUserAuth() {
		User user = new User("BrandNewInactiveUser", "HisPassword");
		user.setActive(false);
		user = this.userService.save(user);
		final User auth = this.userService.findOneActiveByUsernameAndPassword(user.getUsername(), user.getPassword());
		assertEquals(auth, null);
	}

	@Test
	@DisplayName("Update")
	public void testForUpdate() {
		final User user = new User("UserForUpdate", "UpdatedUser123!");
		this.userService.save(user);
		User found = this.userService.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		assertTrue(found.getId() != null, "Found real user");
		found.setUsername("UpdatedUsername");
		this.userService.save(found);
		final User asserted = this.userService.findOneByUsernameAndPassword(found.getUsername(), user.getPassword());
		assertTrue(asserted != null, "Updated user found");
		assertTrue( user.getId() == asserted.getId(), "User ID is persisted");
	}
}
