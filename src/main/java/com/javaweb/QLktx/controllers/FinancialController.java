package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.models.CashCollectionDiary;
import com.javaweb.QLktx.models.ConsumptionDiary;
import com.javaweb.QLktx.services.FinancialService;

@RestController
@RequestMapping("")
public class FinancialController {
	
	@Autowired
	private FinancialService financialService;
	
	@PostMapping("/admin/quan-ly-tai-chinh/create/{idPhong}")
	public ConsumptionDiary createConsumptionDiary(@PathVariable Long idPhong, @RequestBody ConsumptionDiary consumptionDiary) {
		ConsumptionDiary createResponse = financialService.save(idPhong, consumptionDiary);
		return createResponse;
	}
	
	@PostMapping("/admin/quan-ly-tai-chinh/thu-tien/create/{idTieuThu}")
	public CashCollectionDiary createCashCollection(@PathVariable Long idTieuThu, @RequestBody CashCollectionDiary cashCollectionDiary) {
		CashCollectionDiary createResponse = financialService.saveCashCollection(idTieuThu, cashCollectionDiary);
		return createResponse;
	}
	
	@GetMapping("/admin/quan-ly-tai-chinh")
	public List<ConsumptionDiary> getAllConsumptionDiary() {
		List<ConsumptionDiary> consumptionDiary = financialService.getAll();
        return consumptionDiary;
	}
	
	@DeleteMapping("/admin/quan-ly-tai-chinh/{id}")
	public String deleteConsumptionDiary(@PathVariable Long id) {
		financialService.delete(id);
		return "Xóa thành công";
	}
	
	@GetMapping("/user/theo-doi-phong/tai-chinh/{idPhong}")
	public List<ConsumptionDiary> getAllConsumptionDiaryByRoom(@PathVariable Long idPhong) {
		List<ConsumptionDiary> consumptionDiary = financialService.getAllConsumptionDiaryByRoom(idPhong);
        return consumptionDiary;
	}
	
	@GetMapping("/user/theo-doi-phong/tai-chinh/hoa-don/{idTieuThu}")
	public CashCollectionDiary getBill(@PathVariable Long idTieuThu) {
		CashCollectionDiary cashCollectionDiary = financialService.getBill(idTieuThu);
        return cashCollectionDiary;
	}
}
