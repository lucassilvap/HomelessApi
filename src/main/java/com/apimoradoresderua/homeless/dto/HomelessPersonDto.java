package com.apimoradoresderua.homeless.dto;

import java.util.List;

import com.apimoradoresderua.homeless.entity.ParentsTelephone;

public class HomelessPersonDto {
	
	private String name;
	
    private String currentSituation;
	
	private String addressWhereYouAre;
	
	private List<ParentsTelephone> parentsTelephones;
	
	private int age;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCurrentSituation() {
		return currentSituation;
	}
	
	public void setCurrentSituation(String currentSituation) {
		this.currentSituation = currentSituation;
	}
	
	public String getAddressWhereYouAre() {
		return addressWhereYouAre;
	}
	
	public void setAddressWhereYouAre(String addressWhereYouAre) {
		this.addressWhereYouAre = addressWhereYouAre;
	}
	
	public List<ParentsTelephone> getParentsTelephones() {
		return parentsTelephones;
	}
	
	public void setParentsTelephones(List<ParentsTelephone> parentsTelephones) {
		this.parentsTelephones = parentsTelephones;
	}
}
