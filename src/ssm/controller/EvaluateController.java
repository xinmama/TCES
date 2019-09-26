package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EvaluateController {

	@RequestMapping("/")
	public ModelAndView st_list() {
		ModelAndView mView=new ModelAndView("evaluate/evluate_list");
		return mView;
	}
}
