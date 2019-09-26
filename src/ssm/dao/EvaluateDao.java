package ssm.dao;

import java.util.List;

import ssm.entity.Teacher_course;

public interface EvaluateDao {

	//1.通过学生班级号，查询相应班级的课程名，任课老师 
	public List<Teacher_course> selectCourseTeacherByNo(String classes_no);
	
	//2.通过教师所在的部门id，查询相应部门的课程名，任课老师 
	public List<Teacher_course> selectCourseTeacherByDepid(int dep_id);
}
