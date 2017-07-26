package com.application.api.diary;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.api.model.DiaryEntity;
import com.application.api.service.DiaryServices;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	DiaryServices diaryServices;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public DiaryEntity addDiary(@RequestBody DiaryEntity diaryEntity){
		return diaryServices.addDiary(diaryEntity);
	}
	
	 @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DiaryEntity>> getAllDiarys(){
		List<DiaryEntity> diary= diaryServices.getAllDiarys();
		if(diary.isEmpty()){
			return new ResponseEntity<List<DiaryEntity>>(diary,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DiaryEntity>>(diary,HttpStatus.OK);
	}
}
