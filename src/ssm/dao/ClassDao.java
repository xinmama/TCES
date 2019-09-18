package ssm.dao;

import java.util.List;

import ssm.entity.Classes;
import ssm.entity.Department;

public interface ClassDao {

	//1.获取班级列表
	List<Classes> getClasses();
	
	//2.获取部门列表
	public List<Department> getDepartment();
	
	//3.查询添加班级是否已经存在
	public int selectClassesByClassNo(String classes_no);
	
	//4.添加班级
	public int addClasses(Classes classes);
	
	//5.查询班级信息（通过id）
	public Classes selectClassesById(int id);
	
	//6.修改班级信息
	public int updateClasses(Classes classes);
	
	//7.删除班级信息
	public int deleteClasses(int id);
	
}
