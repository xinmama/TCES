package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.CourseDao;
import ssm.entity.Classes;
import ssm.entity.Course;
import ssm.entity.Department;

@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	//1.获取课程列表信息，并展示
	public List<Course> getCourse(){
		return courseDao.getCourse();
	}
	
	//2.获取部门列表并展示
	public List<Department> getDepartment() {
		return courseDao.getDepartment();
	}
		
	//3.先查询要添加的课程是否已经存在
	public int selectCourseByAll(Course course) {
		return  courseDao.selectCourseByAll(course);
	}
	
	//4.添加班级
	public int addCourse(Course course) {
		return courseDao.addCourse(course);
	}
	
	//5.通过id查询课程信息
	public Course selectCourseById(int id) {
		return courseDao.selectCourseById(id);
	} 
	
	//6.修改班级信息
	public int updateCourse(Course course) {
		return courseDao.updateCourse(course);
	}
		
	//7.删除班级信息
	public int deleteCourse(int id) {
		return courseDao.deleteCourse(id);
	}
}
