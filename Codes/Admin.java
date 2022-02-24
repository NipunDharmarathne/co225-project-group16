//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class Admin {
    
    // non static attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String University;
    private String faculty;
    private String department;
    private int year;
    private int totalSemesters;

    // Constructor for a new sign up
    public Admin (String username, String password, String firstName, String lastName, String University, String faculty, int year, int totalSemesters){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.University = University;
        this.faculty = faculty;
        this.year = year;
        this.totalSemesters = totalSemesters;
    }

    // Method to set the department
    public void setDepartment(String department){
        this.department = department;
    }

    // Method to return the username of the admin
    public String getUsername(){
        return this.username;
    }

    // Method to return the password of the admin
    public String getPassword(){
        return this.password;
    }

    // Method to return the first name of the admin
    public String getFirstName(){
        return this.firstName;
    }

    // Method to return the last name of the admin
    public String getLastName(){
        return this.lastName;
    }

    // Method to return the University of the admin
    public String getUniversity(){
        return this.University;
    }
    
    // Method to return the faculty of the admin
    public String getFaculty(){
        return this.faculty;
    }

    // Method to return the department of the admin
    public String getDepartment(){
        return this.department;
    }

    // Method to return the Year of the admin
    public int getYear(){
        return this.year;
    }

    // Method to return the number of total semesters
    public int getTotalSemesters(){
        return this.totalSemesters;
    }

    // Method to add courses
    public void addCourses(){
        boolean exists = false;
        if (this.year != 1){
            for (Department dptObj : Department.departments){
                String uni = dptObj.getUniversity();
                String fac = dptObj.getFaculty();
                String dept = dptObj.getDepartment();
    
                if (uni.equalsIgnoreCase(this.getUniversity()) && fac.equalsIgnoreCase(this.getFaculty()) && dept.equalsIgnoreCase(this.department)){
                    exists = true;
                    int semester = this.year*2 -4;
                    Scanner in = new Scanner(System.in);
                    // Each admin can add only two semesters
                    for (int i =0;i<2;++i){
                        System.out.println("Please enter the total subjects in semester " + (semester+i+3) + ": ");
                        int totalSubjects = in.nextInt();
                        for (int sub=0;sub<totalSubjects;++sub){
                            System.out.println("Enter the Course code "+ (sub+1) +": ");
                            String courseCode = in.next();
                            System.out.println("Enter the Course name "+ (sub+1) +": ");
                            String courseName = in.next();
                            String course = courseCode + " " + courseName;
                            dptObj.semesterCourses.get(semester+i).add(course);
                        }
                    }
                    in.close();
                }
            }
            if (!exists){
                Department dept = new Department(this.University, this.faculty, this.department, this.totalSemesters);
                int semester = this.year*2 -4;
                Scanner in = new Scanner(System.in);
                for (int i =0;i<2;++i){
                    System.out.println("Please enter the total subjects in semester " + (semester+i+3) + ": ");
                    int totalSubjects = in.nextInt();
                    for (int sub=0;sub<totalSubjects;++sub){
                        System.out.println("Enter the Course code "+ (sub+1) +": ");
                        String courseCode = in.next();
                        System.out.println("Enter the Course name "+ (sub+1) +": ");
                        String courseName = in.next();
                        String course = courseCode + " " + courseName;
                        dept.semesterCourses.get(semester+i).add(course);
                    }
                }
                Department.departments.add(dept);
                addFacultytoFacultyArray(this,dept);
                in.close();
            }
        } else {

        }
    }

    public void addFacultytoFacultyArray(Admin ad, Department dept){
        boolean isExists = false;

        for (Faculty fac : Faculty.FacultyArray){
            String uni = fac.getUniversity();
            String faculty = fac.getFaculty();

            if (ad.getUniversity().equalsIgnoreCase(uni) && ad.getFaculty().equalsIgnoreCase(faculty)){
                isExists = true;
            }
        }

        if (!isExists){
            Faculty fac = new Faculty(ad.getUniversity(), ad.getFaculty());
            fac.facultyDepartments.add(dept);
            Faculty.FacultyArray.add(fac);
        }
    }



}
