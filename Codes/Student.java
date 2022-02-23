//package co225-project-group16.Codes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    List <Double> semesterGPAs = new ArrayList<>();

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

    // Method to store the grades in the 2D Array
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

    // Method to calculate the current GPA of a given semester
    public double getCurrentGPA(int currentSemester, int totalSubjects){          // totalSubjects should be taken from the admin class
        double currentGPA = 0.0;
        for (int i=0;i<totalSubjects;++i){
            String grade = this.studentGrades.get(currentSemester).get(i);

            switch (grade) {
                case "A+"   :   currentGPA += 4.0;
                                break;
                
                case "A"    :   currentGPA += 4.0;
                                break;
                
                case "A-"   :   currentGPA += 3.7;
                                break;
                
                case "B+"   :   currentGPA += 3.3;
                                break;
                
                case "B"    :   currentGPA += 3;
                                break;
                
                case "B-"   :   currentGPA += 2.7;
                                break;
                
                case "C+"   :   currentGPA += 2.3;
                                break;

                case "C"    :   currentGPA += 2;
                                break;

                case "C-"   :   currentGPA += 1.7;
                                break;

                case "D+"   :   currentGPA += 1.3;
                                break;
                            
                case "D"    :   currentGPA += 1;
                                break;

                default     :   currentGPA += 0.0;
                                break;
            }
        }
        currentGPA = currentGPA / totalSubjects;
        this.semesterGPAs.add(currentSemester-1, currentGPA);              // used auto boxing concept
        return currentGPA;
    }

    // Method to calculate the year end GPA when the academic yr is given
    public double getYearlyMeanGPA(int academicYr){
        int semesterIndex = academicYr*2 - 2;
        double YrEndMeanGPA = (this.semesterGPAs.get(semesterIndex) + this.semesterGPAs.get(semesterIndex+1)) / 2;
        return YrEndMeanGPA;
    }

    // Method to calculate the mean GPA upto the current semester
    public double getMeanGPA(int currentSemester){
        double meanGPA =0.0;
        for (int i=0;i<currentSemester;++i){
            meanGPA += this.semesterGPAs.get(i);
        }
        meanGPA = meanGPA / currentSemester;
        return meanGPA;
    }

}
