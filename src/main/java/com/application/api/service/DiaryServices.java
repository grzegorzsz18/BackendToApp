package com.application.api.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.api.diary.DiaryEntity;
import com.application.api.model.DiaryRepositoryCRUD;

@Repository
public class DiaryServices {

	@Autowired
	DiaryRepositoryCRUD repo;
	
	public DiaryEntity addDiary(DiaryEntity entity){
		return repo.save(entity);
	}
	
	public List<DiaryEntity> getAllDiarysByUserId(int id){
		return  (List<DiaryEntity>) repo.findAllByAuthorId(id);
	}
	
	public DiaryEntity getById(long id){
		return repo.findOne(id);
	}
}
