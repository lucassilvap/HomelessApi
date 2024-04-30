package com.apimoradoresderua.homeless.specification;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;
import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;

public abstract class HomelessSpecification {

	private static Specification<HomelessPersonEntity> partByName(String partName){
	  return (root, cq, cb) -> cb.like(cb.upper(root.get("name")), "%"+ partName.toUpperCase() +"%"); 
	}
	
	private static Specification<HomelessPersonEntity> inListOfAge(List<Integer> list){
		return (root, cq, cb) -> root.get("age").in(list);
	}
	
	private static Specification<HomelessPersonEntity> byCurrentSituation(String currentSituation){
		   return (root, cq, cb) -> cb.equal(cb.upper(root.get("currentSituation")), currentSituation.toUpperCase());
	}
	
	private static Specification<HomelessPersonEntity> ageGreaterThan (int age){
		   return (root, cq, cb) -> cb.greaterThan(root.get("age"), age);
	}
	
	private static Specification<HomelessPersonEntity> ageBetween (int ageInitial, int ageFinaly){
		   return (root, cq, cb) -> cb.between(root.get("age"), ageInitial, ageFinaly);
	}
		
	public static Specification<HomelessPersonEntity> spec(Optional<String> partName, 
		Optional<String> currentSituation,
		Optional<Integer> age, 
		Optional<List<Integer>> ageBetween, 
		Optional<List<Integer>> ageInList){
		
		Specification<HomelessPersonEntity> specification = Specification.where(null);
		
		if(partName.isPresent())
		specification = specification.and(partByName(partName.get()));
		
		if(currentSituation.isPresent())
		specification = specification.and(byCurrentSituation(currentSituation.get()));
		
		if(age.isPresent())
		specification = specification.and(ageGreaterThan(age.get()));
		
		if(ageBetween.isPresent())	
		specification = specification.and(ageBetween(ageBetween.get().get(0), ageBetween.get().get(1)));
		
		if(ageInList.isPresent()) {
			specification = specification.and(inListOfAge(ageInList.get()));
		}
		
		return specification;
	}

	
}
