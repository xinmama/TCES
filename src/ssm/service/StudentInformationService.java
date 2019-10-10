package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.StudentDao;
import ssm.dao.StudentInformationDao;
import ssm.entity.Student;

@Service
public class StudentInformationService {
	
	@Autowired
	private StudentInformationDao studentInformationDao;
	
	public List<Student> selectStudent(){
		return studentInformationDao.selectStudent();
	}
	
	public Student selectStudentById2(String student_no) {
		return studentInformationDao.selectStudentById2(student_no);
	}
	
	public Student selectStudentById1(int id) {
		return studentInformationDao.selectStudentById1(id);
	}
	
	public int updateStudent(Student student) {
		return studentInformationDao.updateStudent(student);
	}
	
	public int selectStudentByStudentNo(String student_no) {
		return studentInformationDao.selectStudentByStudentNo(student_no);
	}
}
