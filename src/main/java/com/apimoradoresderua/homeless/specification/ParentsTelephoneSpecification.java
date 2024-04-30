package com.apimoradoresderua.homeless.specification;

import org.springframework.data.jpa.domain.Specification;
public abstract class ParentsTelephoneSpecification {
	
	private static Specification<ParentsTelephoneSpecification> partByName(String number){
		/*
		  return (root, cq, cb) -> cb.like(cb.upper(root.get("name")), "%"+ partName.toUpperCase() +"%"); 
		  */
		return null;
	}
}
