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

import co225.project.group16.model.Result;
import co225.project.group16.repository.ResultRepository;


@RestController
@RequestMapping("/result")
public class ResultController {
	@Autowired
	ResultRepository resultRepository;
	
	@GetMapping("/all")
	public List<Result> getAllResult() {
		return	resultRepository.findAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Result> createResult(@RequestBody Result result) {
		try {
			Result _result = resultRepository
					.save(new Result(result.getStudentID(), result.getSemester(), result.getGpa()));
			return new ResponseEntity<>(_result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{studentID}")
	public ResponseEntity<Result> getResultById(@PathVariable("studentID") long studentID) {
		Optional<Result> result = resultRepository.findById(studentID);
		 
		if (result.isPresent()) {
			return new ResponseEntity<>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{studentID}")
	public ResponseEntity<Result> updateResult(@PathVariable("studentID") long studentID, @RequestBody Result result) {
		Optional<Result> resultData = resultRepository.findById(studentID);
		if (resultData.isPresent()) {
			Result _post = resultData.get();
			_post.setStudentID(result.getStudentID());
			_post.setSemester(result.getSemester());
			_post.setGpa(result.getGpa());
			return new ResponseEntity<>(resultRepository.save(_post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{studentID}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("studentID") long studentID) {
		try {
			resultRepository.deleteById(studentID);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<HttpStatus> deleteAllPosts() {
		try {
			resultRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
