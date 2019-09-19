package ssm.dao;

import java.util.List;

import ssm.entity.Classes;
import ssm.entity.Course;
import ssm.entity.Department;

public interface CourseDao {

	//1.获取课程信息列表
	public List<Course> getCourse();
	
	//2.获取部门列表
	public List<Department> getDepartment();
		
	//3.先查询要添加党的课程是否已经存在
	public int selectCourseByAll(Course course);
	
	//4.添加课程
	public int addCourse(Course course);
	
	//5.查询课程信息（通过id）
	public Course selectCourseById(int id);
	
	//6.修改课程信息
	public int updateCourse(Course course);
	
	//7.删除课程信息
	public int deleteCourse(int id);
}
