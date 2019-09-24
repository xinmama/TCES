package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Classes;
import ssm.entity.Course;
import ssm.entity.ResultMsg;
import ssm.entity.Teacher;
import ssm.entity.Teacher_course;
import ssm.entity.Term;
import ssm.service.ClassService;
import ssm.service.CourseService;
import ssm.service.TeacherService;
import ssm.service.Teacher_courseService;
import ssm.service.TermService;

@Controller
public class Teacher_courseController {

	@Autowired
	private Teacher_courseService teacher_courseService;	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassService classService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TermService termService;
	
	//1.访问授课管理页面
	@RequestMapping("/teacher_course_list")
	public ModelAndView teacher_course_list() {
		ModelAndView mView=new ModelAndView("teacher_course/list");
		List<Teacher_course> teacher_course=teacher_courseService.getTeacher_course();
		mView.addObject("teacher_course", teacher_course);
		return mView;
	}
	
	//2.访问授课管理（添加）界面
	@RequestMapping("/teacher_course_add")
	public ModelAndView teacher_course_add() {
		ModelAndView mv=new ModelAndView("teacher_course/add");
		List<Term> term=termService.getTerm();
		System.out.println(term+"............");
		List<Teacher> teacher=teacherService.getTeacher();
		System.out.println(teacher+"............");
		List<Classes> classes=classService.getClasses();
		List<Course> course=courseService.getCourse();
		mv.addObject("term",term);
		mv.addObject("teacher",teacher);
		mv.addObject("classes",classes);
		mv.addObject("course",course);
		return mv;
	}
	
	//3.添加授课
		@RequestMapping("/add_teacher_course")
		@ResponseBody
		public ResultMsg add_teacher_course(Teacher_course teacher_course) {
			
			int selectResult=teacher_courseService.selectTeacher_courseByAllId(teacher_course);
			
			if(selectResult==1) {
				return new ResultMsg(0, "该授课已存在，请重新添加！");
			}else {

				int addResult=teacher_courseService.addTeacher_course(teacher_course);
				
				if(addResult>0) {
					return new ResultMsg(1, "添加成功！");
				}else {
					return new ResultMsg(0, "添加失败！");
				}
				
			}
			
		}
		
		//4.访问授课管理（修改）页面 
		@RequestMapping("/teacher_course_update")
		public ModelAndView teacher_course_update(int id) {	
			
			Teacher_course teacher_course=teacher_courseService.selectTeacher_courseById(id);
			List<Teacher> teacher=teacherService.getTeacher();
			List<Classes> classes=classService.getClasses();
			List<Course> course=courseService.getCourse();
			List<Term> term=termService.getTerm();
			
			ModelAndView mv=new ModelAndView("teacher_course/update");

			mv.addObject("teacher_course", teacher_course);	
			mv.addObject("teacher",teacher);
			mv.addObject("classes",classes);
			mv.addObject("course",course);
			mv.addObject("term",term);
			return mv;
		}
	
		
		//5.修改授课信息
		@RequestMapping("/update_teacher_course")
		@ResponseBody
		public ResultMsg update_teacher_course(Teacher_course teacher_course) {

			int selectResult=teacher_courseService.selectTeacher_courseByAllId(teacher_course);
			//int l=classService.selectClassesByClassNo(classes.getClasses_no());
			//System.out.println(l);
			
			if(selectResult==1) {
				return new ResultMsg(0,"该授课已存在，请重新输入！");
			}else {
				int updateResult=teacher_courseService.updateTeacher_course(teacher_course);
				
				if(updateResult>0) {
					return new ResultMsg(1,"修改成功！");
				}else {
					return new ResultMsg(0,"修改失败！");
				}
			}
			
		}
		
		
		//6.删除授课
		@ResponseBody
		@RequestMapping("/delete_teacher_course")
		public ResultMsg delete_teacher_course(int id) {
			int deleteResult=teacher_courseService.deleteTeacher_course(id);

			if(deleteResult>0) {
				return new ResultMsg(1,"删除成功！");
			}else {
				return new ResultMsg(0,"删除失败！");
			}
		}
		
		
	
}