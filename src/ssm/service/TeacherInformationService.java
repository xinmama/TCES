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

	//鏌ヨ鏁欏笀淇℃伅骞舵樉绀�
		public List<Teacher> getTeacher() {
			return teacherInformationDao.getTeacher();
		}
		
		//2.鑾峰彇閮ㄩ棬鍒楄〃骞跺睍绀�
		public List<Department> getDepartment() {
			return teacherInformationDao.getDepartment();
		}
		
		//3.鏌ヨ娣诲姞鐝骇鏄惁瀛樺湪
		public int selectTeacherByTeacherNo(String teacher_no) {
			return teacherInformationDao.selectTeacherByTeacherNo(teacher_no);
		}
		
		//淇敼鏁欏笀淇℃伅
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
