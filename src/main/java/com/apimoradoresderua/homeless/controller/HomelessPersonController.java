package com.apimoradoresderua.homeless.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimoradoresderua.homeless.dto.HomelessPersonDto;
import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;
import com.apimoradoresderua.homeless.modellmapper.HomelessModelMapper;
import com.apimoradoresderua.homeless.service.HomelessService;

@RestController
public class HomelessPersonController {
	
	@Autowired
	private HomelessModelMapper homelessModelMaper;
	
	@Autowired
	private HomelessService homelessService; 
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		  return ResponseEntity.ok(homelessService.findALLHomelessDefault());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(homelessService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<?> find( @RequestParam(required = true, name="partName") Optional<String> partName,
		@RequestParam(required = true, name ="page") Optional<Integer> page, 
	    @RequestParam(required = true, name = "size") Optional<Integer> size, 
	    @RequestParam(required = true, name = "currentSituation") Optional<String> currentSituation,
	    @RequestParam(required = true, name = "ageGreaterThan") Optional<Integer> age, 
	    @RequestParam(required = true, name = "ageBetween") Optional<List<Integer>> ageBetween,
	    @RequestParam(required = true, name = "ageInList") Optional<List<Integer>> ageInList){
		
		return ResponseEntity.ok(homelessModelMaper.entityPageToDtoPage(homelessService.
		findALLHomeless(partName, page, size, currentSituation, age, ageBetween, ageInList)));
	}
	
	@PostMapping
	public ResponseEntity<?> saveHomeless(@RequestBody HomelessPersonDto dto){
		HomelessPersonEntity entity = homelessModelMaper.dtoPersonToEntity(dto);
		HomelessPersonDto dtoHomeless = homelessModelMaper.entityToDtoPerson(homelessService.save(entity));
		return ResponseEntity.ok(dtoHomeless);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateById(@PathVariable(name = "id") Long id, @RequestBody HomelessPersonDto dto){
		HomelessPersonEntity entity = homelessModelMaper.dtoPersonToEntity(dto);
		return ResponseEntity.ok(homelessService.update(id, entity));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){
		homelessService.delete(id);
		return ResponseEntity.ok("successfully removed");
	}
	
}
	
