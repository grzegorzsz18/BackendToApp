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
import com.application.api.service.Converter.DiaryEntityConverter;
import com.application.api.service.DTO.DiaryEntityDTO;
import com.application.api.user.User;

@RestController
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	DiaryServices diaryServices;
	@Autowired
	UserService userService;
	@Autowired
	DiaryEntityConverter diaryConverter;
	
	@RequestMapping(value = "/delete/{token}", method = RequestMethod.POST)
	public ResponseEntity<DiaryEntityDTO> deleteDiaryById(@RequestBody int diaryId, @PathVariable("token") String token){
		String login = userService.getUserByToken(token).getLogin();
		DiaryEntity diaryEntity = diaryServices.getById(diaryId);
		if(login.equals(diaryEntity.getAuthorId())){
			diaryServices.removeById(diaryEntity.getId());
			return new ResponseEntity<DiaryEntityDTO>(diaryConverter.diaryEntityToDTO(diaryEntity), HttpStatus.OK);
		}
		return new ResponseEntity<DiaryEntityDTO>(diaryConverter.diaryEntityToDTO(diaryEntity),HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value = "/modify/{token}", method = RequestMethod.POST)
		public ResponseEntity<DiaryEntityDTO> modifyDiaryByIdAndToken(@RequestBody DiaryEntity diaryEntity, @PathVariable("token") String token){
		String login = userService.getUserByToken(token).getLogin();
		if(login.equals(diaryEntity.getAuthorId())) {
			diaryServices.removeById(diaryEntity.getId());
			diaryServices.addDiary(diaryEntity);
			return new ResponseEntity<DiaryEntityDTO>(diaryConverter.diaryEntityToDTO(diaryEntity),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value = "/add/{token}", method = RequestMethod.PUT)
	public ResponseEntity<DiaryEntityDTO> addDiary(@RequestBody DiaryEntity diaryEntity, @PathVariable("token") String token){
		if(userService.getUserByToken(token) != null) {
		return new ResponseEntity<DiaryEntityDTO>(diaryConverter.diaryEntityToDTO(diaryServices.addDiary(diaryEntity)),HttpStatus.OK);
		}
		return new ResponseEntity<DiaryEntityDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/byId/{id}/{token}", method = RequestMethod.GET)
	public ResponseEntity<DiaryEntityDTO> getByIdAndToken(@PathVariable("id") int id, @PathVariable("token") String token){
		User user = userService.getUserByToken(token);
		String login = user.getLogin();
		DiaryEntity diary = diaryServices.getByIdAndToken(id,login);
		if(diary == null){
			return new ResponseEntity<DiaryEntityDTO>(diaryConverter.diaryEntityToDTO(diary),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<DiaryEntityDTO>(diaryConverter.diaryEntityToDTO(diary),HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/byUser/{token}", method = RequestMethod.GET)
	public ResponseEntity<List<DiaryEntityDTO>> getAllDiarysByUserId(@PathVariable("token") String token){
		User user = userService.getUserByToken(token);
		String login = user.getLogin();
		List<DiaryEntity> diary= diaryServices.getAllDiarysByUserId(login);
		if(diary.isEmpty()){
			return new ResponseEntity<List<DiaryEntityDTO>>(diaryConverter.diaryEntityToListDTO(diary),HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DiaryEntityDTO>>(diaryConverter.diaryEntityToListDTO(diary),HttpStatus.OK);
	}
}
