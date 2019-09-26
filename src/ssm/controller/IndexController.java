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
}
