package com.javaweb.QLktx.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Serializable> {
	@Query("SELECT r FROM Room r WHERE r.tenPhong = ?1 OR r.toaNha = ?1")
    List<Room> findByTenPhongOrToaNha(String query);
	
	@Query("SELECT r.soLuongMax FROM Room r WHERE r.id = ?1")
	Integer findSoLuongMaxById(Long idPhong);
}
