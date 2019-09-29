package ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import ssm.entity.ResultMsg;
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.entity.Teacher_course;
import ssm.service.EvaluateService;

@Controller
public class EvaluateController {

	@Autowired
	private EvaluateService evaluateService;
	
	
	//1.访问学生评教列表页面
	@RequestMapping("/st_evaluate_list")
	public ModelAndView st_evaluate_list(HttpServletRequest request) {
		ModelAndView mView=new ModelAndView("evaluate/st_evaluate_list");
		
		HttpSession session = request.getSession(true); 
		Student student=(Student)session.getAttribute("user");
			
		List<Teacher_course> st_list=evaluateService.selectCourseTeacherByNo(student.getClasses().getClasses_no());
		for (Teacher_course teacher_course : st_list) {
			System.out.println("课程名："+teacher_course.getCourse().getCourse_name());
			System.out.println("教师名："+teacher_course.getTeacher().getTeacher_name());
		}
					
		mView.addObject("st_list", st_list);
		return mView;
	}	
	
	//2.访问教师评教列表页面
	@RequestMapping("/tt_evaluate_list")
	public ModelAndView tt_evaluate_list(HttpServletRequest request) {
		ModelAndView mView=new ModelAndView("evaluate/tt_evaluate_list");
		
		HttpSession session = request.getSession(true); 
		Teacher teacher=(Teacher)session.getAttribute("user");
		
		System.out.println(teacher.getTeacher_no());
		System.out.println(teacher.getDepartment().getId());
		
		List<Teacher_course> tt_list=evaluateService.selectCourseTeacherByDepid(teacher.getDepartment().getId());
		
		System.out.println("111111111111");
		for (Teacher_course teacher_course : tt_list) {
			System.out.println("2222222222222");
			System.out.println("课程名："+teacher_course.getCourse().getCourse_name());
			System.out.println("教师名："+teacher_course.getTeacher().getTeacher_name());
		}
		
		mView.addObject("tt_list", tt_list);
		return mView;
	}
	
	//访问学生评价页面
		@RequestMapping("/st_score_evaluate")
		public ModelAndView st_score(){
			ModelAndView mView= new ModelAndView("evaluate/st_score");
			return mView;		
		}
		
		//访问教师评价页面
		@RequestMapping("/tt_score_evaluate")
		public ModelAndView tt_score(){
			ModelAndView mView= new ModelAndView("evaluate/tt_score");
			return mView;		
		}
			
		//学生评价提交
		@RequestMapping("/st_score_submit")
		public ResultMsg st_score_submit(int score) {
				
			int st_scoreResult = evaluateService.InsertSt_score(score);
			
			if(st_scoreResult>0) {
				return new ResultMsg(1, "评价成功！");
			}else {
				return new ResultMsg(0, "评价失败！");
			}
		}
		
		//教师评价提交
		@RequestMapping("/tt_score_submit")
		public ResultMsg tt_score_submit(int score) {
					
			int st_scoreResult = evaluateService.InsertSt_score(score);
				
			if(st_scoreResult>0) {
				return new ResultMsg(1, "评价成功！");
			}else {
				return new ResultMsg(0, "评价失败！");
			}
		}
		
	//点击评教按钮，进入评教界面
	@RequestMapping("/st_comein")
	public ModelAndView st_comein(@RequestParam(value = "id")String id) {
		ModelAndView mView=new ModelAndView("evaluate/st_score");
		System.out.println(id);
		double tmp = Double.parseDouble(id);
		Teacher_course teacher_course=evaluateService.selectCourseTeacherByid((int)tmp);
		
		System.out.println("列表id:"+teacher_course.getId());
		
		mView.addObject("teacher_course",teacher_course);

		return mView;
	}
}
