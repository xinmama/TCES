package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.LoginDao;
import ssm.entity.Manage;
import ssm.entity.Student;
import ssm.entity.Teacher;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	public int selectManage(Manage manage) {
		
		int i = loginDao.selectManage(manage);
		
		if(i>0) {
			return 1;
		}
			return 0;
	}
	
	public int selectStudent(Student student) {
			
			int i = loginDao.selectStudent(student);
			
			if(i>0) {
				return 1;
			}
				return 0;
	}

	public int selectTeacher(Teacher teacher) {
		
		int i = loginDao.selectTeacher(teacher);
		
		if(i>0) {
			return 1;
		}
			return 0;
	}

	public int getManage(Manage manage) {
		
		int i = loginDao.getManage(manage);
		
		if(i>0) {
			return 1;
		}
			return 0;
	}

	public int getStudent(Student student) {
		
		int i = loginDao.getStudent(student);
		
		if(i>0) {
			return 1;
		}
			return 0;
	}

	public int getTeacher(Teacher teacher) {
		
		int i = loginDao.getTeacher(teacher);
		
		if(i>0) {
			return 1;
		}
			return 0;
	}
	
	
	
	public Student getInfoByStudentno(String student_no) {
		return loginDao.getInfoByStudentno(student_no);
	}
	
	public Teacher getInfoByTeacherno(String teacher_no) {
		return loginDao.getInfoByTeacherno(teacher_no);
	}
}
