package com.qqcheng4;

import java.util.List;

public class Person {
	private String personOfName;
	private double ageOfPerson;
	private List<Car> car;
	public Person() {
		super();
	}
	
	public void setPersonOfName(String personOfName) {
		this.personOfName = personOfName;
	}
	
	public void setAgeOfPerson(double ageOfPerson) {
		this.ageOfPerson = ageOfPerson;
	}
	
	@Override
	public String toString() {
		return "Person [personOfName=" + personOfName + ", ageOfPerson=" + ageOfPerson + ", car=" + car + "]";
	}


	public void setCar(List<Car> car) {
		this.car = car;
	}

	public Person(String personOfName, double ageOfPerson, List<Car> car) {
		super();
		this.personOfName = personOfName;
		this.ageOfPerson = ageOfPerson;
		this.car = car;
	}

	

}
