package com.javaweb.QLktx.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhat_ky_thu_tien")
public class CashCollectionDiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_tieu_thu")
    private ConsumptionDiary consumptionDiary;
	
	@Column(name = "ngay_thu")
	private LocalDate ngayThu;
	
	@Column(name = "so_tien")
	private Integer soTien;
	
	@Column(name = "ghi_chu", length = 1500)
    private String ghiChu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConsumptionDiary getConsumptionDiary() {
		return consumptionDiary;
	}

	public void setConsumptionDiary(ConsumptionDiary consumptionDiary) {
		this.consumptionDiary = consumptionDiary;
	}

	public LocalDate getNgayThu() {
		return ngayThu;
	}

	public void setNgayThu(LocalDate ngayThu) {
		this.ngayThu = ngayThu;
	}

	public Integer getSoTien() {
		return soTien;
	}

	public void setSoTien(Integer soTien) {
		this.soTien = soTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
