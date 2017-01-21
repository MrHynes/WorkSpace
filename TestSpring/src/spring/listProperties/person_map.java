package spring.listProperties;

import java.util.List;
import java.util.Map;

public class person_map {
	private String name;
	Map<String,Car> car;
	public void setName(String name) {
		this.name = name;
	}
	public void setCar(Map<String, Car> car) {
		this.car = car;
	}
	public person_map() {
		super();
	}
	@Override
	public String toString() {
		return "person_map [name=" + name + ", car=" + car + "]";
	}
	
}
