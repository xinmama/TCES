package ssm.dao;

import java.util.List;

import ssm.entity.Department;
import ssm.entity.Student;
import ssm.entity.Teacher;

public interface TeacherInformationDao {
	
	
		public List<Teacher> getTeacher();

		
		public List<Department> getDepartment();
		
	
		public Teacher selectTeacherById(int id);
		

		public int selectTeacherByTeacherNo(String teacher_no);
		

		public int updateTeacherById(Teacher teacher);
		
		public String selectTeacherpwdByNo(String teacher_no);
		
		public int updateTeacherpwd(Teacher teacher);
}
