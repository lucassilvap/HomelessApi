package com.apimoradoresderua.homeless.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HomelessPersonEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	private String name;
	
	private String currentSituation;
	
	private String addressWhereYouAre;
	
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
}
