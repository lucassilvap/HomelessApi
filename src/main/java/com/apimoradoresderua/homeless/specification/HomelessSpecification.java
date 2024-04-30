package com.apimoradoresderua.homeless.specification;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;

public abstract class HomelessSpecification {

	private static Specification<HomelessPersonEntity> partByName(String partName){
	  return (root, cq, cb) -> cb.like(cb.upper(root.get("name")), "%"+ partName.toUpperCase() +"%"); 
		
	}
	
	private static Specification<HomelessPersonEntity> byCurrentSituation (String currentSituation){
	   return (root, cq, cb) -> cb.equal(cb.upper(root.get("currentSituation")), currentSituation.toUpperCase());
	}

	public static Specification<HomelessPersonEntity> spec(Optional<String> partName, Optional<String> currentSituation){
		Specification<HomelessPersonEntity> specification = Specification.where(null);
		
		if(partName.isPresent())
		specification = specification.and(partByName(partName.get()));
		
		if(currentSituation.isPresent())
		specification = specification.and(byCurrentSituation(currentSituation.get()));
		
		return specification;
	}
}
