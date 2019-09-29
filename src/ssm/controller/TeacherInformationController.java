package ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.entity.Teacher;
import ssm.service.DepartmentService;
import ssm.service.TeacherInformationService;

@Controller
public class TeacherInformationController {
	
	@Autowired 
	public TeacherInformationService teacherInformationService;
	
	@Autowired
	public DepartmentService departmentService;
	
	//查询
		@RequestMapping("/information_list")
		public ModelAndView teacherSelect(HttpServletRequest request) {
			ModelAndView mv=new ModelAndView("information/list");
			HttpSession session = request.getSession(true); 
			Teacher teacherSession=(Teacher)session.getAttribute("user");
			Teacher teacher=teacherInformationService.selectTeacherById(teacherSession.getId());
			mv.addObject("teacher",teacher);
			return mv;
		}
		 
		//显示教师管理修改页面
		@RequestMapping("/information_update")
			public ModelAndView teacher_update(HttpServletRequest request) {
				ModelAndView mv=new ModelAndView("information/update");
				HttpSession session = request.getSession(true); 
				Teacher teacherSession=(Teacher)session.getAttribute("user");
				Teacher teacher=teacherInformationService.selectTeacherById(teacherSession.getId()); 
				
				Department department=departmentService.selectDepartmentById(teacher.getDep_id());
				/*Teacher teacher=teacherInformationService.selectTeacherById(id);
				List<Department> department=tesacherInformationService.getDepartment();*/
				mv.addObject("department", department);
				mv.addObject("teacher", teacher);
				return mv;
			}
			
			//执行修改页面
			@ResponseBody
			@RequestMapping("/update_information")
			public ResultMsg update_teacher(Teacher teacher) {
				//判断被修改的教师信息是否存在
				int selectResult= teacherInformationService.selectTeacherByTeacherNo(teacher.getTeacher_no());
				
				if(selectResult==1) {
					return new ResultMsg(0,"该教师已存在，请重新输入！");
				}else {
					
					int updateResult = teacherInformationService.updateTeacherById(teacher);
						
					if(updateResult>0) {
						return new ResultMsg(1, "修改信息成功！");
					}else {
						return new ResultMsg(0, "修改信息失败！");
						
					}
				}
				
			}
		
}
