package ssm.dao;

import java.util.List;

import ssm.entity.Department;
import ssm.entity.Teacher;

public interface TeacherInformationDao {
	
	//获取班级列表
		public List<Teacher> getTeacher();

		//获取院系列表
		public List<Department> getDepartment();
		
		//查询教师信息（通过id）
		public Teacher selectTeacherById(int id);
		
		//查询添加教师是否存在
		public int selectTeacherByTeacherNo(String teacher_no);
		
		//修改教师信息
		public int updateTeacherById(Teacher teacher);
}
