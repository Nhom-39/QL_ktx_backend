package com.javaweb.QLktx.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.CashCollectionDiary;
import com.javaweb.QLktx.models.ConsumptionDiary;
import com.javaweb.QLktx.models.Room;
import com.javaweb.QLktx.repository.ConsumptionDiaryRepository;
import com.javaweb.QLktx.repository.CashCollectionDiaryRepository;
import com.javaweb.QLktx.repository.RoomRepository;
import com.javaweb.QLktx.services.FinancialService;

import jakarta.transaction.Transactional;

@Service
public class FinancialServiceImpl implements FinancialService{
	@Autowired
	private ConsumptionDiaryRepository consumptionDiaryRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private CashCollectionDiaryRepository cashCollectionDiaryRepository;
	
	@Transactional
	public ConsumptionDiary save(Long idPhong, ConsumptionDiary consumptionDiary) {
		Room room = roomRepository.findById(idPhong)
		        .orElseThrow(() -> new RuntimeException("Room not found with id: " + idPhong));
		ConsumptionDiary cd = new ConsumptionDiary();
		cd.setRoom(room);
		cd.setThang(consumptionDiary.getThang());
		cd.setSoLuongDien(consumptionDiary.getSoLuongDien());
		cd.setSoLuongNuoc(consumptionDiary.getSoLuongNuoc());
		ConsumptionDiary createResponse = consumptionDiaryRepository.save(cd);
		return createResponse;
	}
	
	@Transactional
	public void delete(Long id) {
		cashCollectionDiaryRepository.deleteByIdTieuThu(id);
		consumptionDiaryRepository.deleteById(id);
	}
	
	@Transactional
	public List<ConsumptionDiary> getAll() {
	    return consumptionDiaryRepository.findAll();
	}
	
	@Transactional
	public ResponseEntity<String> saveCashCollection(Long idTieuThu, CashCollectionDiary cashCollectionDiary) {
		ConsumptionDiary consumptionDiary = consumptionDiaryRepository.findById(idTieuThu)
		        .orElseThrow(() -> new RuntimeException("ConsumptionDiary not found with id: " + idTieuThu));
		boolean cashCD = cashCollectionDiaryRepository.existsByIdTieuThu(idTieuThu);
		if(cashCD) return ResponseEntity.badRequest().body("Đã thu tiền trước đó.");
		CashCollectionDiary ccd = new CashCollectionDiary();
		ccd.setConsumptionDiary(consumptionDiary);
		ccd.setNgayThu(cashCollectionDiary.getNgayThu());
		ccd.setSoTien(cashCollectionDiary.getSoTien());
		ccd.setGhiChu(cashCollectionDiary.getGhiChu());
		CashCollectionDiary createResponse = cashCollectionDiaryRepository.save(ccd);
		return ResponseEntity.ok("Xác nhận thu tiền thành công.");
	}
	
	@Transactional
	public List<ConsumptionDiary> getAllConsumptionDiaryByRoom(Long idPhong) {
	    return consumptionDiaryRepository.findAllConsumptionDiaryByRoom(idPhong);
	}
	
	@Transactional
	public CashCollectionDiary getBill(Long idTieuThu) {
	    return cashCollectionDiaryRepository.findByIdTieuThu(idTieuThu);
	}
}
