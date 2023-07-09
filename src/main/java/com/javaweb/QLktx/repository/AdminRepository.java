package com.javaweb.QLktx.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.Admin;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, Serializable>{
	@Query("SELECT a FROM Admin a WHERE a.user.id = ?1")
	Admin findByIdUser(Long idUser);
}
