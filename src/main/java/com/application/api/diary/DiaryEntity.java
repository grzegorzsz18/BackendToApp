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
	private long id;
	String title;
	int authorId;
	Date date;
	String text;
	

	public DiaryEntity(String title, int authorId, Date date, String text) {
		this.title = title;
		this.authorId = authorId;
		this.date = date;
		this.text = text;
	}


	public DiaryEntity() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int author) {
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
