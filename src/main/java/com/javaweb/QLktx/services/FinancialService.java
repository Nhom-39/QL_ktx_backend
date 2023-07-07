package com.javaweb.QLktx.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.javaweb.QLktx.models.CashCollectionDiary;
import com.javaweb.QLktx.models.ConsumptionDiary;

@Component
public interface FinancialService {
	public ConsumptionDiary save(Long idPhong, ConsumptionDiary consumptionDiary);
	public void delete(Long id);
	public List<ConsumptionDiary> getAll();
	public ResponseEntity<String> saveCashCollection(Long idTieuThu, CashCollectionDiary cashCollectionDiary);
	public List<ConsumptionDiary> getAllConsumptionDiaryByRoom(Long idPhong);
	public CashCollectionDiary getBill(Long idTieuThu);
	
}
