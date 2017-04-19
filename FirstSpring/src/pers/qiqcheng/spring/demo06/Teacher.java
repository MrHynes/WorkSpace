package pers.qiqcheng.spring.demo06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Teacher {
	@Value("name")
	private String name;

	@Override
	public String toString() {
		return "Teacher [name=" + name + "]";
	}

}
