package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Classes;
import ssm.entity.ResultMsg;
import ssm.entity.Student;
import ssm.service.ClassService;
import ssm.service.StudentService;
import ssm.util.Md5;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassService classService;
	
	//1.模糊查询
	@RequestMapping("/student_list_inquire")
	public ModelAndView list_inquire(@RequestParam(value = "info")String info) {
		List<Student> students=studentService.selectStudentByName(info);
		for (Student student : students) {
			System.out.println(student.getStudent_name()+student.getClasses().getClasses_no());
		}
		ModelAndView mView=new ModelAndView("student/list");
		mView.addObject("students", students);
		return mView;
	}
	
		
	@RequestMapping("/student_list")
	public ModelAndView list() {
		List<Student> students=studentService.selectStudent();
		ModelAndView mView = new ModelAndView("student/list");
		mView.addObject("students",students);
		return mView;
	}
	
	@RequestMapping("/student_add")
	public ModelAndView add() {
		List<Classes> classes=classService.getClasses();
		ModelAndView mView = new ModelAndView("student/add");
		mView.addObject("classes",classes);
		return mView;
	}
	
	@RequestMapping("/add_student")
	@ResponseBody
	public ResultMsg add_student(Student student) {
		int idResult=studentService.selectStudentById(student.getStudent_no());
		if(idResult==1) {
			return new ResultMsg(-1, "记录已存在!");
		}else {
			String passwordByMd5 = Md5.MD5(student.getStudent_no());
			student.setStudent_pwd(passwordByMd5);
			int addResult=studentService.addStudent(student);
			if(addResult>0) {
				return new ResultMsg(1, "添加成功！");
			}else {
				return new ResultMsg(0, "添加失败！");
			}
		}
	}
	@RequestMapping("/student_update")
	public ModelAndView student_update(int id) {
		List<Classes> classes=classService.getClasses();
		Student student=studentService.selectStudentById1(id);
		ModelAndView mView = new ModelAndView("student/update");
		mView.addObject("student",student);
		mView.addObject("classes",classes);
		return mView;
	}
	
	@RequestMapping("/update_student")
	@ResponseBody
	public ResultMsg update_student(Student student) {
		
		//int idResult=studentService.selectStudentById(student.getStudent_no());
			int updateResult=studentService.updateStudent(student);
			if(updateResult>0) {
				return new ResultMsg(1, "修改成功！");
			}else {
				return new ResultMsg(0, "修改失败！");
			}
		}
	
	@RequestMapping("/delete_student")
	@ResponseBody
	public ResultMsg delete_student(int id) {
		
		//int idResult=studentService.selectStudentById(student.getStudent_no());
		
			int deleteResult=studentService.deletestudent(id);
			if(deleteResult>0) {
				return new ResultMsg(1, "删除成功！");
			}else {
				return new ResultMsg(0, "删除失败！");
			}
		}
	
	//ѧ���޸�����
			@RequestMapping("/updatestudent_pwd")
			public ModelAndView updatepwd() {
				ModelAndView mv=new ModelAndView("information/updatestudent_pwd");
//				List<Teacher> teachers=teacherInformationService.getTeacher();
//				mv.addObject("teachers",teachers);
				return mv;
			}
			
			@RequestMapping("/studentpwd_update")
			@ResponseBody
			public ResultMsg pwd_update(String student_no,String oldpwd,String newpwd2) {
				
				Student student=new Student();
				
				String oldpasswordByMd5 = Md5.MD5(oldpwd);
				
				student.setStudent_no(student_no);
				
				String newPasswordByMd5 = Md5.MD5(newpwd2);
				student.setStudent_pwd(newPasswordByMd5);
				String  oldpwdResult=studentService.selectStudentpwdByNo(student_no);
				//System.out.println(oldpwd);
				if (oldpasswordByMd5.equals(oldpwdResult)) {
					int i=studentService.updateStudentpwd(student);
					if (i>0) {
						return new ResultMsg(1, "修改成功！");
					}else {
						return new ResultMsg(0, "修改失败！");
					}
					
				}else {
					return new ResultMsg(-1, "记录已存在！");
				}
		}
	}

