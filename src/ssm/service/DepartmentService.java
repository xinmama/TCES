package ssm.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import ssm.dao.DepartmentDao;
import ssm.entity.Department;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> selectDepartment(){
		return departmentDao.selectDepartment();
	}
	
	public int selectDepartmentByName(String dep_name) {
		return departmentDao.selectDepartmentByName(dep_name);
	}
	
	public int addDepartment(String dep_name) {
		return departmentDao.addDepartment(dep_name);
	}
	
	public Department selectDepartmentById(int id) {
		return departmentDao.selectDepartmentById(id);
	}
	
	public int updateDepartmentById(Department department) {
		return departmentDao.updateDepartmentById(department);
	}
	
	public int deleteDepartmentById(int id) {
		return departmentDao.deleteDepartmentById(id);
	}

}
