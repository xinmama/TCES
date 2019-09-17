package ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javafx.scene.control.Alert;
import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/department_list")
	public ModelAndView list() {
		
		List<Department> departments = departmentService.selectDepartment();
		
		ModelAndView mView = new ModelAndView("department/list");
		mView.addObject("departments",departments);
		return mView;
	}
	
	@RequestMapping("/department_add")
	public ModelAndView add() {
		ModelAndView mView = new ModelAndView("department/add");
		return mView;
	}
	
	@RequestMapping("/add_department")
	@ResponseBody
	public ResultMsg add_department(String dep_name) {
		
		int selectResult = departmentService.selectDepartmentByName(dep_name);
		
		if(selectResult==1) {
			return new ResultMsg(-1,"院系名称已存在，请重新输入！");
		}else {
			int addResult = departmentService.addDepartment(dep_name);
			
			if(addResult>0) {
				System.out.println("添加信息成功！");
				return new ResultMsg(1, "添加信息成功！");
			}else {
				System.out.println("添加信息失败！");
				return new ResultMsg(0, "添加信息失败！");
			}
		}
		
	}
	
}
