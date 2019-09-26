package ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Classes;
import ssm.entity.Course;
import ssm.entity.Department;
import ssm.entity.ResultMsg;
import ssm.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//1.访问课程管理页面
	@RequestMapping("/course_list")
	public ModelAndView course_list() {
		ModelAndView mView=new ModelAndView("course/course_list");
		List<Course> courses=courseService.getCourse();
		List<Department> depname=courseService.getDepartment();
		mView.addObject("depname",depname);
		mView.addObject("courses", courses);
		return mView;
	}
	
	//2.访问课程管理（添加）界面
	@RequestMapping("/course_add")
	public ModelAndView course_add() {
		ModelAndView mv=new ModelAndView("course/course_add");
		List<Department> depname=courseService.getDepartment();
		mv.addObject("depname",depname);
		return mv;
	}
	
	//3.添加课程
		@ResponseBody
		@RequestMapping("/add_course")
		public ResultMsg add_course(Course course) {
			
			System.out.println("部门号："+course.getDep_id());
			System.out.println("课程名："+course.getCourse_name());
			
			int courseResult=courseService.selectCourseByAll(course);	
			
			if(courseResult==1) {
				return new ResultMsg(0, "该课程已存在，请重新添加！");
			}else {

				int courseResult1=courseService.addCourse(course);
				
				if(courseResult1>0) {
					return new ResultMsg(1, "添加成功！");
				}else {
					return new ResultMsg(0, "添加失败！");
				}
				
			}
			
		}
	
		
		
		//4.访问课程管理（修改）页面 
		@RequestMapping("/course_update")
		public ModelAndView course_update(int id) {	
			ModelAndView mv=new ModelAndView("course/course_update");
			Course course=courseService.selectCourseById(id);
			List<Department> department=courseService.getDepartment();
			
			mv.addObject("course", course);		
			mv.addObject("department", department);

			return mv;
		}
	
		
		//5.修改班级信息
		@ResponseBody
		@RequestMapping("/update_course")
		
		public ResultMsg update_course(Course course) {

			System.out.println("id:"+course.getId());
			System.out.println("课程名："+course.getCourse_name());
			System.out.println("部门号:"+course.getDep_id());
			
			int courseResult=courseService.selectCourseByAll(course);
			//int l=classService.selectClassesByClassNo(classes.getClasses_no());
			//System.out.println(l);
			
			if(courseResult>0) {
				return new ResultMsg(0,"该课程已存在，请勿重复操作。");
			}else {
				int courseResult1=courseService.updateCourse(course);
				
				if(courseResult1>0) {
					return new ResultMsg(1,"修改成功！");
				}else {
					return new ResultMsg(0,"修改失败！");
				}
			}
			
		}
		
		
		//6.删除课程
		@ResponseBody
		@RequestMapping("/delete_course")
		public ResultMsg deleteClasses(int id) {
			int deleteResult=courseService.deleteCourse(id);

			if(deleteResult>0) {
				return new ResultMsg(1,"删除成功！");
			}else {
				return new ResultMsg(0,"删除失败！");
			}
		}
		
	
		
	//7.关键字查询信息
	@RequestMapping("/select_info")
	public ModelAndView select_info(String info) {
		ModelAndView mView=new ModelAndView("course/course_list");
		List<Course> course=courseService.selectInformation(info);
		mView.addObject("course", course);
		return mView;
	}

	
}