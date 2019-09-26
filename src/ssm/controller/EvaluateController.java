package ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.entity.Teacher_course;
import ssm.service.EvaluateService;

@Controller
public class EvaluateController {

	@Autowired
	private EvaluateService evaluateService;
	
	
	//1.访问学生评教列表页面
	@RequestMapping("/st_evaluate_list")
	public ModelAndView st_evaluate_list(HttpServletRequest request) {
		ModelAndView mView=new ModelAndView("evaluate/st_evaluate_list");
		
		HttpSession session = request.getSession(true); 
		Student student=(Student)session.getAttribute("user");
		
		System.out.println(student.getStudent_no());
		
		List<Teacher_course> st_list=evaluateService.selectCourseTeacherByNo(student.getClasses().getClasses_no());
		for (Teacher_course teacher_course : st_list) {
			System.out.println("课程名："+teacher_course.getCourse().getCourse_name());
			System.out.println("教师名："+teacher_course.getTeacher().getTeacher_name());
		}
		
		
		
		mView.addObject("st_list", st_list);
		return mView;
	}
	
	
	
	//2.访问教师评教列表页面
	@RequestMapping("/tt_evaluate_list")
	public ModelAndView tt_evaluate_list(HttpServletRequest request) {
		ModelAndView mView=new ModelAndView("evaluate/tt_evaluate_list");
		
		HttpSession session = request.getSession(true); 
		Teacher teacher=(Teacher)session.getAttribute("user");
		
		System.out.println(teacher.getTeacher_no());
		System.out.println(teacher.getDepartment().getId());
		
		List<Teacher_course> tt_list=evaluateService.selectCourseTeacherByDepid(teacher.getDepartment().getId());
		
		System.out.println("111111111111");
		for (Teacher_course teacher_course : tt_list) {
			System.out.println("2222222222222");
			System.out.println("课程名："+teacher_course.getCourse().getCourse_name());
			System.out.println("教师名："+teacher_course.getTeacher().getTeacher_name());
		}
		
		mView.addObject("tt_list", tt_list);
		return mView;
	}
}
