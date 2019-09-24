package ssm.dao;

import java.util.List;

import ssm.entity.Teacher_course;

public interface Teacher_courseDao {

	//1.获取授课信息列表
	public List<Teacher_course> getTeacher_course();
	
	//2.添加授课信息
	public int addTeacher_course(Teacher_course teacher_course);
	
	//3.查询授课信息，判断是否存在
	public int selectTeacher_courseByAllId(Teacher_course teacher_course);
	
	//4.查询授课信息，并展示
	public Teacher_course selectTeacher_courseById(int id);
	
	//5.修改授课信息
	public int updateTeacher_course(Teacher_course teacher_course);
	
	//6.删除授课信息
	public int deleteTeacher_course(int id);
}
