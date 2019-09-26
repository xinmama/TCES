package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowController {

	@RequestMapping("/show_student")
	public ModelAndView show_student() {
		ModelAndView mv=new ModelAndView("index/show_student");
		return mv;
	}
	
	@RequestMapping("/show_teacher")
	public ModelAndView show_teacher() {
		ModelAndView mv=new ModelAndView("index/show_teacher");
		return mv;
	}
}
