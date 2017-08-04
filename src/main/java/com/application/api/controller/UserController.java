package com.application.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.api.service.TokenService;
import com.application.api.service.UserService;
import com.application.api.user.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	TokenService tokenService;
	
	@RequestMapping(value = "/get/{token}", method = RequestMethod.POST)
	public ResponseEntity<User> getUserById(@PathVariable("token") String token){
		User user = userService.getUserByToken(token);
		if(user == null) {
			return new ResponseEntity<User>(user,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public User addUser(@RequestBody User user){
		String token = tokenService.generateToken(user.getLogin());
		user.setToken(token);
		return userService.addUser(user);
	}
}
