package co225.project.group16.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courseCode")
	private String courseCode;
	
	@Column(name = "adminID")
	private String adminID;
	
	@Column(name = "courseName")
	private String courseName;
	
	@Column(name = "credit")
	private int credit;
	
	@Column(name = "semester")
	private int semester;	
	
	public Course(String courseCode, String adminID, String courseName, int credit, int semester) {
		this.courseCode = courseCode;
		this.adminID = adminID;
		this.courseName = courseName;
		this.credit = credit;
		this.semester = semester;
	}
	
	public Course() {
	}

	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getName() {
		return courseName;
	}
	public void setName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", adminID=" + adminID + ", courseName=" + courseName + ", credit=" + credit
				+ ", semester=" + semester + "]";
	}
}
