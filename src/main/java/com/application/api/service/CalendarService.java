package com.application.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.api.calendar.Calendar;
import com.application.api.model.CalendarRepositoryCRUD;

@Service
public class CalendarService {

	@Autowired
	CalendarRepositoryCRUD repo;
	
	public Calendar addCallendar(Calendar calendar) {
		calendar.setCreationTime(System.currentTimeMillis());
		return repo.save(calendar);
	}
	
	public List<Calendar> getAllCallendar(String user){
		return repo.findAllByUser(user);
	}
	
	public List<Calendar> getAllCallendarBetween(long date1, long date2, String user){
		return repo.findAllByExecutionTimeBetweenAndUserEquals(date1, date2, user);
	}
	
	public Calendar getCalendarById(int id){
		return repo.findOneById(id);
	}
}
