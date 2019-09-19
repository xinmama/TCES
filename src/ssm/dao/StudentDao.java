package ssm.dao;

import java.util.List;


import ssm.entity.Student;

public interface StudentDao {

	public List<Student> selectStudent();
	
	public int selectStudentById(String student_no);
	
	public int  addStudent(Student student);
	
	public Student selectStudentById1(int id);
	
	public int updateStudent(Student student);
	
	public int deletestudent(int id);
}
