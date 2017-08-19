package com.application.api.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.application.api.diary.DiaryEntity;

public interface DiaryRepositoryCRUD extends CrudRepository<DiaryEntity,Integer>{
	List<DiaryEntity> findAllByAuthorId(String id);
	DiaryEntity findOneByAuthorIdAndId(String author, int id);
	DiaryEntity findOneById(int id);
}
