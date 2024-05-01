package com.apimoradoresderua.homeless.dto;

import com.apimoradoresderua.homeless.entity.HomelessPersonEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParentsTelephoneDto {
	
    private Long id;
	
	private String number;
	
	private String name;
	
	@JsonIgnore
	private HomelessPersonEntity homelessPersonEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HomelessPersonEntity getHomelessPersonEntity() {
		return homelessPersonEntity;
	}
	
	public void setHomelessPersonEntity(HomelessPersonEntity homelessPersonEntity) {
		this.homelessPersonEntity = homelessPersonEntity;
	}
}
