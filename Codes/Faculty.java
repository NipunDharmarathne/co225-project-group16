import java.util.ArrayList;
import java.util.List;
public class Faculty {

    // static attributes
    public static List <Faculty> FacultyArray = new ArrayList<>();


    // non static attributes
    private String University;
    private String faculty;
    public List <Student> facultyStudents;
    public List <Department> facultyDepartments;

    public Faculty(String University, String faculty){
        this.University = University;
        this.faculty = faculty;
        this.facultyStudents = new ArrayList<>();
        this.facultyDepartments = new ArrayList<>();
    }

    // Method to return the University 
    public String getUniversity(){
        return this.University;
    }
    
    // Method to return the faculty
    public String getFaculty(){
        return this.faculty;
    }

    
}
