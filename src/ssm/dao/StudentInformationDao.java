package ssm.dao;

import java.util.List;

import ssm.entity.Student;

public interface StudentInformationDao {

	public List<Student> selectStudent();
	
	public Student selectStudentById2(String student_no);
	
	public Student selectStudentById1(int id);
	
	public int updateStudent(Student student);
}
