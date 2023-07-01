package com.javaweb.QLktx.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.QLktx.models.CashCollectionDiary;

@Repository
public interface CashCollectionDiaryRepository extends JpaRepository<CashCollectionDiary, Serializable>{
	@Query("SELECT c FROM CashCollectionDiary c WHERE c.consumptionDiary.id = :idTieuThu")
	CashCollectionDiary findByIdTieuThu(Long idTieuThu);
	
	@Modifying
    @Query("DELETE FROM CashCollectionDiary c WHERE c.consumptionDiary.id = :idTieuThu")
    void deleteByIdTieuThu(Long idTieuThu);
}
