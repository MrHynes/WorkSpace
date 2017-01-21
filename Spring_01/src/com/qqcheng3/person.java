package com.qqcheng3;

public class person {
	private String nameOfPerson;
	private int ageOfPerson;
	car carOfPerson;
	
	public person() {
		super();
	}

	public void setNameOfPerson(String nameOfPerson) {
		this.nameOfPerson = nameOfPerson;
	}

	public void setAgeOfPerson(int ageOfPerson) {
		this.ageOfPerson = ageOfPerson;
	}

	public void setCarOfPerson(car carOfPerson) {
		this.carOfPerson = carOfPerson;
	}

	public person(String nameOfPerson, int ageOfPerson, car carOfPerson) {
		super();
		this.nameOfPerson = nameOfPerson;
		this.ageOfPerson = ageOfPerson;
		this.carOfPerson = carOfPerson;
	}

	@Override
	public String toString() {
		return "person [nameOfPerson=" + nameOfPerson + ", ageOfPerson=" + ageOfPerson + ", carOfPerson=" + carOfPerson
				+ "]";
	}
	
	
}
