package pers.qiqcheng.springmvc.second;

import org.springframework.stereotype.Service;


@Service
public interface CourseService {
	Course getCoursebyId(Integer courseId);
}
