package com.javaweb.QLktx.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{

    // Vì WebSecurityConfigurerAdapter đã deprecated nên ta sẽ làm theo cách khác
    // https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

    @Bean
    @Autowired
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }

    @Bean
    @Autowired
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService) 
        throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder)
            .and()
            .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
      return new HttpSessionListener() {
        @Override
        public void sessionCreated(HttpSessionEvent ev) {
          System.out.println("Session created");
        }

        @Override
        public void sessionDestroyed(HttpSessionEvent ev) {
          System.out.println("Session destroyed");
        }
      };
    }

    // permitAll() : Cho phép tất cả phía trước
    // authenticated() : Phải xác thực
    // antMatchers("/path") : Setup các đường dẫn
    // cors() , csrf() : Các thuộc tính bảo vệ website ("có thể dùng kèm . disable()")
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http
//    			.cors(
//    					cors -> cors.disable()
//    			)
                .csrf(
                  csrf -> csrf.disable()
                )
            .authorizeHttpRequests(authorizeRequests -> 
              authorizeRequests
//                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/admin/quan-ly-phong/**").permitAll()
                .requestMatchers("/admin/quan-ly-sinh-vien/**").permitAll()
                .anyRequest().permitAll()
            )
            
            .sessionManagement(session -> session
              .maximumSessions(1)
              .maxSessionsPreventsLogin(true)
            );
//            .formLogin(
//              formlogin -> formlogin.permitAll()
//            );
//            .logout(
//            	formLogout -> formLogout.permitAll()
//            );
            
        return http.build();
    }
}

