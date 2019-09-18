package ssm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.ClassDao;
import ssm.entity.Classes;
import ssm.entity.Department;

@Service
public class ClassService {

	@Autowired
	private ClassDao classDao;
	
	//1.获取班级列表并展示
	public List<Classes> getClasses(){
		return classDao.getClasses();
	}
	
	//2.获取部门列表并展示
	public List<Department> getDepartment() {
		return classDao.getDepartment();
	}
		
	//3.查询添加班级是否存在
	public int selectClassesByClassNo(String classes_no) {
		return classDao.selectClassesByClassNo(classes_no);
	}
	
	//4.添加班级
	public int addClasses(Classes classes) {
		return classDao.addClasses(classes);
	}
	
	//5.通过id查询班级信息
	public Classes selectClassesById(int id) {
		return classDao.selectClassesById(id);
	} 
	
	//6.修改班级信息
	public int updateClasses(Classes classes) {
		return classDao.updateClasses(classes);
	}
	
	//7.删除班级信息
	public int deleteClasses(int id) {
		return classDao.deleteClasses(id);
	}
	
	
}
