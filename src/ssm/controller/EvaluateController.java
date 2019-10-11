package ssm.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import ssm.entity.ResultMsg;
import ssm.entity.St_score;
import ssm.entity.Standard;
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.entity.Teacher_course;
import ssm.entity.Tt_score;
import ssm.service.EvaluateService;
import ssm.service.StandardService;
import ssm.service.TermService;

@Controller
public class EvaluateController {

	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private TermService termService;
	@Autowired
	private StandardService standardService;

	//1.访问学生评教列表页面
	@RequestMapping("/st_evaluate_list")
	public ModelAndView st_evaluate_list(HttpServletRequest request) {
		ModelAndView mView=new ModelAndView("evaluate/st_evaluate_list");
		
		HttpSession session = request.getSession(true); 
		Student student=(Student)session.getAttribute("user");
		
		//查询学期是否存在
		int termResult = termService.selectIsCurrAppraise();
		if(termResult==1) {//如果存在，查询学期的id
			int termResultId = termService.selectIsCurrAppraiseByIs_open();
			
			HashMap <String,Object> map = new HashMap<String,Object>();

			map.put("classes_no",student.getClasses().getClasses_no());

			map.put("term_id",termResultId);
				
			List<Teacher_course> st_list = evaluateService.selectCourseTeacherByNo(map);//查询该学生在开启学期的可评价记录
			
			List<St_score> st_scores = evaluateService.selectSt_scoreByStudent_id(student.getId());//查询该学期已评价的记录
			
			Iterator<Teacher_course> it = st_list.iterator();
			 while(it.hasNext()){
			  Teacher_course x = it.next();
			  System.out.println(x.getId());
			  Iterator<St_score> is = st_scores.iterator();
			  while(is.hasNext()){
				  St_score y = is.next();
				  System.out.println(y.getId());
				  if(y.getStudent_id() == student.getId() && y.getTeacher_id() == x.getTeacher_id() && y.getCourse_name() .equals(x.getCourse().getCourse_name()) ){
					    it.remove();
				  }
			  }  
			}
			 
			mView.addObject("st_list", st_list);
			
			return mView;
		}else {
			return mView.addObject("st_list", "");
		}

		
	}	
	
	//新
	//2.访问教师评教列表页面
	@RequestMapping("/tt_evaluate_list")
	public ModelAndView tt_evaluate_list(HttpServletRequest request) {
		ModelAndView mView=new ModelAndView("evaluate/tt_evaluate_list");
		
		HttpSession session = request.getSession(true); 
		Teacher teacher=(Teacher)session.getAttribute("user");
		
		//查询学期是否存在
				int termResult = termService.selectIsCurrAppraise();
				if(termResult==1) {//如果存在，查询学期的id
					int termResultId = termService.selectIsCurrAppraiseByIs_open();
					
					HashMap <String,Object> map = new HashMap<String,Object>();

					map.put("dep_id",teacher.getDep_id());

					map.put("term_id",termResultId);
						
					List<Teacher_course> tt_list = evaluateService.selectCourseTeacherByInfo(map);//查询该学生在开启学期的可评价记录
					
					List<Tt_score> tt_scores = evaluateService.selectSt_scoreByTeacher_id(teacher.getId());//查询该学期已评价的记录
					Iterator<Teacher_course> it = tt_list.iterator();
					 while(it.hasNext()){
					  Teacher_course x = it.next();
					  					  
					  if(x.getTeacher_id() == teacher.getId()) {
						  it.remove();
						  continue;
					  }
					  Iterator<Tt_score> is = tt_scores.iterator();
					  while(is.hasNext()){
						  Tt_score y = is.next();
						  if(y.getTeacher1_id() == teacher.getId() && y.getTeacher2_id() == x.getTeacher_id() && y.getCourse_name().equals(x.getCourse().getCourse_name())){
							    it.remove();
						  }
					  }  
					}
					 
					 
					mView.addObject("tt_list", tt_list);
					
					return mView;
				}else {
					return mView.addObject("tt_list", "");
				}
		
		
		/*List<Teacher_course> tt_list=evaluateService.selectCourseTeacherByDepid(teacher);
		
		mView.addObject("tt_list", tt_list);
		return mView;*/
	}
	
		//访问学生评价页面
		@RequestMapping("/st_score_evaluate")
		public ModelAndView st_score(int id){						
			ModelAndView mView= new ModelAndView("evaluate/st_score");
			Teacher_course teacher_course = evaluateService.selectCourseTeacherAllById(id);			
			mView.addObject("teacher_course", teacher_course);
			
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
		@ResponseBody
		public ResultMsg st_score_submit(int student_id,int classes_id,int teacher_id,float st_score,String course_name) {
				
			St_score score = new St_score();
			score.setStudent_id(student_id);
			score.setClasses_id(classes_id);
			score.setTeacher_id(teacher_id);
			score.setSt_score(st_score);
			score.setCourse_name(course_name);
			int st_scoreResult = evaluateService.insertSt_scoreInfo(score);
			
			if(st_scoreResult>0) {
				return new ResultMsg(1, "评价成功！");
			}else {
				return new ResultMsg(0, "评价失败！");
			}
		}
		
		//教师评价提交
		@RequestMapping("/tt_score_submit")
		@ResponseBody
		public ResultMsg tt_score_submit(int teacher1_id,int dep_id,int teacher2_id,float tt_score,String course_name) {
			System.out.println("test1");
			Tt_score score = new Tt_score();
			score.setTeacher1_id(teacher1_id);
			score.setDep_id(dep_id);
			score.setTeacher2_id(teacher2_id);
			score.setTt_score(tt_score);
			score.setCourse_name(course_name);
			int tt_scoreResult = evaluateService.insertTt_scoreInfo(score);
			
			if(tt_scoreResult>0) {
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
		
		List<Standard> standards = standardService.selectStandardByType(0);
		
		System.out.println("列表id:"+teacher_course.getId());
		
		mView.addObject("standards",standards);
		mView.addObject("teacher_course",teacher_course);

		return mView;
	}
	
	//点击评教按钮，进入评教界面
	@RequestMapping("/tt_comein")
	public ModelAndView tt_comein(@RequestParam(value = "id")String id) {
		ModelAndView mView=new ModelAndView("evaluate/tt_score");
		System.out.println("id:"+id);
		double tmp = Double.parseDouble(id);
		
		Teacher_course teacher_course=evaluateService.selectCourseTeacherByTeacher_courseId((int)tmp);
		
		List<Standard> standards=standardService.selectStandardByType(1);
		
		mView.addObject("standards",standards);
		mView.addObject("teacher_course",teacher_course);
		return mView;
	}
	
}
