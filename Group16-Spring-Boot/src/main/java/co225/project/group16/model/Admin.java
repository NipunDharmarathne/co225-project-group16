package co225.project.group16.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regNo")
	private long regNo;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "university")
	private String university;

	@Column(name = "faculty")
	private String faculty;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "year")
	private long year;
	
	@Column(name = "totalSubjectsInFirstSem")
	private long totalSubjectsInFirstSem;
	
	@Column(name = "totalSubjectsInSecondSem")
	private long totalSubjectsInSecondSem;
	
	@Column(name = "registered")
	private boolean registered;

	public Admin(long regNo, String username, String password, String fullName, String university, String faculty,
			String department, long year, long totalSubjectsInFirstSem, long totalSubjectsInSecondSem,
			boolean registered) {
		this.regNo = regNo;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.university = university;
		this.faculty = faculty;
		this.department = department;
		this.year = year;
		this.totalSubjectsInFirstSem = totalSubjectsInFirstSem;
		this.totalSubjectsInSecondSem = totalSubjectsInSecondSem;
		this.registered = registered;
	}

	public Admin(long regNo, String username, String fullName, String university, String faculty,
			String department, long year, long totalSubjectsInFirstSem, long totalSubjectsInSecondSem,
			boolean registered) {
		this.regNo = regNo;
		this.username = username;
		this.fullName = fullName;
		this.university = university;
		this.faculty = faculty;
		this.department = department;
		this.year = year;
		this.totalSubjectsInFirstSem = totalSubjectsInFirstSem;
		this.totalSubjectsInSecondSem = totalSubjectsInSecondSem;
		this.registered = registered;
	}

	public Admin() {
	}

	public long getRegNo() {
		return regNo;
	}

	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public long getTotalSubjectsInFirstSem() {
		return totalSubjectsInFirstSem;
	}

	public void setTotalSubjectsInFirstSem(long totalSubjectsInFirstSem) {
		this.totalSubjectsInFirstSem = totalSubjectsInFirstSem;
	}

	public long getTotalSubjectsInSecondSem() {
		return totalSubjectsInSecondSem;
	}

	public void setTotalSubjectsInSecondSem(long totalSubjectsInSecondSem) {
		this.totalSubjectsInSecondSem = totalSubjectsInSecondSem;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	@Override
	public String toString() {
		return "Admin [regNo=" + regNo + ", username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", university=" + university + ", faculty=" + faculty + ", department=" + department + ", year="
				+ year + ", totalSubjectsInFirstSem=" + totalSubjectsInFirstSem + ", totalSubjectsInSecondSem="
				+ totalSubjectsInSecondSem + ", registered=" + registered + "]";
	}
}
