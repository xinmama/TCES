package ssm.dao;


import java.util.List;

import ssm.entity.Department;
import ssm.entity.Teacher;
/**
 * 
 * 方法名与id一致
 * 参数类型与parameterType一致
 * 返回值与resultType一致
 *
 */
public interface TeacherDao {
	
	//获取班级列表
	public List<Teacher> getTeacher();

	//获取院系列表
	public List<Department> getDepartment();
	
	//查询添加教师是否存在
	public int selectTeacherByTeacherNo(String teacher_no);
	
	//查询教师信息（通过id）
	public Teacher selectTeacherById(int id);
	
	//添加教师信息
	public int addTeacher(Teacher teacher);
	
	//修改教师信息
	public int updateTeacherById(Teacher teacher);
	
	//删除教师信息
	public int deleteTeacherById(int id);
}
