package com.wipro.jersey.model;

public class RestCountries {
	
	private String name;

	public RestCountries(){
		
	}
	
	public RestCountries(String name) {
		this.name= name;
	}
	
	public String getCountryName() {
		return name;
	}

	public void setCountryName(String countryName) {
		this.name = countryName;
	}
	
	

}
