package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Student;
import net.guides.springboot2.springboot2jpacrudexample.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	@Autowired
	private StudentRepository StudentRepository;

	@GetMapping("/Students")
	public List<Student> getAllStudents() {
		return StudentRepository.findAll();
	}

	@GetMapping("/Students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long StudentId)
			throws ResourceNotFoundException {
		Student Student = StudentRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));
		return ResponseEntity.ok().body(Student);
	}

	@PostMapping("/Students")
	public Student createStudent(@Valid @RequestBody Student Student) {
		return StudentRepository.save(Student);
	}

	@PutMapping("/Students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long StudentId,
			@Valid @RequestBody Student StudentDetails) throws ResourceNotFoundException {
		Student Student = StudentRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));


		Student.setEmail(StudentDetails.getEmail());
		Student.setLname(StudentDetails.getLname());
		Student.setFname(StudentDetails.getFname());

		final Student updatedStudent = StudentRepository.save(Student);
		return ResponseEntity.ok(updatedStudent);
	}

	@DeleteMapping("/Students/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long StudentId)
			throws ResourceNotFoundException {
		Student Student = StudentRepository.findById(StudentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + StudentId));

		StudentRepository.delete(Student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
