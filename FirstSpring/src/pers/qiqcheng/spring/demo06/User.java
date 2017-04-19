package pers.qiqcheng.spring.demo06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
	@Value("name")
	private String name;

}
