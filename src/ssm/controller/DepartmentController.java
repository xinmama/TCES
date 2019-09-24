package ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xpath.internal.operations.Mod;

import javafx.scene.control.Alert;
import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//显示列表页面
	@RequestMapping("/department_list")
	public ModelAndView list() {
		
		List<Department> departments = departmentService.selectDepartment();
		
		ModelAndView mView = new ModelAndView("department/list");
		mView.addObject("departments",departments);
		return mView;
	}
	
	//显示添加页面
	@RequestMapping("/department_add")
	public ModelAndView add() {
		ModelAndView mView = new ModelAndView("department/add");
		return mView;
	}
	
	//执行添加操作
	@RequestMapping("/add_department")
	@ResponseBody
	public ResultMsg add_department(String dep_name) {
		
		int selectResult = departmentService.selectDepartmentByName(dep_name);
		
		if(selectResult==1) {
			return new ResultMsg(-1,"院系名称已存在，请重新输入！");
		}else {
			int addResult = departmentService.addDepartment(dep_name);
			
			if(addResult>0) {
				return new ResultMsg(1, "添加信息成功！");
			}else {
				return new ResultMsg(0, "添加信息失败！");
			}
		}
		
	}
	
	//显示修改页面
	@RequestMapping("/department_update")
	public ModelAndView department_update(int id) {
		ModelAndView mView = new ModelAndView("department/update");
		Department department = departmentService.selectDepartmentById(id);
		mView.addObject("department", department);
		return mView;
	}
	
	//执行修改操作
	@RequestMapping("/update_department")
	@ResponseBody
	public ResultMsg update_department(Department department) {
		int selectResult = departmentService.selectDepartmentByName(department.getDep_name());
			
		if(selectResult==1) {
			return new ResultMsg(-1,"院系名称已存在，请重新输入！");
		}else {
			int updateResult = departmentService.updateDepartmentById(department);
				
			if(updateResult>0) {
				return new ResultMsg(1, "修改信息成功！");
			}else {
				return new ResultMsg(0, "修改信息失败！");
			}
		}
			
	}
	
	//执行删除操作
	@ResponseBody
	@RequestMapping("delete_department")
	public ResultMsg delete_department(int id) {	
		int deleteResult = departmentService.deleteDepartmentById(id);
		
		if(deleteResult>0) {
			return new ResultMsg(1, "删除信息成功！");
		}else {
			return new ResultMsg(0, "删除信息失败！");
		}
	}
		
	
}
