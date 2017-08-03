package com.application.api.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DiaryRepositoryCRUD extends CrudRepository<DiaryEntity,Long>{
	List<DiaryEntity> findAllByAuthorId(int id);
}
