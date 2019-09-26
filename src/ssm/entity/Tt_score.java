package ssm.entity;

public class Tt_score {

	private int id;
	private int teacher1_id;
	private int dep_id;
	private int teacher2_id;
	private float tt_score;
	private String course_name;

	 private Teacher teacher1;
	 private Teacher teacher2;
	 private Department department;
	 
	 
	 
	public Department getDepartment() {
		return department;
	}
	public void setDepartment1(Department department1) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeacher1_id() {
		return teacher1_id;
	}
	public void setTeacher1_id(int teacher1_id) {
		this.teacher1_id = teacher1_id;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public int getTeacher2_id() {
		return teacher2_id;
	}
	public void setTeacher2_id(int teacher2_id) {
		this.teacher2_id = teacher2_id;
	}
	public float getTt_score() {
		return tt_score;
	}
	public void setTt_score(float tt_score) {
		this.tt_score = tt_score;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Teacher getTeacher1() {
		return teacher1;
	}
	public void setTeacher1(Teacher teacher1) {
		this.teacher1 = teacher1;
	}
	public Teacher getTeacher2() {
		return teacher2;
	}
	public void setTeacher2(Teacher teacher2) {
		this.teacher2 = teacher2;
	}
}
