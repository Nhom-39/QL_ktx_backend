package com.javaweb.QLktx.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Serializable> {

}
