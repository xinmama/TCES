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
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.service.DepartmentService;
import ssm.service.TeacherInformationService;

@Controller
public class TeacherInformationController1 {
	
	@Autowired 
	public TeacherInformationService teacherInformationService;
	
	public DepartmentService departmentService;
		//教师信息显示页面
		@RequestMapping("/information_list")
		public ModelAndView teacherSelect(HttpServletRequest request) {
			ModelAndView mv=new ModelAndView("information/list");
			HttpSession session = request.getSession(true); 
			Teacher teacherSession=(Teacher)session.getAttribute("user");
			Teacher teacher=teacherInformationService.selectTeacherById(teacherSession.getId());
			mv.addObject("teacher",teacher);
			return mv;
		}
		
		
		
		//教师修改信息页面
		@RequestMapping("/information_update")
			public ModelAndView teacher_update(HttpServletRequest request) {
				ModelAndView mv=new ModelAndView("information/list");
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
			
			//修改教师信息
			@ResponseBody
			@RequestMapping("/update_information")
			public ResultMsg update_teacher(Teacher teacher) {
			
				int selectResult= teacherInformationService.selectTeacherByTeacherNo(teacher.getTeacher_no());
				
				if(selectResult==1) {
					return new ResultMsg(0,"该教师存在!");
				}else {
					
					int updateResult = teacherInformationService.updateTeacherById(teacher);
						
					if(updateResult>0) {
						return new ResultMsg(1, "教师信息修改成功！");
					}else {
						return new ResultMsg(0, "教师信息修改失败");
						
					}
				}
				
			}
			
			//访问教师修改密码页面
			@RequestMapping("/updateteacher_pwd")
			public ModelAndView updatepwd() {
				ModelAndView mv=new ModelAndView("information/updateteacher_pwd");
//				List<Teacher> teachers=teacherInformationService.getTeacher();
//				mv.addObject("teachers",teachers);
				return mv;
			}
			//修改教师密码
			@RequestMapping("/teacherpwd_update")
			@ResponseBody
			public ResultMsg pwd_update(String teacher_no,String oldpwd,String newpwd2) {
				
				Teacher teacher=new Teacher();
				teacher.setTeacher_no(teacher_no);
				teacher.setTeacher_pwd(newpwd2);
				String  oldpwdResult=teacherInformationService.selectTeacherpwdByNo(teacher_no);
				//System.out.println(oldpwd);
				if (oldpwd.equals(oldpwdResult)) {
					int i=teacherInformationService.updateTeacherpwd(teacher);
					if (i>0) {
						return new ResultMsg(1, "修改密码成功");
					}else {
						return new ResultMsg(0, "修改密码失败");
					}
					
				}else {
					return new ResultMsg(-1, "原密码不对");
				}
		}
			
			
		
}
