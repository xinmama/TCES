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
import ssm.entity.Teacher;
import ssm.service.TeacherService;
import ssm.util.Md5;

@Controller
public class TeacherController {
	
	@Autowired
	public TeacherService teacherService;
	
	
	//查询
	@RequestMapping("/teacher_list")
	public ModelAndView teacherSelect() {
		ModelAndView mv=new ModelAndView("teacher/list");
		List<Teacher> teachers=teacherService.getTeacher();
		mv.addObject("teachers",teachers);
		return mv;
	}

	//访问教师管理添加页面
			@RequestMapping("/teacher_add")
			public ModelAndView teacher_add() {
				ModelAndView mv=new ModelAndView("teacher/add");
				List<Department> depname=teacherService.getDepartment();
				mv.addObject("depname",depname);
				return mv;
			}
	
	//添加教师
	@ResponseBody
	@RequestMapping("/add_teacher")
	public ResultMsg add_teacher(Teacher teacher) {
		//判断教师是否存在
		int i= teacherService.selectTeacherByTeacherNo(teacher.getTeacher_no());
		if(i==1) {
			return new ResultMsg(-1,"该教师信息已存在，请重新输入！");
		}else{
			String passwordByMd5 = Md5.MD5(teacher.getTeacher_no());
			teacher.setTeacher_pwd(passwordByMd5);
			int addResult=teacherService.addTeacher(teacher);
			if(addResult>0) {
				System.out.println("添加教师成功！");
				return new ResultMsg(1, "添加教师成功！");
			}
			else {
				System.out.println("添加教师失败！");
				return new ResultMsg(0,"添加教师失败！");
			}
		}

	}
	
	//显示教师管理修改页面
	@RequestMapping("/teacher_update")
		public ModelAndView teacher_update(int id) {
			ModelAndView mv=new ModelAndView("teacher/update");
			Teacher teacher=teacherService.selectTeacherById(id);
			List<Department> department=teacherService.getDepartment();
			mv.addObject("department", department);
			mv.addObject("teacher", teacher);
			return mv;
		}
		
		//执行修改页面
		@ResponseBody
		@RequestMapping("/update_teacher")
		public ResultMsg update_teacher(Teacher teacher) {
			//判断被修改的教师信息是否存在
			int selectResult= teacherService.selectTeacherByTeacherNo(teacher.getTeacher_no());
			
			if(selectResult==1) {
				return new ResultMsg(0,"该教师已存在，请重新输入！");
			}else {
				
				int updateResult = teacherService.updateTeacherById(teacher);
					
				if(updateResult>0) {
					return new ResultMsg(1, "修改信息成功！");
				}else {
					return new ResultMsg(0, "修改信息失败！");
					
				}
			}
			
		}
		
		//删除教师信息 
		@ResponseBody
		@RequestMapping("delete_teacher")
		public ResultMsg delete_teacher(int id) {
			int deleteResult=teacherService.deleteTeacherById(id);
			if(deleteResult>0) {
				return new ResultMsg(1, "删除教师信息成功！");
			}else {
				return new ResultMsg(0, "删除教师信息失败！");
			}
		}
		
		
		
	
}
