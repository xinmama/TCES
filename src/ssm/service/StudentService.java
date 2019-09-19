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
	
	public int selectStudentById(String student_no) {
		return studentDao.selectStudentById(student_no);
	}
	
	public int  addStudent(Student student) {
		return studentDao.addStudent(student);
	}
	
	public Student selectStudentById1(int id) {
		return studentDao.selectStudentById1(id);
	}
	
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
	
	public int deletestudent(int id){
		return studentDao.deletestudent(id);
	}
	
	

}
