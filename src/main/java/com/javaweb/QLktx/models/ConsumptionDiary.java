package com.javaweb.QLktx.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhat_ky_tieu_thu")
public class ConsumptionDiary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_phong")
    private Room room;
	
	@Column(name = "thang")
	private Integer thang;
	
	@Column(name = "so_luong_dien")
	private Integer soLuongDien;
	
	@Column(name = "so_luong_nuoc")
	private Integer soLuongNuoc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getThang() {
		return thang;
	}

	public void setThang(Integer thang) {
		this.thang = thang;
	}

	public Integer getSoLuongDien() {
		return soLuongDien;
	}

	public void setSoLuongDien(Integer soLuongDien) {
		this.soLuongDien = soLuongDien;
	}

	public Integer getSoLuongNuoc() {
		return soLuongNuoc;
	}

	public void setSoLuongNuoc(Integer soLuongNuoc) {
		this.soLuongNuoc = soLuongNuoc;
	}
}
