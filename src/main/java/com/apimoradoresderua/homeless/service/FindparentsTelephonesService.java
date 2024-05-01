package com.apimoradoresderua.homeless.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimoradoresderua.homeless.entity.ParentsTelephone;
import com.apimoradoresderua.homeless.repository.ParentesTelephoneRepository;
import com.apimoradoresderua.homeless.specification.ParentsTelephoneSpecification;

@Service
public class FindparentsTelephonesService {
	
	@Autowired
	private ParentesTelephoneRepository parentesTelephoneRepository;
	
	public List<ParentsTelephone> findparentsTelephonesByNameHomeless(Optional<String> name){
		return parentesTelephoneRepository.findAll(ParentsTelephoneSpecification.spec(name));
	}
	
}
