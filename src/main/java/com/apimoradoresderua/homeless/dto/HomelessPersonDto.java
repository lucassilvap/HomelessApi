package com.apimoradoresderua.homeless.dto;

public class HomelessPersonDto {
	
	private String name;
	
    private String currentSituation;
	
	private String addressWhereYouAre;
	
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
