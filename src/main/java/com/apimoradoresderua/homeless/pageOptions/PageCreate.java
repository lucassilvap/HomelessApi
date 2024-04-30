package com.apimoradoresderua.homeless.pageOptions;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.apimoradoresderua.homeless.dto.HomelessPersonDto;
import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;


@Service
public class PageCreate {
	
	int pageDefault = 0;
	int sizeDefault = 10;
	
	public PageCreate setPage(int page) {
		this.pageDefault = page;
		return this;
	}
	
	public PageCreate setSize(int size) {
		this.sizeDefault = size;
		return this;
	}
	
	public PageRequest build (Optional<Integer> page, Optional<Integer> size) {
		if(page.isPresent()) 
		setPage(page.get());
		if(size.isPresent())
		setSize(size.get());
		return PageRequest.of(pageDefault, sizeDefault);
	}
	
	public PageImpl<HomelessPersonDto> pageImp (List<HomelessPersonDto> dtos, Page<HomelessPersonEntity> page){
		return new PageImpl<HomelessPersonDto>(dtos, page.getPageable(), page.getTotalElements());
	}
	
}
