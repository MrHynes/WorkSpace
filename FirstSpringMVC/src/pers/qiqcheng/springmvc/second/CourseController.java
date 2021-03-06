package pers.qiqcheng.springmvc.second;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/courses")
// /courses/**
public class CourseController {

	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	// 本方法将处理 /courses/view?courseId=123 形式的URL
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
		Course course = courseService.getCoursebyId(courseId);
		model.addAttribute(course);
		return "course_overview";
	}

	// 本方法将处理 /courses/view2/123.action 形式的URL
	@RequestMapping("/view2/{courseId}")
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
		Course course = courseService.getCoursebyId(courseId);
		model.put("course", course);
		return "course_overview";
	}
  
	// 本方法将处理 /courses/view3?courseId=123 形式的URL
	@RequestMapping("/view3")
	public String viewCourse3(HttpServletRequest request) {

		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		Course course = courseService.getCoursebyId(courseId);
		request.setAttribute("course", course);

		return "course_overview";
	}

	@RequestMapping(value="/admin", method = RequestMethod.GET, params = "add")
	public String createCourse(){
		return "edit";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String  doSave(@ModelAttribute Course course){		
		
		//在此进行业务操作，比如数据库持久化
		course.setCourseId(123);
		return "redirect:view2/"+course.getCourseId()+".action";
	}
}
