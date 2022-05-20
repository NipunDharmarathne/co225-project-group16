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

import co225.project.group16.model.Admin;
import co225.project.group16.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/all")
	public List<Admin> getAllAdmin() {
		return	adminRepository.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		try {
			Admin _admin = adminRepository
					.save(new Admin(admin.getRegNo(), admin.getUsername(), admin.getPassword(),admin.getFullName(), admin.getUniversity(), admin.getFaculty(), admin.getYear(), admin.getTotalSubjectsInFirstSem(), admin.getTotalSubjectsInSecondSem(), admin.isRegistered()));
			return new ResponseEntity<>(_admin, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{regNo}")
	public ResponseEntity<Admin> getStudentById(@PathVariable("regNo") long regNo) {
		Optional<Admin> admin = adminRepository.findById(regNo);
		 
		if (admin.isPresent()) {
			return new ResponseEntity<>(admin.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{regNo}")
	public ResponseEntity<Admin> updateStudent(@PathVariable("regNo") long regNo, @RequestBody Admin admin) {
		Optional<Admin> adminData = adminRepository.findById(regNo);
		if (adminData.isPresent()) {
			Admin _post = adminData.get();
			_post.setRegNo(admin.getRegNo());
			_post.setUsername(admin.getUsername());
			_post.setPassword(admin.getPassword());
			_post.setFullName(admin.getFullName());
			_post.setUniversity(admin.getUniversity());
			_post.setFaculty(admin.getFaculty());
			_post.setDepartment(admin.getDepartment());
			_post.setYear(admin.getYear());
			_post.setTotalSubjectsInFirstSem(admin.getTotalSubjectsInFirstSem());
			_post.setTotalSubjectsInSecondSem(admin.getTotalSubjectsInSecondSem());
			return new ResponseEntity<>(adminRepository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{regNo}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("regNo") long regNo) {
		try {
			adminRepository.deleteById(regNo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<HttpStatus> deleteAllPosts() {
		try {
			adminRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
