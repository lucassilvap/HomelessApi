package com.apimoradoresderua.homeless.specification;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;
import com.apimoradoresderua.homeless.entity.ParentsTelephone;
public abstract class ParentsTelephoneSpecification {
	/*
	public static Specification <ParentsTelephone> byName(String name){
		  return (root, cq, cb) -> {
			  Join<ParentsTelephone, HomelessPersonEntity> pJoin = root.join("homelessPersonEntity");
					return cb.equal(pJoin.get("name"), name);
		  };
		  
	}
	*/
	public static Specification <ParentsTelephone> byName(String name){
		return (root,cq,cb) -> cb.equal(root.join("homelessPersonEntity").get("name"), name);
	}
	
	private static Specification<HomelessPersonEntity> ageBetween (int ageInitial, int ageFinaly){
		   return (root, cq, cb) -> cb.between(root.get("age"), ageInitial, ageFinaly);
	}
	
	public static Specification<ParentsTelephone> spec(Optional<String> name){
		Specification<ParentsTelephone> specification = Specification.where(null);
		if(name.isPresent())
			specification = specification.and(byName(name.get()));
		return specification;
	}
	
}
