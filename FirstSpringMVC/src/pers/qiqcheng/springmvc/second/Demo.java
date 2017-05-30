package pers.qiqcheng.springmvc.second;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mvc")
public class Demo {
	@RequestMapping("/demo")
	public String test(){
		return "home";
		//此方式，配置视图解析器需要<property name="prefix" value="/"></property>
		//<property name="suffix" value=".jsp"></property>
	}
}
