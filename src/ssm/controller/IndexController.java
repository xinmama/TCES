package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	//登录进来的首页访问
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	//访问学生目录页面
	@RequestMapping("/student_ml")
	public ModelAndView student_ml() {
		ModelAndView mView=new ModelAndView("index/student");
		return mView;
	}
	
	//访问教师目录页面
	@RequestMapping("/teacher_ml")
	public ModelAndView teacher_ml() {
		ModelAndView mView=new ModelAndView("index/teacher");
		return mView;
	}
}
