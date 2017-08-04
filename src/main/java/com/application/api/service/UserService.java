package com.application.api.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.api.model.UserRepositoryCRUD;
import com.application.api.user.User;

@Repository
public class UserService {

	@Autowired
	UserRepositoryCRUD repo;
	
	public User addUser(User user) {
		return repo.save(user);
	}
	
	public User getUser(long id) {
		return repo.findOne(id);
	}
	
	public User getUserByToken(String token) {
		return repo.findOneByToken(token);
	}
}
