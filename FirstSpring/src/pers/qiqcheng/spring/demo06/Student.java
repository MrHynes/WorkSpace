package pers.qiqcheng.spring.demo06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Student {
	@Value("stu")
	private String name;

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}
