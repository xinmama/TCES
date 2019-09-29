package ssm.dao;

import java.util.List;

import ssm.entity.Department;
import ssm.entity.Student;
import ssm.entity.Teacher;

public interface TeacherInformationDao {
	
	//鑾峰彇鐝骇鍒楄〃
		public List<Teacher> getTeacher();

		//鑾峰彇闄㈢郴鍒楄〃
		public List<Department> getDepartment();
		
		//鏌ヨ鏁欏笀淇℃伅锛堥�氳繃id锛�
		public Teacher selectTeacherById(int id);
		
		//鏌ヨ娣诲姞鏁欏笀鏄惁瀛樺湪
		public int selectTeacherByTeacherNo(String teacher_no);
		
		//淇敼鏁欏笀淇℃伅
		public int updateTeacherById(Teacher teacher);
		
		public String selectTeacherpwdByNo(String teacher_no);
		
		public int updateTeacherpwd(Teacher teacher);
}
