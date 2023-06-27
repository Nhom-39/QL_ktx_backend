package com.javaweb.QLktx.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	Optional<User> findByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.username = ?1")
	User findByTaiKhoan(String username);
}
