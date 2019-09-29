package ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.St_score;
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.entity.Tt_score;
import ssm.service.EvaluateService;
import ssm.service.Show_scoreService;

@Controller
public class Show_scoreController {
	
	@Autowired
	private Show_scoreService scoreService;

	@RequestMapping("/show_st_score")
	public ModelAndView show_st_score(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true); 
		Student student=(Student)session.getAttribute("user");
		
		ModelAndView mView=new ModelAndView("show_score/show_st_score");
		List<St_score> scores = scoreService.selectSt_scoreById(student.getId());
		mView.addObject("scores", scores);
		return mView;
	}
	
	@RequestMapping("/show_tt_score")
	public ModelAndView show_tt_score(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true); 
		Teacher teacher=(Teacher)session.getAttribute("user");
		
		ModelAndView mView=new ModelAndView("show_score/show_tt_score");
		List<Tt_score> scores = scoreService.selectTt_scoreById(teacher.getId());
		mView.addObject("scores", scores);
		return mView;
	}
}
