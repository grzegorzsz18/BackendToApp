package com.application.api.service.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.application.api.calendar.Calendar;
import com.application.api.service.DTO.CalendarEntityDTO;

@Service
public class CalendarEntityConverter {
	public CalendarEntityDTO convertToDTO(Calendar calendar) {
		CalendarEntityDTO dto = new CalendarEntityDTO();
		dto.setCreationTime(calendar.getCreationTime());
		dto.setExecutionTime(calendar.getExecutionTime());
		dto.setId(calendar.getId());
		dto.setPriority(calendar.getPriority());
		dto.setSendEmail(calendar.isSendEmail());
		dto.setText(calendar.getText());
		dto.setTimeBeforeRemind(calendar.getTimeBeforeRemind());
		dto.setTitle(calendar.getTitle());
		dto.setUser(calendar.getUser());
		return dto;
	}
	
	public List<CalendarEntityDTO> convertToListDTO(List<Calendar> calendar){
		ArrayList<CalendarEntityDTO> entity = new ArrayList<>();
		for(Calendar c:calendar) {
			entity.add(convertToDTO(c));
		}
		return entity;
	}
}
