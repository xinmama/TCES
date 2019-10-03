package ssm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssm.entity.St_score;
import ssm.entity.Teacher;
import ssm.entity.Teacher_course;
import ssm.entity.Tt_score;

public interface EvaluateDao {

	//1.通过学生班级号，查询相应班级的课程名，任课老师 
	public List<Teacher_course> selectCourseTeacherByNo(HashMap<String, Object> map);
	
	//2.通过教师所在的部门id，查询相应部门的课程名，任课老师 
	public List<Teacher_course> selectCourseTeacherByDepid(int dep_id);
	
	public int InsertSt_score(int score);

	public int InsertTt_score(int score);
	
	public Teacher_course selectCourseTeacherAllById(int id);

	//5.通过学生评教列表id，查询信息
	public Teacher_course selectCourseTeacherByid(int id);
	
	public int insertSt_scoreInfo(St_score score);
	
	public int insertTt_scoreInfo(Tt_score score);
	
	//新
	public List<Teacher_course> selectCourseTeacherByDepid(Teacher teacher);
	
	public Teacher_course selectCourseTeacherByTeacher_courseId(int id);
	
	public List<St_score> selectSt_scoreByStudent_id(int student_id);
}
