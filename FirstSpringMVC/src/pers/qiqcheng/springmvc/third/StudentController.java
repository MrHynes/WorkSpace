package pers.qiqcheng.springmvc.third;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService studentService;
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@RequestMapping("/getstu")
	public String view(Model model){
		StudentModel studentModel=studentService.getStudent();
		model.addAttribute(studentModel);
		return "student";
	}
	// /students/getstu.action?name=xx
	@RequestMapping(value="/getstu1",method=RequestMethod.GET)
	public String view2(Model model,@RequestParam("name")String name){
		StudentModel studentModel=studentService.getStudent();
		studentModel.setName(name);
		model.addAttribute(studentModel);
		return "student";
	}
	
	// /students/getstu/{name}.action
	@RequestMapping(value="/getstu2/{name}")
	public String view3(Map<String, Object> model,@PathVariable("name")String name){
		StudentModel studentModel=studentService.getStudent();
		studentModel.setName(name);
		model.put("studentModel", studentModel);
		return "student";
	}
	// /students/getstu3.action
	@RequestMapping("/getstu3")
	public String view4(HttpServletRequest request){
		StudentModel studentModel=studentService.getStudent();
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		session.setAttribute("hello", name);
		request.setAttribute("studentModel", studentModel);
		return "student";  
	}

}
