package com.wipro.jersey.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private long id;
	private String name;
	private String joiningDate;
	private String countryCode;
	private String countryName;
	

	public User() {
		
	}
	

	public User(long id, String name, String joiningDate, String countryCode) {
		super();
		this.id = id;
		this.name = name;
		this.joiningDate = joiningDate;
		this.countryCode = countryCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	

}
