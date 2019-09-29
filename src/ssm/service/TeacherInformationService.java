package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.TeacherInformationDao;
import ssm.entity.Department;
import ssm.entity.Student;
import ssm.entity.Teacher;

@Service
public class TeacherInformationService {
	
	@Autowired
	public TeacherInformationDao teacherInformationDao;


		public List<Teacher> getTeacher() {
			return teacherInformationDao.getTeacher();
		}
		

		public List<Department> getDepartment() {
			return teacherInformationDao.getDepartment();
		}
		

		public int selectTeacherByTeacherNo(String teacher_no) {
			return teacherInformationDao.selectTeacherByTeacherNo(teacher_no);
		}
		

		public int updateTeacherById(Teacher teacher) {
			return teacherInformationDao.updateTeacherById(teacher);
		}
		
		public Teacher selectTeacherById(int id) {
			return teacherInformationDao.selectTeacherById(id);
		}
		
		public String selectTeacherpwdByNo(String teacher_no) {
			return teacherInformationDao.selectTeacherpwdByNo(teacher_no);
		}
		
		public int updateTeacherpwd(Teacher teacher) {
			return teacherInformationDao.updateTeacherpwd(teacher);
		}
}
