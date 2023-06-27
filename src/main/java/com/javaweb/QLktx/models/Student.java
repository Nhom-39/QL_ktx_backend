package com.javaweb.QLktx.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "sinh_vien")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "email")
	private String email;
	
	@Column(name = "ma_so_sinh_vien")
	private Integer maSV;
	
	@Column(name = "ngay_sinh")
	private LocalDate ngaySinh;
	
	@Column(name = "gioi_tinh")
	private String gioiTinh;
	
	@Column(name = "so_dien_thoai")
	private Integer soDienThoai;

	@ManyToOne
    @JoinColumn(name = "id_phong")
    private Room room;
	
	@ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "id_phong_dang_ky")
    private Room roomRegister;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMaSV() {
		return maSV;
	}

	public void setMaSV(Integer maSV) {
		this.maSV = maSV;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Integer getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(Integer soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Room getRoom() {
	    return room;
	}

	public void setRoom(Room room) {
	    this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoomRegister() {
		return roomRegister;
	}

	public void setRoomRegister(Room roomRegister) {
		this.roomRegister = roomRegister;
	}
	
	
}
