package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.TeacherInformationDao;
import ssm.entity.Department;
import ssm.entity.Teacher;

@Service
public class TeacherInformationService {
	
	@Autowired
	public TeacherInformationDao teacherInformationDao;

	//查询教师信息并显示
		public List<Teacher> getTeacher() {
			return teacherInformationDao.getTeacher();
		}
		
		//2.获取部门列表并展示
		public List<Department> getDepartment() {
			return teacherInformationDao.getDepartment();
		}
		
		//3.查询添加班级是否存在
		public int selectTeacherByTeacherNo(String teacher_no) {
			return teacherInformationDao.selectTeacherByTeacherNo(teacher_no);
		}
		
		//修改教师信息
		public int updateTeacherById(Teacher teacher) {
			return teacherInformationDao.updateTeacherById(teacher);
		}
		
		public Teacher selectTeacherById(int id) {
			return teacherInformationDao.selectTeacherById(id);
		}
}
