package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Student;
import ssm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student_list")
	public ModelAndView list() {
		List<Student> students=studentService.selectStudent();
		ModelAndView mView = new ModelAndView("student/list");
		mView.addObject("students",students);
		return mView;
	}
}
