package ssm.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import ssm.entity.Department;

public interface DepartmentDao {

	public List<Department> selectDepartment();
	
	public int selectDepartmentByName(String dep_name);
	
	public int addDepartment(String dep_name);
}
