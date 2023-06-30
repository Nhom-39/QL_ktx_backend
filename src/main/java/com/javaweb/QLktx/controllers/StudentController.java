package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/admin/quan-ly-sinh-vien")
	public List<Student> getAllStudent() {
		List<Student> students = studentService.getAll();
        return students;
	}
	
	@PutMapping("/admin/quan-ly-sinh-vien/{id}/them-vao-phong")
	public ResponseEntity<String> updateStudentRoom(@PathVariable Long id, @RequestParam("id_phong") Long idPhong) {
//		Student updateStudent = studentService.updateRoom(id, idPhong);
//		return updateStudent;
		return studentService.updateRoom(id, idPhong);
	}
	
	@PutMapping("/admin/quan-ly-sinh-vien/{id}/xoa-khoi-phong")
	public Student removeStudentRoom(@PathVariable Long id) {
		Student updateStudent = studentService.removeStudentRoom(id);
		return updateStudent;
	}
	
	@PutMapping("/admin/quan-ly-sinh-vien/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student updateResponse = studentService.update(id, student);
		return updateResponse;
	}
	

	@GetMapping("/admin/quan-ly-sinh-vien/{id}/edit")
	public Student getStudent(@PathVariable Long id) {
		Student getReponse = studentService.get(id);
		return getReponse;
	}

	@DeleteMapping("/admin/quan-ly-sinh-vien/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
		return "Xoá thông tin sinh viên thành công";
	}
	
	@PutMapping("/user/{masv}/dang-ky-phong")
	public ResponseEntity<String> registerRoom(@PathVariable Integer masv, @RequestParam("id_phong_dang_ky") Long idPhong) {
		return studentService.registerRoom(masv, idPhong);
	}
	
	@GetMapping("/user/{masv}/room")
	public Student getInfoRoom(@PathVariable Integer masv) {
		return studentService.getInfoRoom(masv);
	}
}
