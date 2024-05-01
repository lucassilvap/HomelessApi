package com.apimoradoresderua.homeless.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimoradoresderua.homeless.modellmapper.ParentsTelephoneModellMapper;
import com.apimoradoresderua.homeless.service.FindparentsTelephonesService;

@RequestMapping("/parents")
@RestController
public class ParentsTelephoneController {
	
	@Autowired
	private ParentsTelephoneModellMapper modellMapper;
	
	@Autowired
	private FindparentsTelephonesService parentsTelephoneService;
	
	@RequestMapping
	public ResponseEntity<?> findTelephonesParetensByNameHomeless(@RequestParam
	(required = true, name="name") Optional<String> name) {
		return ResponseEntity.ok(modellMapper
				.entityToDtoList(parentsTelephoneService
				.findparentsTelephonesByNameHomeless(name)));
	}

}
