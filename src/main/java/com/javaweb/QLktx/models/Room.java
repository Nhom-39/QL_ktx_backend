package com.javaweb.QLktx.models;

import jakarta.persistence.*;

@Entity
@Table(name = "phong")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ten_phong")
	private String tenPhong;

	@Column(name = "toa_nha")
	private String toaNha;
	
	@Column(name = "so_luong_max")
	private Integer soLuongMax;
	
	@Column(name = "gia_phong")
	private Integer giaPhong;
	
	@Column(name = "thong_tin")
	private String thongTin;
	
	@Column(name = "image")
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getToaNha() {
		return toaNha;
	}

	public void setToaNha(String toaNha) {
		this.toaNha = toaNha;
	}
	
	public Integer getSoLuongMax() {
		return soLuongMax;
	}

	public void setSoLuongMax(Integer soLuongMax) {
		this.soLuongMax = soLuongMax;
	}

	public Integer getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(Integer giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
