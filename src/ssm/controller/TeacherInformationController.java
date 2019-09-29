package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.service.TeacherInformationService;

@Controller
public class TeacherInformationController {
	
	@Autowired 
	public TeacherInformationService teacherInformationService;
	
	//鏌ヨ
		@RequestMapping("/information_list")
		public ModelAndView teacherSelect() {
			ModelAndView mv=new ModelAndView("information/list");
			List<Teacher> teachers=teacherInformationService.getTeacher();
			mv.addObject("teachers",teachers);
			return mv;
		}
		
		
		//鏄剧ず鏁欏笀绠＄悊淇敼椤甸潰
		@RequestMapping("/information_update")
			public ModelAndView teacher_update(int id) {
				ModelAndView mv=new ModelAndView("information/update");
				Teacher teacher=teacherInformationService.selectTeacherById(id);
				List<Department> department=teacherInformationService.getDepartment();
				mv.addObject("department", department);
				mv.addObject("teacher", teacher);
				return mv;
			}
			
			//鎵ц淇敼椤甸潰
			@ResponseBody
			@RequestMapping("/update_information")
			public ResultMsg update_teacher(Teacher teacher) {
				//鍒ゆ柇琚慨鏀圭殑鏁欏笀淇℃伅鏄惁瀛樺湪
				int selectResult= teacherInformationService.selectTeacherByTeacherNo(teacher.getTeacher_no());
				
				if(selectResult==1) {
					return new ResultMsg(0,"璇ユ暀甯堝凡瀛樺湪锛岃閲嶆柊杈撳叆锛�");
				}else {
					
					int updateResult = teacherInformationService.updateTeacherById(teacher);
						
					if(updateResult>0) {
						return new ResultMsg(1, "淇敼淇℃伅鎴愬姛锛�");
					}else {
						return new ResultMsg(0, "淇敼淇℃伅澶辫触锛�");
						
					}
				}
				
			}
			
			//学生修改密码
			@RequestMapping("/updateteacher_pwd")
			public ModelAndView updatepwd() {
				ModelAndView mv=new ModelAndView("information/updateteacher_pwd");
//				List<Teacher> teachers=teacherInformationService.getTeacher();
//				mv.addObject("teachers",teachers);
				return mv;
			}
			
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
