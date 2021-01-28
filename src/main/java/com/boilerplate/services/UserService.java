package com.boilerplate.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
		return (List<User>) repository.findAll();
	}

	@Override
	public void save(User newUser) {
		this.repository.save(newUser);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public User findOneById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

}
