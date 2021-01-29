package com.boilerplate.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.boilerplate.interfaces.IUserRepository;
import com.boilerplate.interfaces.IUserService;
import com.boilerplate.entities.User;

@Service
public  class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User save(User newUser) {
		return this.repository.save(newUser);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public User findOneById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	public User findOneByUsernameAndPassword(String username, String password) {
		Example<User> example = Example.of(new User(username, password));
		return this.repository.findOne(example).orElse(null);
	}

}
