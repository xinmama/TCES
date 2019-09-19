package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Classes;
import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.service.ClassService;

@Controller

public class ClassController {

	@Autowired
	private ClassService classService;
	
	
	//1.访问班级管理首页
	@RequestMapping("/class_list")
	public ModelAndView class_index() {
		ModelAndView mv=new ModelAndView("classes/class_list");
		List<Classes> classes=classService.getClasses();
		mv.addObject("classes",classes);
		return mv;
	}
	

	
	//2.访问班级管理（添加）页面
	@RequestMapping("/class_add")
	public ModelAndView class_add() {
		ModelAndView mv=new ModelAndView("classes/class_add");
		List<Department> depname=classService.getDepartment();
		mv.addObject("depname",depname);
		return mv;
	}
	
	//3.访问班级管理（修改）页面 
	@RequestMapping("/class_update")
	public ModelAndView class_update(int id) {	
		ModelAndView mv=new ModelAndView("classes/class_update");
		Classes classes=classService.selectClassesById(id);
		List<Department> department=classService.getDepartment();
		
		mv.addObject("department", department);
		mv.addObject("classes", classes);
		return mv;
	}
	

	//4.添加班级
	@ResponseBody
	@RequestMapping("/add_class")
	public ResultMsg add_class(int dep_id,String classes_no) {
		System.out.println(classes_no);
		
		int i=classService.selectClassesByClassNo(classes_no);

		if(i==1) {
			return new ResultMsg(0, "该班级已存在，请重新添加！");
		}else {
			Classes classes= new Classes();
			classes.setClasses_no(classes_no);
			classes.setDep_id(dep_id);
			int j=classService.addClasses(classes);
			if(j>0) {
				return new ResultMsg(1, "添加成功！");
			}else {
				return new ResultMsg(0, "添加失败！");
			}
			
		}
		
	}
	
	//5.修改班级信息
	@ResponseBody
	@RequestMapping("/update_class")
	
	public ResultMsg update_class(Classes classes) {

		System.out.println("id:"+classes.getId());
		System.out.println("班级号："+classes.getClasses_no());
		System.out.println("部门号:"+classes.getDep_id());
		
		int l=classService.selectClassesAll(classes);
				
		if(l>0) {
			return new ResultMsg(0,"该班级已存在，请勿重复操作。");
		}else {
			int k=classService.updateClasses(classes);
			if(k>0) {
				return new ResultMsg(1,"修改成功！");
			}else {
				return new ResultMsg(0,"修改失败！");
			}
		}
		
	}
	
	//6.删除班级
	@ResponseBody
	@RequestMapping("/delete_class")
	public ResultMsg deleteClasses(int id) {
		int m=classService.deleteClasses(id);
		if(m>0) {
			return new ResultMsg(1,"删除成功！");
		}else {
			return new ResultMsg(0,"删除失败！");
		}
	}
	
}
