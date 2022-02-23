//package co225-project-group16.Codes;

public class Student {

    // non static attributes
    String username;
    String password;
    String firstName;
    String lastName;
    String faculty;
    int batchNo;
    int regNo;

    // Constructor for a new sign up
    public Student(String username, String password, String firstName, String lastName, String faculty, int batchNo, int regNo){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.batchNo = batchNo;
        this.regNo = regNo;
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
}
