package com.javaweb.QLktx.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable>{
	
	@Query("SELECT s FROM Student s WHERE s.room.id = ?1")
	List<Student> findByIdPhong(Long idPhong);
	
	@Modifying
    @Query("UPDATE Student s SET s.room = null WHERE s.room.id = ?1")
    void removeRoomReference(Long idPhong);
	
	@Query("SELECT s FROM Student s WHERE s.maSV = ?1")
	Student findByMaSV(Integer masv);
	
}
