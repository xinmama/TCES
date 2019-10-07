package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javafx.scene.control.TextFormatter;
import ssm.entity.Course;
import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.entity.Term;
import ssm.service.TermService;

@Controller
public class TermController {
	
	@Autowired
	private TermService termService;

	//1.访问学期管理界面，并展示
	@RequestMapping("/term_list")
	public ModelAndView term_list() {
		ModelAndView mView=new ModelAndView("term/term_list");
		List<Term> term=termService.getTerm();
		mView.addObject("term",term);
		return mView;
	}
	

	//2.访问学期管理（添加）界面
	@RequestMapping("/term_add")
	public ModelAndView term_add() {
		ModelAndView mv=new ModelAndView("term/term_add");
			return mv;
	}
	
	//3.添加学期
	@ResponseBody
	@RequestMapping("/add_term")
	public ResultMsg add_term(Term term) {	
		int termResult=termService.selectTermByTermname(term.getTerm_name());
		if(termResult==1) {
			return new ResultMsg(0, "该学期已存在，请重新添加！");
		}else {
			int termResult1=termService.addTerm(term);
				if(termResult1>0) {
					return new ResultMsg(1, "添加成功！");
				}else {
					return new ResultMsg(0, "添加失败！");
				}		
			}				
	}

	
	//4.访问学期管理（修改）页面 
	@RequestMapping("/term_update")
	public ModelAndView term_update(int id) {	
		ModelAndView mv=new ModelAndView("term/term_update");			
		Term term=termService.selectTermById(id);
		mv.addObject("term", term);
		return mv;
	}
		
	
	//5.修改学期信息
	@RequestMapping("/update_term")	
	@ResponseBody
	public ResultMsg update_term(Term term) {
		int j=termService.updateTerm(term);
		if(j>0) {
			return new ResultMsg(1, "修改成功！");
		}else {
			return new ResultMsg(0, "修改失败！");
		}
		
	}
	
	//6.删除学期信息
	@ResponseBody
	@RequestMapping("/delete_term")
	public ResultMsg delete_term(int id) {
		int k=termService.deleteTerm(id);
		if(k>0) {
			return new ResultMsg(1,"删除成功！");		
		}else {
			return new ResultMsg(0,"删除失败！");	
		}
	}
	
	@RequestMapping("/isCurrAppraiseList")
	public ModelAndView isCurrAppraiseList() {
		ModelAndView mView = new ModelAndView("term/isCurrAppraise");
		List<Term> terms = termService.selectTerms();
		mView.addObject("terms",terms);
		return mView;
	}
	
	@RequestMapping("/CurrAppraise")
	@ResponseBody
	public ResultMsg CurrAppraise(Integer id,Integer is_open) {
		System.out.println(id);
		System.out.println(is_open);
		
		if(id==null||is_open==null) {

			System.out.println("内容不能为空！");
			return new ResultMsg(6, "内容不能为空！");
		}
		
		if(is_open==1) {

			int isCurrAppraise1 = termService.selectIsCurrAppraise();	
			if(isCurrAppraise1==1) {
				
				int isCurrAppraise2 = termService.selectIsCurrAppraiseById(id);
				if (isCurrAppraise2==1) {
					System.out.println("该学期评价已开启！");
					return new ResultMsg(2, "该学期评价已开启！");
				}else {
					System.out.println("开启失败，已存在评价开启！");
					return new ResultMsg(3, "开启失败，已存在评价开启！");
				}
			}else {

				Term term = new Term();
				term.setId(id);
				term.setIs_open(is_open);
				int isCurrAppraise3 = termService.updateIsCurrAppraise(term);
				
				if (isCurrAppraise3>0) {
					System.out.println("开启成功！");
					return new ResultMsg(1, "开启成功！");
				}else {
					System.out.println("开启失败！");
					return new ResultMsg(4, "开启失败！");
				}
			}
			
		}else{
			Term term = new Term();
			term.setId(id);
			term.setIs_open(is_open);
			int isCurrAppraise1 = termService.updateIsCurrAppraise(term);
			
			if (isCurrAppraise1>0) {
				System.out.println("关闭成功！");
				return new ResultMsg(0, "关闭成功！");
			}else {
				System.out.println("关闭失败！");
				return new ResultMsg(5, "关闭失败！");
			}
		}
		
	}
	
}
