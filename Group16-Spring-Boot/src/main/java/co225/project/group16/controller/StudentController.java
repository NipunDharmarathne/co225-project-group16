package co225.project.group16.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co225.project.group16.model.Student;
import co225.project.group16.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return	studentRepository.findAll();

	}
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			Student _student = studentRepository
					.save(new Student(student.getRegNo(), student.getUsername(), student.getFirstName(), student.getLastName(), student.getSemester(), student.isRegistered()));
			return new ResponseEntity<>(_student, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{regNo}")
	public ResponseEntity<Student> getStudentById(@PathVariable("regNo") long regNo) {
		Optional<Student> student = studentRepository.findById(regNo);
		 
		if (student.isPresent()) {
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{regNo}")
	public ResponseEntity<Student> updateStudent(@PathVariable("regNo") long regNo, @RequestBody Student student) {
		Optional<Student> studentData = studentRepository.findById(regNo);
		if (studentData.isPresent()) {
			Student _post = studentData.get();
			_post.setRegNo(student.getRegNo());
			_post.setUsername(student.getUsername());
			_post.setFirstName(student.getFirstName());
			_post.setLastName(student.getLastName());
			return new ResponseEntity<>(studentRepository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{regNo}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("regNo") long regNo) {
		try {
			studentRepository.deleteById(regNo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<HttpStatus> deleteAllPosts() {
		try {
			studentRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
 	@GetMapping("/student/registered")
	public ResponseEntity<List<Student>> findRegisteredStudents() {
		try {
			List<Student> registeredStudents = studentRepository.findRegisteredStudents(true);
			if (registeredStudents.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(registeredStudents, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
