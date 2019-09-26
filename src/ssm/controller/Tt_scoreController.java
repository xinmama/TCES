package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.ResultMsg;
import ssm.entity.Tt_score;
import ssm.service.Tt_scoreService;
import sun.print.resources.serviceui;

@Controller
public class Tt_scoreController {
	@Autowired
 private Tt_scoreService tt_scoreService;
 
	//1.访问老師分數管理首页
		@RequestMapping("/Tt_score")
		public ModelAndView Tt_score() {
			ModelAndView mv=new ModelAndView("tt_score/tt_score_list");
			List<Tt_score> tt_scores=tt_scoreService.getTt_score();
			for (Tt_score tt_score : tt_scores) {
				System.out.println("id1："+tt_score.getTeacher1_id()+"id2: "+tt_score.getTeacher2_id());
				System.out.println("评价老师姓名："+tt_score.getTeacher1().getTeacher_name());
				System.out.println("被评老师姓名："+tt_score.getTeacher2().getTeacher_name());
			}
			mv.addObject("tt_scores",tt_scores);
			return mv;
		}
		
		@RequestMapping("/deleteTt_scores")
		@ResponseBody
		public ResultMsg deleteTt_scores(int id) {
			int deleteResult= tt_scoreService.deleteTt_score(id);
			if(deleteResult>0) {
				return new ResultMsg(1,"刪除成功！");
			}
			else {
			return new ResultMsg(0,"刪除失敗！");
			}
			
		}
			
			
			
		
		
		
}
