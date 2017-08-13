package com.application.api.service.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.application.api.diary.DiaryEntity;
import com.application.api.service.DTO.DiaryEntityDTO;



@Service
public class DiaryEntityConverter {

	public DiaryEntityDTO diaryEntityToDTO(DiaryEntity diaryEntity) {
		DiaryEntityDTO dto = new DiaryEntityDTO();
		dto.setAuthorId(diaryEntity.getAuthorId());
		dto.setDate(diaryEntity.getDate());
		dto.setId(diaryEntity.getId());
		dto.setText(diaryEntity.getText());
		dto.setTitle(diaryEntity.getTitle());
		return dto;
	}
	
	public List<DiaryEntityDTO> diaryEntityToListDTO(List<DiaryEntity> diaryEntity){
		ArrayList<DiaryEntityDTO> diaryEntityDTOList = new ArrayList<>();
		for(DiaryEntity de : diaryEntity) {
			diaryEntityDTOList.add(diaryEntityToDTO(de));
		}
		return diaryEntityDTOList;
	}
}
