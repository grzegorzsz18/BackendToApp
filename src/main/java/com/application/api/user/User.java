package com.application.api.user;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	int id;
	String login;
	String name;
	String surName;
	long birthdate;
	String password;
	String token;
	String email;
	
	
	public User() {
		
	}
	
	public User(String login, String name, String surName, long birthdate, String password, String email) {
		this.login = login;
		this.name = name;
		this.surName = surName;
		this.birthdate = birthdate;
		this.password = password;
		this.token = "0";
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public long getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(long birthdate) {
		this.birthdate = birthdate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
