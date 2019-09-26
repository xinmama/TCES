package ssm.dao;

import ssm.entity.Manage;
import ssm.entity.Student;
import ssm.entity.Teacher;

public interface LoginDao {
	
	int selectManage(Manage manage);
	int selectStudent(Student student);
	int selectTeacher(Teacher teacher);
	int getManage(Manage manage);
	int getStudent(Student student);
	int getTeacher(Teacher teacher);
	Student getInfoByStudentno(String student_no);
	Teacher getInfoByTeacherno(String teacher_no);
	
}
