package com.javaweb.QLktx.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.Dto.UserDto;
import com.javaweb.QLktx.repository.StudentRepository;
import com.javaweb.QLktx.repository.UserRepository;
import com.javaweb.QLktx.models.*;

@Service
public class RegisterServiceImpl {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public boolean existsByUsername(String taiKhoan) {
        return userRepository.findByUsername(taiKhoan).isPresent();
    }

    public void registerUser(UserDto userDto) {
    	String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
    	User user = new User(userDto.getUsername(), encodedPassword, "ADMIN");
        userRepository.save(user);
        Student student = new Student();
        student.setUser(user);
        student.setMaSV(userDto.getMaSV());
        student.setEmail(userDto.getEmail());
        student.setHoTen(userDto.getHoTen());
        student.setGioiTinh(userDto.getGioiTinh());
        student.setNgaySinh(userDto.getNgaySinh());
        student.setSoDienThoai(userDto.getSoDienThoai());
        studentRepository.save(student);
    }

}
