//package co225-project-group16.Codes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    // non static attributes
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String University;
    private String faculty;
    private String department;
    private int year;
    private int batchNo;
    private int regNo;
    private int totalSemesters;
    // ArrayList to store the grades for each course in every semester
    ArrayList<ArrayList<String>> studentGrades = new ArrayList<ArrayList<String>>();
    // ArrayList to store the GPAs for every semester
    List <Double> semesterGPAs = new ArrayList<>();

    // Constructor for a new sign up
    public Student(String username, String password, String firstName, String lastName, String University, String faculty, int year, int batchNo, int regNo, int totalSemesters){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.University = University;
        this.faculty = faculty;
        this.year = year;
        this.batchNo = batchNo;
        this.regNo = regNo;
        this.totalSemesters = totalSemesters;
        // Initiating the studentGrades 2D ArrayList
        for (int i=1;i<=totalSemesters;++i){
            this.studentGrades.add(new ArrayList<String>());
        }
    }

    // Method to set the department
    public void setDepartment(String department){
        this.department = department;
    }

    // Method to return the username of the student
    public String getUsername(){
        return this.username;
    }

    // Method to return the password of the student
    public String getPassword(){
        return this.password;
    }

    // Method to return the first name of the student
    public String getFirstName(){
        return this.firstName;
    }

    // Method to return the last name of the student
    public String getLastName(){
        return this.lastName;
    }

    // Method to return the University of the student
    public String getUniversity(){
        return this.University;
    }
    
    // Method to return the faculty of the student
    public String getFaculty(){
        return this.faculty;
    }

    // Method to return the department of the student
    public String getDepartment(){
        return this.department;
    }

    // Method to return the Year of the student
    public int getYear(){
        return this.year;
    }

    // Method to return the batch of the student
    public int getBatchNo(){
        return this.batchNo;
    }

    // Method to return the registration number of the student
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
        double YrEndMeanGPA = 0.0;
        int semesterIndex = academicYr*2 - 2;
        // If user has entered the grades of the 1st semsester
        if (this.semesterGPAs.get(semesterIndex) != null){ 
            YrEndMeanGPA = (this.semesterGPAs.get(semesterIndex) + this.semesterGPAs.get(semesterIndex+1)) / 2;
        } else {
            this.setGrades(semesterIndex);
            double semesterIndexGPA = this.getCurrentGPA(semesterIndex, 7);                       // total subjects can be derived from admin class
            YrEndMeanGPA = (semesterIndexGPA  + this.semesterGPAs.get(semesterIndex+1)) / 2;
        }
        return YrEndMeanGPA;
    }

    // Method to calculate the mean GPA upto the current semester
    public double getMeanGPA(int currentSemester){
        double meanGPA =0.0;
        for (int i=0;i<currentSemester;++i){
            if (this.semesterGPAs.get(i) != null) {
                meanGPA += this.semesterGPAs.get(i);
            } else {
                this.setGrades(i);
                double thisSemGPA = this.getCurrentGPA(i, 7);                       // total subjects can be derived from admin class
                meanGPA += thisSemGPA;
            }
        }
        meanGPA = meanGPA / currentSemester;
        return meanGPA;
    }

    // Method to calculate the GPA the student should maintain to obtain his/her expected GPA
    public double getMustHaveGPA(double expectedGPA, int currentSemester){
        double accGPA = 0.0;
        for (int i=0;i<currentSemester;++i){
            if (this.semesterGPAs.get(i) == null){
                this.setGrades(i);
                accGPA += this.getCurrentGPA(i, 7);                                 // total subjects can be derived from admin class
            } else {
                accGPA += this.semesterGPAs.get(i);
            }
        }
        return ((expectedGPA*this.totalSemesters) - accGPA) / (this.totalSemesters - currentSemester);
    }

    // Method to calculate the *minimum marks for a course to achieve the expected grade for a course
    public double getMarksToAchieveGrade(double continousAssessmentsMarks, String expectedGrade){
        double expectedMarks = 0.0;
        switch (expectedGrade) {
            case "A+"   :   expectedMarks = 85.0;
                            break;
            
            case "A"    :   expectedMarks = 80.0;
                            break;
            
            case "A-"   :   expectedMarks = 75.0;
                            break;
            
            case "B+"   :   expectedMarks = 70.0;
                            break;
            
            case "B"    :   expectedMarks = 65.0;
                            break;
            
            case "B-"   :   expectedMarks = 60.0;
                            break;
            
            case "C+"   :   expectedMarks = 55.0;
                            break;

            case "C"    :   expectedMarks += 50.0;
                            break;

            case "C-"   :   expectedMarks = 45.0;
                            break;

            case "D+"   :   expectedMarks = 40.0;
                            break;
                        
            case "D"    :   expectedMarks = 35.0;
                            break;

            default     :   expectedMarks = 30.0;
                            break;
        }
        if (continousAssessmentsMarks > expectedMarks){
            return 0.0;
        } else {
            return expectedMarks - continousAssessmentsMarks;
        }
    }

    // Method to calculate the mean grade for each subject to achieve the next semester expected GPA
    public String getNextSemCourseGrade(int nextSemester, double expectedGPA){
        // int totalSubjects = 7;
        String courseGrade = "";

        if (3.7 < expectedGPA && expectedGPA <= 4.00){
            courseGrade = "A";
        } else if (3.3 < expectedGPA && expectedGPA <= 3.7){
            courseGrade = "A-";
        } else if (3.0 < expectedGPA && expectedGPA <= 3.3){
            courseGrade = "B+";
        } else if (2.7 < expectedGPA && expectedGPA <= 3.0){
            courseGrade = "B";
        } else if (2.3 < expectedGPA && expectedGPA <= 2.7){
            courseGrade = "B-";
        } else if (2.0 < expectedGPA && expectedGPA <= 2.3){
            courseGrade = "C+";
        } else if (1.7 < expectedGPA && expectedGPA <= 2.0){
            courseGrade = "C";
        } else if (1.3 < expectedGPA && expectedGPA <= 1.7){
            courseGrade = "D+";
        } else if (1.0 < expectedGPA && expectedGPA <= 1.3){
            courseGrade = "D";
        }
        return courseGrade;
    }

}
