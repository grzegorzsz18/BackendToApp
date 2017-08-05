package com.application.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.api.diary.DiaryEntity;
import com.application.api.service.DiaryServices;
import com.application.api.service.UserService;
import com.application.api.user.User;

@RestController
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	DiaryServices diaryServices;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public DiaryEntity addDiary(@RequestBody DiaryEntity diaryEntity){
		return diaryServices.addDiary(diaryEntity);
	}
	
	@RequestMapping(value = "/byId/{id}/{token}", method = RequestMethod.GET)
	public ResponseEntity<DiaryEntity> getByIdAndToken(@PathVariable("id") int id, @PathVariable("token") String token){
		User user = userService.getUserByToken(token);
		String login = user.getLogin();
		DiaryEntity diary = diaryServices.getByIdAndToken(id,login);
		if(diary == null){
			return new ResponseEntity<DiaryEntity>(diary,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<DiaryEntity>(diary,HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/byUser/{token}", method = RequestMethod.GET)
	public ResponseEntity<List<DiaryEntity>> getAllDiarysByUserId(@PathVariable("token") String token){
		User user = userService.getUserByToken(token);
		String login = user.getLogin();
		List<DiaryEntity> diary= diaryServices.getAllDiarysByUserId(login);
		if(diary.isEmpty()){
			return new ResponseEntity<List<DiaryEntity>>(diary,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DiaryEntity>>(diary,HttpStatus.OK);
	}
}
