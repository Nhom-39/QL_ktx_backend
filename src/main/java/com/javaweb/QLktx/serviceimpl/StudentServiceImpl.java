package com.javaweb.QLktx.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.Room;
import com.javaweb.QLktx.models.Student;
import com.javaweb.QLktx.repository.RoomRepository;
import com.javaweb.QLktx.repository.StudentRepository;
import com.javaweb.QLktx.services.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public Student update(Long id, Student student) {
		Student st = studentRepository.findById(id)
		       .orElseThrow(() -> new RuntimeException("SinhVien not found with id: " + id));
		
		st.setHoTen(student.getHoTen());
		st.setEmail(student.getEmail());
		st.setGioiTinh(student.getGioiTinh());
		st.setMaSV(student.getMaSV());
		st.setNgaySinh(student.getNgaySinh());
		st.setSoDienThoai(student.getSoDienThoai());
		Student updateResponse = studentRepository.save(st);
		return updateResponse;
	}
	
	@Transactional
	public ResponseEntity<String> updateRoom(Long id, Long idPhong) {
		Student student = studentRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		Room room = roomRepository.findById(idPhong)
		        .orElseThrow(() -> new RuntimeException("Room not found with id: " + idPhong));
		List<Student> studentList = studentRepository.findByIdPhong(idPhong);
		Integer soLuongMax = roomRepository.findSoLuongMaxById(idPhong);
		if(studentList.size() >= soLuongMax) {
			return ResponseEntity.badRequest().body("Số lượng sinh viên trong phòng đã vượt quá giới hạn.");
		}
		student.setRoom(room);
		studentRepository.save(student);
//		return updateResponse;
		return ResponseEntity.ok("Cập nhật phòng thành công.");
	}
	
	@Transactional
	public Student removeStudentRoom(Long id) {
		Student student = studentRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		student.setRoom(null);
		Student updateResponse = studentRepository.save(student);
		return updateResponse;
	}

	@Transactional
	public Student get(Long id) {
		Optional<Student> response = studentRepository.findById(id);
		Student getResponse = response.get();
		return getResponse;
	}

	@Transactional
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
	@Transactional
	public List<Student> getAll() {
	    return studentRepository.findAll();
	}
}