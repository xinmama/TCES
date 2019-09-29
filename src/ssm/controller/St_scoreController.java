package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.ResultMsg;
import ssm.entity.St_score;
import ssm.service.St_scoreService;


@Controller
public class St_scoreController {

	@Autowired
	private St_scoreService scoreService;
	
	
	@RequestMapping("/st_score")
	public ModelAndView st_score() {
		List<St_score> st_scores=scoreService.selectSt_score();
		ModelAndView mView = new ModelAndView("st_score/st_score");
		mView.addObject("st_scores",st_scores);
		return mView;
	}
	
	
	@RequestMapping("/delete_st_score")
	@ResponseBody
	public ResultMsg delete_st_score(int id) {
		int deleteResult=scoreService.deleteSt_score(id);
		if(deleteResult>0) {
			return new ResultMsg(1, "ɾ��������¼�ɹ�!");
		}else {
			return new ResultMsg(0, "ɾ��������¼ʧ��!");
		}
	}
}

