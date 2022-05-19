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

import co225.project.group16.model.Course;
import co225.project.group16.repository.CourseRepository;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/all")
	public List<Course> getAllCourse() {
		return	courseRepository.findAll();

	}
	
	@PostMapping("/create")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		try {
			Course _course = courseRepository
					.save(new Course(course.getCourseCode(), course.getAdminID(), course.getCourseName(),course.getCredit(), course.getSemester()));
			return new ResponseEntity<>(_course, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{courseCode}")
	public ResponseEntity<Course> getStudentById(@PathVariable("courseCode") long courseCode) {
		Optional<Course> course = courseRepository.findById(courseCode);
		 
		if (course.isPresent()) {
			return new ResponseEntity<>(course.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{courseCode}")
	public ResponseEntity<Course> updateStudent(@PathVariable("courseCode") long courseCode, @RequestBody Course course) {
		Optional<Course> courseData = courseRepository.findById(courseCode);
		if (courseData.isPresent()) {
			Course _post = courseData.get();
			_post.setCourseCode(course.getCourseCode());
			_post.setAdminID(course.getAdminID());
			_post.setCourseName(course.getCourseName());
			_post.setCredit(course.getCredit());
			_post.setSemester(course.getSemester());
			return new ResponseEntity<>(courseRepository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{courseCode}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("courseCode") long courseCode) {
		try {
			courseRepository.deleteById(courseCode);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<HttpStatus> deleteAllPosts() {
		try {
			courseRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
