package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.Teacher_courseDao;
import ssm.entity.Teacher_course;

@Service
public class Teacher_courseService {

	@Autowired
	private Teacher_courseDao teacher_courseDao;
	
	//1.获取授课信息列表
	public List<Teacher_course> getTeacher_course(){
		return teacher_courseDao.getTeacher_course();
	}
	
	//2.添加授课信息
	public int addTeacher_course(Teacher_course teacher_course) {
		return teacher_courseDao.addTeacher_course(teacher_course);
	}
	
	//3.查询授课信息，判断是否存在
	public int selectTeacher_courseByAllId(Teacher_course teacher_course) {
		return teacher_courseDao.selectTeacher_courseByAllId(teacher_course);
	}
	
	//4.查询授课信息，并展示
	public Teacher_course selectTeacher_courseById(int id) {
		return teacher_courseDao.selectTeacher_courseById(id);
	}
	
	//5.修改授课信息
	public int updateTeacher_course(Teacher_course teacher_course) {
		return teacher_courseDao.updateTeacher_course(teacher_course);
	}
	
	//6.删除授课信息
	public int deleteTeacher_course(int id) {
		return teacher_courseDao.deleteTeacher_course(id);
	}
}
