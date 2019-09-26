package ssm.entity;

public class Classes {

	private int id;
	private String classes_no;
	private int dep_id;
	private Department department;
	private Teacher_course teacher_course;
	
	
	
	public Teacher_course getTeacher_course() {
		return teacher_course;
	}
	public void setTeacher_course(Teacher_course teacher_course) {
		this.teacher_course = teacher_course;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasses_no() {
		return classes_no;
	}
	public void setClasses_no(String classes_no) {
		this.classes_no = classes_no;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	
	
	
}
