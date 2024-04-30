package com.apimoradoresderua.homeless.modellmapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.apimoradoresderua.homeless.dto.HomelessPersonDto;
import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;
import com.apimoradoresderua.homeless.pageOptions.PageCreate;


@Component
public class HomelessModelMapper {
	
	@Autowired
	private ModelMapper homelessModelMaper;
	
	@Autowired
	private PageCreate pageCreate;
	
	public HomelessPersonDto entityToDtoPerson (HomelessPersonEntity entity) {
		return homelessModelMaper.map(entity, HomelessPersonDto.class);
	}
	
	public HomelessPersonEntity dtoPersonToEntity (HomelessPersonDto dto) {
		return homelessModelMaper.map(dto, HomelessPersonEntity.class);
	}
	
	public Page<HomelessPersonDto> entityPageToDtoPage(Page<HomelessPersonEntity> page){
		List<HomelessPersonDto> dtos = page.getContent()
				.stream()
				.map(h -> homelessModelMaper
			    .map(h,HomelessPersonDto.class))
				.collect(Collectors.toList());
		return pageCreate.pageImp(dtos, page);
		
	}
}
