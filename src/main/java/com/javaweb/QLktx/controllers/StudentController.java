package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.models.Student;
import com.javaweb.QLktx.services.StudentService;

@RestController
@RequestMapping("/admin/quan-ly-sinh-vien")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public List<Student> getAllStudent() {
		List<Student> students = studentService.getAll();
        return students;
	}
	
	@PutMapping("/{id}/them-vao-phong")
	public Student updateStudentRoom(@PathVariable Long id, @RequestParam("id_phong") Long idPhong) {
		Student updateStudent = studentService.updateRoom(id, idPhong);
		return updateStudent;
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
		return "Xoá thông tin sinh viên thành công";
	}
}
