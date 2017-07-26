package com.application.api.service;

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
	
	public List<DiaryEntity> getAllDiarys(){
		repo.save(new DiaryEntity("text"));
		return  (List<DiaryEntity>) repo.findAll();
	}
}
