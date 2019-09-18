package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ssm.dao.StudentDao;

import ssm.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public List<Student> selectStudent(){
		return studentDao.selectStudent();
	}
	
	

}
