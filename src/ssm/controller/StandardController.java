package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.dao.StandardDao;
import ssm.entity.ResultMsg;
import ssm.entity.Standard;

@Controller
public class StandardController {
	
	@Autowired
	private StandardDao standardDao;

	//显示列表页面
	@RequestMapping("/standart_list")
	public ModelAndView list() {
		
		List<Standard> standards = standardDao.selectStandart();
		ModelAndView mv=new ModelAndView("standard/list");
		mv.addObject("standards", standards);
		return mv;
	}
	
	//显示添加页面
	@RequestMapping("/standard_add")
	public ModelAndView add() {
		ModelAndView mv=new ModelAndView("standard/add");
		
		return mv;
	}
	
	//执行添加操作
	public ResultMsg add_standard() {
		return null;
	}
	
}
