package com.application.api.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.application.api.calendar.Calendar;

public interface CalendarRepositoryCRUD extends CrudRepository<Calendar, Integer> {
	List<Calendar> findAllByUser(String user);
	
	List<Calendar> findAllByExecutionTimeBetweenAndUserEquals(long date1, long date2, String user);
	
	Calendar findOneById(int id);
}
