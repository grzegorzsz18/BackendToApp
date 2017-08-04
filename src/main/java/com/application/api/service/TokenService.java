package com.application.api.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

	Random keyGenerator;
	
	public TokenService() {
		keyGenerator = new Random();
	}
	
	public String generateToken(String login) {
		return login + keyGenerator.nextInt(10000);
	}
}
