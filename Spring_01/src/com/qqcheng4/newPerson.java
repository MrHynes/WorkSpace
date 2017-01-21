package com.qqcheng4;

import java.util.List;
import java.util.Map;

public class newPerson {
	private String personOfName;
	private double ageOfPerson;
	private Map<List, Car> car;
	
	public newPerson() {
		super();
	}

	public void setPersonOfName(String personOfName) {
		this.personOfName = personOfName;
	}
	
	public void setAgeOfPerson(double ageOfPerson) {
		this.ageOfPerson = ageOfPerson;
	}
	public void setCar(Map<List, Car> car) {
		this.car = car;
	}

	public newPerson(String personOfName, double ageOfPerson, Map<List, Car> car) {
		super();
		this.personOfName = personOfName;
		this.ageOfPerson = ageOfPerson;
		this.car = car;
	}

	@Override
	public String toString() {
		return "newPerson [personOfName=" + personOfName + ", ageOfPerson=" + ageOfPerson + ", car=" + car + "]";
	}
	

	
}
