package com.application.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.api.calendar.Calendar;
import com.application.api.service.CalendarService;
import com.application.api.service.TokenService;
import com.application.api.service.UserService;
import com.application.api.service.Converter.CalendarEntityConverter;
import com.application.api.service.DTO.CalendarEntityDTO;
import com.application.api.service.DTO.DiaryEntityDTO;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CalendarService calendarService;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	CalendarEntityConverter converter;
	
	@RequestMapping(value = "/add/{token}", method = RequestMethod.PUT)
	public ResponseEntity<CalendarEntityDTO> addCalendar(@RequestBody Calendar calendar, @PathVariable("token") String token){
		if(userService.getUserByToken(token).getLogin() == null) {
			return new ResponseEntity<CalendarEntityDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CalendarEntityDTO>(converter.convertToDTO(calendarService.addCallendar(calendar)),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getAll/{token}", method = RequestMethod.GET)
	public ResponseEntity<List<CalendarEntityDTO>> getAllCalendar(@PathVariable("token") String token){
		String login = userService.getUserByToken(token).getLogin();
		if(login == null) {
			return new ResponseEntity<List<CalendarEntityDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CalendarEntityDTO>>(converter.convertToListDTO(calendarService.getAllCallendar(login)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAllBetween/{token}/{id}", method = RequestMethod.GET)
	public ResponseEntity<CalendarEntityDTO> getCalendarById(@PathVariable("token") String token,
			@PathVariable("id")int id){
		String login = userService.getUserByToken(token).getLogin();
		if(login == null) {
			return new ResponseEntity<CalendarEntityDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CalendarEntityDTO>(converter.convertToDTO(calendarService.getCalendarById(id)), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getAllBetween/{token}/{from}/{to}", method = RequestMethod.GET)
	public ResponseEntity<List<CalendarEntityDTO>> getAllCalendarBetween(@PathVariable("token") String token,
			@PathVariable("from") long date1, @PathVariable("to") long date2){
		String login = userService.getUserByToken(token).getLogin();
		if(login == null) {
			return new ResponseEntity<List<CalendarEntityDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CalendarEntityDTO>>(converter.convertToListDTO(calendarService.getAllCallendarBetween(date1, date2, login)), HttpStatus.OK);
	}

}
