package com.javaweb.QLktx.Dto;

import java.time.LocalDate;

public class UserDto {
	private String username;
    private String password;
    private String hoTen;
    private Integer maSV;
    private String email;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private Integer soDienThoai;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Integer getMaSV() {
		return maSV;
	}
	public void setMaSV(Integer maSV) {
		this.maSV = maSV;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Integer getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(Integer soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
    
    
}
