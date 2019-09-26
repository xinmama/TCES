package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.ResultMsg;
import ssm.service.EvaluateService;

@Controller
public class EvaluateController {
	
	@Autowired
	private EvaluateService evaluateService;
	
	//访问学生评价页面
	@RequestMapping("/st_score")
	public ModelAndView st_score(){
		ModelAndView mView= new ModelAndView("evaluate/st_score");
		return mView;		
	}
	
	//访问教师评价页面
	@RequestMapping("/tt_score")
	public ModelAndView tt_score(){
		ModelAndView mView= new ModelAndView("evaluate/tt_score");
		return mView;		
	}
		
	//学生评价提交
	@RequestMapping("/st_score_submit")
	public ResultMsg st_score_submit(int score) {
			
		int st_scoreResult = evaluateService.InsertSt_score(score);
		
		if(st_scoreResult>0) {
			return new ResultMsg(1, "评价成功！");
		}else {
			return new ResultMsg(0, "评价失败！");
		}
	}
	
	//教师评价提交
	@RequestMapping("/tt_score_submit")
	public ResultMsg tt_score_submit(int score) {
				
		int st_scoreResult = evaluateService.InsertSt_score(score);
			
		if(st_scoreResult>0) {
			return new ResultMsg(1, "评价成功！");
		}else {
			return new ResultMsg(0, "评价失败！");
		}
	}
			
}
