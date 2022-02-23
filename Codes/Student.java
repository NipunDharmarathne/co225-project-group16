//package co225-project-group16.Codes;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ToolTipManager;

public class Student {

    // non static attributes
    String username;
    String password;
    String firstName;
    String lastName;
    String faculty;
    int batchNo;
    int regNo;
    int totalSemesters;
    ArrayList<ArrayList<String>> studentGrades = new ArrayList<ArrayList<String>>();


    // Constructor for a new sign up
    public Student(String username, String password, String firstName, String lastName, String faculty, int batchNo, int regNo, int totalSemesters){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.batchNo = batchNo;
        this.regNo = regNo;
        this.totalSemesters = totalSemesters;
        // Initiating the studentGrades 2D ArrayList
        for (int i=1;i<=totalSemesters;++i){
            this.studentGrades.add(new ArrayList<String>());
        }
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getFaculty(){
        return this.faculty;
    }

    public int getBatchNo(){
        return this.batchNo;
    }

    public int getRegNo(){
        return this.regNo;
    }

    public void setGrades(int semesterNumber){
        Scanner in = new Scanner(System.in);
        System.out.printf("Please enter the number of subjects you have in semester %d : ",semesterNumber);    // can be accessed through admin
        int totalSubjects = in.nextInt();

        for (int i=1;i<=totalSubjects;++i){
            System.out.printf("Enter the grade of subject[%d]: ",i);           // subject code name ----> from admin
            String grade = in.next();                                          // nextLine ?? / next ???

            this.studentGrades.get(semesterNumber).add(i-1, grade);            // adding the grades into the corresponding semester
        }
        in.close();
    }
}
