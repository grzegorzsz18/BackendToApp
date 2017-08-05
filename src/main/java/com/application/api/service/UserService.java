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
	
	public String getTokenByLogin(String login) {
		User user = repo.findOneByLogin(login);
		return user.getToken();
	}
	
	public void deleteUser(User user) {
		repo.delete(user);
	}
	
	public User getUserByLogin(String login) {
		User user = repo.findOneByLogin(login);
		return user;
	}
	
	public User getUserByToken(String token) {
		return repo.findOneByToken(token);
	}
}
