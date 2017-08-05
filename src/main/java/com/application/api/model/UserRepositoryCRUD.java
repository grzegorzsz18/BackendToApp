package com.application.api.model;

import org.springframework.data.repository.CrudRepository;

import com.application.api.user.User;

public interface UserRepositoryCRUD extends CrudRepository<User,Integer>{
	public User findOneByToken(String token);
	public User findOneByLogin(String login);
}
