package com.apimoradoresderua.homeless.modellmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.apimoradoresderua.homeless.dto.ParentsTelephoneDto;
import com.apimoradoresderua.homeless.entity.ParentsTelephone;

@Component
public class ParentsTelephoneModellMapper {
	
	@Autowired
	private ModelMapper parentsModelMapper;
	
	public ParentsTelephoneDto entityToDtoPerson (ParentsTelephone entity) {
		return parentsModelMapper.map(entity, ParentsTelephoneDto.class);
	}
	
	public List<ParentsTelephoneDto> entityToDtoList(List<ParentsTelephone> parentsTelephones){
		List<ParentsTelephoneDto> dtos = parentsTelephones
				                       .stream()
				                       .map(p -> parentsModelMapper.map(p,ParentsTelephoneDto.class))
				                       .collect(Collectors.toList());
		return dtos;
	}
}
