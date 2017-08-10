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
	
	@RequestMapping(value = "/logout/{login}", method = RequestMethod.POST)
	public void logout(@PathVariable("login") String login) {
		User user = userService.getUserByLogin(login);
		userService.deleteUser(user);
		user.setToken(tokenService.generateToken(user.getLogin()));
		userService.addUser(user);
	}
	@RequestMapping(value = "/getToken", method = RequestMethod.POST)
	public ResponseEntity<String> getTokenByUserName(@RequestBody User user){
		User userOrg = userService.getUserByLogin(user.getLogin());
		if(userOrg.getPassword().equals(user.getPassword())) {
			return new ResponseEntity<String>(userService.getTokenByLogin(user.getLogin()),HttpStatus.OK);
		}
		return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public User addUser(@RequestBody User user){
		String token = tokenService.generateToken(user.getLogin());
		user.setToken(token);
		return userService.addUser(user);
	}
}
