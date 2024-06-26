package com.apimoradoresderua.homeless.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;
import com.apimoradoresderua.homeless.exception.AgeBetwennMustBeWithTwotFoundException;
import com.apimoradoresderua.homeless.exception.HomelessNotFoundException;
import com.apimoradoresderua.homeless.exception.NameMustBeUniqueException;
import com.apimoradoresderua.homeless.pageOptions.PageCreate;
import com.apimoradoresderua.homeless.repository.HomelessRepository;
import com.apimoradoresderua.homeless.specification.HomelessSpecification;

@Service
public class HomelessService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomelessService.class);
	
	@Autowired
	private HomelessRepository homelessRepository;
	
	@Autowired
	private PageCreate pageCreate;
	
	public HomelessPersonEntity save(HomelessPersonEntity entity) {
		Optional<HomelessPersonEntity> optional = homelessRepository.findByNameIgnoreCase(entity.getName());
		if (optional.isPresent()) throw new NameMustBeUniqueException();
		logger.info("homeless person successfully created!");
		return homelessRepository.save(entity);
	}
	
	public HomelessPersonEntity findById(Long id) {
		Optional<HomelessPersonEntity> optional = homelessRepository.findById(id);
		if (!optional.isPresent()) throw new HomelessNotFoundException();
		logger.info("homeless person successfully found!");
		return optional.get();
	}
	
	 public Page<HomelessPersonEntity> findALLHomeless(Optional<String> partName, Optional<Integer> page, Optional<Integer> size, 
		 Optional<String> currentSituation, Optional<Integer> age, Optional<List<Integer>> ageBetween, Optional<List<Integer>> ageInList) {
		 ageBetweenIsValid(ageBetween);
		 Page<HomelessPersonEntity> homelessPage = homelessRepository.findAll(
		 HomelessSpecification.spec(partName,currentSituation, age, ageBetween, ageInList), pageCreate.build(page,size));
		 
		 if (!homelessPage.isEmpty())
		 logger.info("homeless person successfully found!");
	     return homelessPage;
	 }
	 
	 private void ageBetweenIsValid(Optional<List<Integer>> ageOptional) {
			if(ageOptional.isPresent()) {
				if (ageOptional.get().size() == 2) {
					logger.info("validation in ageBetween sucessfully");
			        return; 		
				}else {
					throw new AgeBetwennMustBeWithTwotFoundException();
				}
			}
	 }

	public List<HomelessPersonEntity> findALLHomelessDefault() {
		return homelessRepository.findAll(Specification.where(null));
	}

	public void delete(Long id) {
		HomelessPersonEntity homeOptional = findById(id);
		homelessRepository.delete(homeOptional);
	}

	public HomelessPersonEntity update(Long id, HomelessPersonEntity entityUpdate) {
		HomelessPersonEntity homelessPersonEntity = findById(id);
		entityUpdate.setId(homelessPersonEntity.getId());
		return homelessRepository.save(entityUpdate);
	}
}
