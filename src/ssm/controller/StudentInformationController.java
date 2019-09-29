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

	@RequestMapping("/studentInformation_list")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mView = new ModelAndView("studentInformation/list");
		HttpSession session = request.getSession(true); 
		Student studentSession=(Student)session.getAttribute("user");
		
		Student student=studentInformationService.selectStudentById2(studentSession.getStudent_no());
				
		
		mView.addObject("student",student);
		return mView;
	}
	
	@RequestMapping("/studentInformation_update")
	public ModelAndView student_update(int id) {
		List<Classes> classes=classService.getClasses();
		Student student=studentInformationService.selectStudentById1(id);
		ModelAndView mView = new ModelAndView("studentInformation/update");
		mView.addObject("student",student);
		mView.addObject("classes",classes);
		return mView;
	}
	
	@RequestMapping("/update_studentInformation")
	@ResponseBody
	public ResultMsg update_student(Student student) {
		
		//int idResult=studentService.selectStudentById(student.getStudent_no());
		
			int updateResult=studentInformationService.updateStudent(student);
			if(updateResult>0) {
				return new ResultMsg(1, "修改学生信息成功!");
			}else {
				return new ResultMsg(0, "修改学生信息失败!");
			}
		}

}
