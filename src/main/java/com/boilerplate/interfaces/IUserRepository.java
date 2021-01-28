package com.boilerplate.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boilerplate.entities.User;

@Repository
public interface IUserRepository extends JpaRepository <User, Long> {
	List<User> findAll();
}
