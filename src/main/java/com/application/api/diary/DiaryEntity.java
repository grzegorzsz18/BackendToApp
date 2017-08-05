package com.application.api.diary;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DiaryEntity {
	
	@Id
	@GeneratedValue
	private int id;
	String title;
	String authorId;
	Date date;
	String text;
	

	public DiaryEntity(String title, String authorId, Date date, String text) {
		this.title = title;
		this.authorId = authorId;
		this.date = date;
		this.text = text;
	}


	public DiaryEntity() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String author) {
		this.authorId = author;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
}
