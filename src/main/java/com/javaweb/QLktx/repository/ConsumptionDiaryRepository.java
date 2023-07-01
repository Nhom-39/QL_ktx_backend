package com.javaweb.QLktx.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.ConsumptionDiary;

@Repository
public interface ConsumptionDiaryRepository extends JpaRepository<ConsumptionDiary, Serializable>{
	@Query("SELECT c FROM ConsumptionDiary c WHERE c.room.id = :idPhong")
    List<ConsumptionDiary> findAllConsumptionDiaryByRoom(Long idPhong);
}
