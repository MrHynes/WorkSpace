package spring.listProperties;

import java.util.List;

public class person {
	private String name;
	List<Car> car;
	public void setName(String name) {
		this.name = name;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "person [name=" + name + ", car=" + car + "]";
	}
	public person(String name, List<Car> car) {
		super();
		this.name = name;
		this.car = car;
	}
	public person() {
		super();
	}
	
	

}
