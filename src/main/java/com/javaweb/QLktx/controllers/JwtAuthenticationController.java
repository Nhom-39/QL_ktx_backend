package com.javaweb.QLktx.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;

import com.javaweb.QLktx.Dto.JwtRequest;

@RestController
@RequestMapping("")
public class JwtAuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private UserDetailsService userDetailsService;
  
  @PostMapping("/login")
  public ResponseEntity<?> setAuthentication(@RequestBody JwtRequest authenticationRequest) {
      try {
          UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
          BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
          if (passwordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
              UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
              Authentication authentication = authenticationManager.authenticate(token);
              SecurityContextHolder.getContext().setAuthentication(authentication);
              
              return ResponseEntity.ok(authentication);
          } else {
              return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mật khẩu sai");
          }
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Không tìm thấy tài khoản");
      }
  }


  @GetMapping("/dang-xuat")
  public String unsetAuthentication() {
      try {
          Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();

          if (currentAuth.getName().equals("anonymousUser")) {
              SecurityContextHolder.clearContext();
              return "Logout success";
          } else {
              return "No user login to logout";
          }
      } catch (Exception e) {
          return "Fail";
      }
  }
}

