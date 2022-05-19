package co225.project.group16.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Column(name = "studentID")
	private String studentID;
	
	@Column(name = "semester")
	private int semester;
	
	@Column(name = "gpa")
	private int gpa;

	public Result(String studentID, int semester, int gpa) {
		this.studentID = studentID;
		this.semester = semester;
		this.gpa = gpa;
	}
	
	public Result() {
	}

	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getGpa() {
		return gpa;
	}
	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Result [studentID=" + studentID + ", semester=" + semester + ", gpa=" + gpa + "]";
	}
}
