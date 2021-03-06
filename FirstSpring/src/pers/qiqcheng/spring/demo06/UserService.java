package pers.qiqcheng.spring.demo06;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserService {
	@Autowired
	@Qualifier("student")
	private Student student;
	@Resource(name="teacher")
	private Teacher teacher;
	@Override
	public String toString() {
		return "UserService [student=" + student.toString() + ", teacher=" + teacher.toString() + "]";
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
