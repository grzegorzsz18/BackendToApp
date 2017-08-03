package com.application.api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.api.model.DiaryEntity;
import com.application.api.model.DiaryRepositoryCRUD;

@Repository
public class DiaryServices {

	@Autowired
	DiaryRepositoryCRUD repo;
	
	public DiaryEntity addDiary(DiaryEntity entity){
		return repo.save(entity);
	}
	
	public List<DiaryEntity> getAllDiarysByUserId(int id){
		repo.save(new DiaryEntity("tytuł1",1,new Date(2000,3,24),"text"));
		repo.save(new DiaryEntity("tytuł2",2,new Date(2000,3,24),"text"));
		repo.save(new DiaryEntity("tytuł3",3,new Date(2000,3,24),"text"));
		return  (List<DiaryEntity>) repo.findAllByAuthorId(id);
	}
	
	public DiaryEntity getById(long id){
		return repo.findOne(id);
	}
}
