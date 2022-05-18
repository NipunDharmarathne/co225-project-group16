package co225.project.group16.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "regNo")
	private long regNo;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "semester")
	private int semester;
	
	@Column(name = "registered")
	private boolean registered;

	public Student(long regNo, String username, String password, String firstName, String lastName, int semester,
			boolean registered) {
		this.regNo = regNo;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.semester = semester;
		this.registered = registered;
	}

	public Student(long regNo, String username, String firstName, String lastName, int semester, boolean registered) {
		this.regNo = regNo;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.semester = semester;
		this.registered = registered;
	}

	public Student() {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student [regNo=" + regNo + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", semester=" + semester + ", registered=" + registered + "]";
	}

}
