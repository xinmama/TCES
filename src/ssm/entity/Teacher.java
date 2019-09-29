package ssm.entity;

import java.util.Date;

public class Teacher {
	private int id;
	private String  teacher_no;
	private String teacher_name;
	private String teacher_pwd;
	private String sex;
	private String tel;
	private Integer dep_id;
	private Date time;
	private Department department;
	private String remark;
	private int is_manage;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getTeacher_no() {
		return teacher_no;
	}
	public void setTeacher_no(String teacher_no) {
		this.teacher_no = teacher_no;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_pwd() {
		return teacher_pwd;
	}
	public void setTeacher_pwd(String teacher_pwd) {
		this.teacher_pwd = teacher_pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getDep_id() {
		return dep_id;
	}
	public void setDep_id(Integer dep_id) {
		this.dep_id = dep_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public int getIs_manage() {
		return is_manage;
	}
	public void setIs_manage(int is_manage) {
		this.is_manage = is_manage;
	}
	
}
