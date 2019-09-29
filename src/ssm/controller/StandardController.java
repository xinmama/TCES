package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.dao.StandardDao;
import ssm.entity.ResultMsg;
import ssm.entity.Standard;
import ssm.service.StandardService;
import ssm.service.TeacherService;

@Controller
public class StandardController {
	
	@Autowired
	private StandardService standardService;

	//显示评价指标列表页面
	@RequestMapping("/standart_list")
	public ModelAndView list() {
		List<Standard> standards = standardService.selectStandard();
		ModelAndView mv=new ModelAndView("standard/list");
		mv.addObject("standards", standards);
		return mv;
	}
	
	//显示评价指标添加页面
	@RequestMapping("/standard_add")
	public ModelAndView add() {
		ModelAndView mv=new ModelAndView("standard/add");
		return mv;
	}
	
	//执行评价指标添加操作
	@ResponseBody
	@RequestMapping("/add_standard")
	public ResultMsg add_standard(Standard standard) {
		//查询评价指标是否存在
		int i=standardService.selectStandardById(standard.getTitle_con());
		if(i==1) {
			return  new ResultMsg(-1, "该选项指标已存在，请重新输入！");
		}else {
			int j=standardService.addStandard(standard);
			if(j>0) {
				return new ResultMsg(1,"添加评价指标成功！");
			}else {
				return new ResultMsg(0,"添加评价指标失败！");
			}
		}
	}
	
	//显示评价指标修改页面
	@RequestMapping("/standard_update")
	public ModelAndView standard_update(int id) {
		ModelAndView mv=new ModelAndView("standard/update");
		Standard standard=standardService.selectStandardByid(id);
		mv.addObject("standard", standard);
		return mv;
	}
	
	//执行评价指标修改页面
	@RequestMapping("/update_standard")
	@ResponseBody
	public ResultMsg update_standard(Standard standard) {
		int i=standardService.selectStandardById(standard.getTitle_con());
		if(i==1) {
			return new ResultMsg(-1,"该评价指标已存在！");
		}else {
			int j=standardService.updateStandardById(standard);
			if(j>0) {
				System.out.print(j);
				return new ResultMsg(1,"修改信息成功！");
			}else {
				return new ResultMsg(0,"修改信息失败！");
			}
		}
	}
	
	//删除评价指标信息
	@RequestMapping("/delete_standard")
	@ResponseBody
	public ResultMsg  delete_standard(int id) {
		int i=standardService.deleteStandardById(id);
		if(i>0) {
			return new ResultMsg(1,"删除信息成功！");
		}else {
			return new ResultMsg(0,"删除信息失败！");
		}
	}
	
}


