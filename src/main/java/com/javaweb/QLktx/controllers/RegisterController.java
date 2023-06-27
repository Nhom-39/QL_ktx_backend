package com.javaweb.QLktx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.Dto.UserDto;
import com.javaweb.QLktx.serviceimpl.RegisterServiceImpl;

@RestController
@RequestMapping("/dang-ky")
public class RegisterController {
	@Autowired
    private RegisterServiceImpl userService;

    @PostMapping("")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        if (userService.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tài khoản đã được sử dụng");
        }

        userService.registerUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Đăng ký tài khoản thành công");
    }
}