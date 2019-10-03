package ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Manage;
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.service.ClassService;
import ssm.service.LoginService;
import ssm.service.StudentService;
import ssm.util.Md5;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	private ClassService classService; 
	
	@RequestMapping("/login")
	public ModelAndView login() {	
		ModelAndView mv = new ModelAndView("login/login");		
		return mv;
	}
	
	@RequestMapping("/login_submit")
	public ModelAndView login_submit(String username,String password,HttpServletRequest request) {
		Manage manage = new Manage();
		System.out.println("........................................................");
		manage.setUsername(username);
		manage.setPassword(password);
		
		Student student = new Student();
		student.setStudent_no(username);
		String studentPasswordByMd5 = Md5.MD5(password);
		student.setStudent_pwd(studentPasswordByMd5);
		
		Teacher teacher = new Teacher();
		teacher.setTeacher_no(username);
		String teacherPasswordByMd5 = Md5.MD5(password);
		teacher.setTeacher_pwd(teacherPasswordByMd5);
		
		int selectResultManage = loginService.selectManage(manage);//判断是否是管理员
		if(selectResultManage==1) {//如果是
			int getResultManage = loginService.getManage(manage);//判断是否正确
			if(getResultManage==1)//如果正确
			{
				ModelAndView mv = new  ModelAndView("index/manage");
				HttpSession session = request.getSession(true); 
				session.setAttribute("user",manage);
				
				return mv;
			}else {//如果不正确
				ModelAndView mv = new  ModelAndView("login");
				return mv;
			}
				
		}else {//如果不是
			int selectResultStudent = loginService.selectStudent(student);//判断是否是学生
			if(selectResultStudent==1) {//如果是
				int getResultStudent = loginService.getStudent(student);//判断是否正确
				if(getResultStudent==1)//如果正确
				{
					ModelAndView mv = new  ModelAndView("index/show_student");
					HttpSession session = request.getSession(true); 
													
					Student student1=loginService.getInfoByStudentno(username);
					session.setAttribute("user",student1);
					mv.addObject("student1", student1);								
					return mv;
				}else {//如果不正确
					ModelAndView mv = new  ModelAndView("login");
					return mv;
				}
					
			}else {//如果不是
				int selectResultTeacher = loginService.selectTeacher(teacher);//判断是否是教师
				if(selectResultTeacher==1) {//如果是
					int getResultTeacher = loginService.getTeacher(teacher);//判断是否正确
					if(getResultTeacher==1)//如果正确
					{
						ModelAndView mv = new  ModelAndView("index/show_teacher");
						HttpSession session = request.getSession(true); 
						
						Teacher teacher1=loginService.getInfoByTeacherno(username);
						session.setAttribute("user",teacher1);
						mv.addObject("teacher1", teacher1);						
						return mv;
					}else {//如果不正确
						ModelAndView mv = new  ModelAndView("login");
						return mv;
					}
						
				}else {
					ModelAndView mv = new  ModelAndView("login");
					return mv;
				}
			}
		}
	}
	
	//退出
	@RequestMapping("/exit")
	public ModelAndView exit(HttpServletRequest request) {	
		//退出session
		HttpSession session = request.getSession(true);
	
		session.removeAttribute("user");
		
		ModelAndView mv = new ModelAndView("login/login");		
		return mv;
	}
	
	//学生返回首页
	@RequestMapping("/ReturnStudentIndex")
	public ModelAndView ReturnStudentIndex(HttpServletRequest request) {	
		ModelAndView mv = new  ModelAndView("index/show_student");
		HttpSession session = request.getSession(true); 
		Student student=(Student)session.getAttribute("user");
										
		Student student1=loginService.getInfoByStudentno(student.getStudent_no());
		mv.addObject("student1", student1);		
		return mv;
	}
	
	//教师返回首页
	@RequestMapping("/ReturnTeacherIndex")
	public ModelAndView ReturnTeacherIndex(HttpServletRequest request) {	
		ModelAndView mv = new  ModelAndView("index/show_teacher");
		HttpSession session = request.getSession(true); 
		Teacher teacher=(Teacher)session.getAttribute("user");
		
		Teacher teacher1=loginService.getInfoByTeacherno(teacher.getTeacher_no());
		session.setAttribute("user",teacher1);
		mv.addObject("teacher1", teacher1);						
		return mv;
	}	
	
	
	
}
