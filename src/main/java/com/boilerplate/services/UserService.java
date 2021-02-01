package com.boilerplate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.boilerplate.interfaces.IUserRepository;
import com.boilerplate.interfaces.IUserService;
import com.boilerplate.entities.User;

@Service
public class UserService implements IUserService {

    private final IUserRepository repository;

    @Autowired
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User newUser) {
        return repository.save(newUser);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findOneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User findOneByUsernameAndPassword(String username, String password) {
        Example<User> example = Example.of(new User(username, password));
        return repository.findOne(example).orElse(null);
    }
    public User findOneActiveByUsernameAndPassword(String username, String password) {
        User user = new User(username, password);
        user.setActive(true);
        Example<User> example = Example.of(user);
        return repository.findOne(example).orElse(null);
    }

}
