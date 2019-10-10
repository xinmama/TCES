package ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Classes;
import ssm.entity.ResultMsg;
import ssm.entity.Student;
import ssm.service.ClassService;
import ssm.service.StudentInformationService;

@Controller
public class StudentInformationController {
	
	@Autowired
	private StudentInformationService studentInformationService;
	
	@Autowired
	private ClassService classService;
	
	//学生信息显示页面
	@RequestMapping("/studentInformation_list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mView = new ModelAndView("studentInformation/list");
		HttpSession session = request.getSession(true); 
		Student studentSession=(Student)session.getAttribute("user");
		Student student=studentInformationService.selectStudentById2(studentSession.getStudent_no());
				
		mView.addObject("student",student);
		return mView;
	}
	
	//学生信息修改页面
	@RequestMapping("/studentInformation_update")
	public ModelAndView student_update(HttpServletRequest request) {
		
		ModelAndView mView = new ModelAndView("studentInformation/list");
		HttpSession session = request.getSession(true); 
		Student studentSession=(Student)session.getAttribute("user");
		Student student=studentInformationService.selectStudentById2(studentSession.getStudent_no());
		
		Classes classes = classService.selectClassesById(student.getClasses_id());
		return mView;
	}
	
	//学生信息修改
	@RequestMapping("/update_studentInformation")
	@ResponseBody
	public ResultMsg update_student(Student student) {
		
		//int idResult=studentService.selectStudentById(student.getStudent_no());
		
		int selectResult=	studentInformationService.selectStudentByStudentNo(student.getStudent_no());
		if(selectResult==1) {
			return new ResultMsg(0, "该学生存在！");
		}else {
			int updateResult=studentInformationService.updateStudent(student);
			if(updateResult>0) {
				return new ResultMsg(1, "修改学生信息成功!");
			}else {
				return new ResultMsg(0, "修改学生信息失败!");
			}
		}
	}
}
