package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.TeacherDao;
import ssm.entity.Department;
import ssm.entity.Teacher;

@Service
public class TeacherService {

	@Autowired
	public TeacherDao teacherDao;
	
	//查询教师信息并显示
	public List<Teacher> getTeacher() {
		return teacherDao.getTeacher();
	}
	
	//2.获取部门列表并展示
	public List<Department> getDepartment() {
		return teacherDao.getDepartment();
	}
	
	//3.查询添加班级是否存在
	public int selectTeacherByTeacherNo(String teacher_no) {
		return teacherDao.selectTeacherByTeacherNo(teacher_no);
	}
	
	//4.添加班级信息
	public int addTeacher(Teacher teacher) {
		return teacherDao.addTeacher(teacher);
	}
	
	//修改教师信息
	public int updateTeacherById(Teacher teacher) {
		return teacherDao.updateTeacherById(teacher);
	}
	
	//删除教师信息
	public int deleteTeacherById(int id) {
		return teacherDao.deleteTeacherById(id);
	}

	public Teacher selectTeacherById(int id) {
		return teacherDao.selectTeacherById(id);
	}

	
		
}
