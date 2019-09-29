package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Show_scoreController {

	@RequestMapping("/show_st_score")
	public ModelAndView show_st_score() {
		ModelAndView mView=new ModelAndView("show_score/show_st_score");
		return mView;
	}
}
