package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.models.Student;
import com.javaweb.QLktx.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public List<Student> getAllStudent() {
		List<Student> students = studentService.getAll();
        return students;
	}

	@PostMapping("/create")
	public Student createStudent1(@RequestBody Student student) {
		Student createResponse = studentService.save(student);
		return createResponse;
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student) {
		Student updateResponse = studentService.update(student);
		return updateResponse;
	}

	@GetMapping("/{id}/edit")
	public Student getStudent(@PathVariable Long id) {
		Student getReponse = studentService.get(id);
		return getReponse;
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
		return "Record deleted succesfully";
	}
}
