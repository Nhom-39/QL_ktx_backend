package com.javaweb.QLktx.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "phan_hoi")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "id_sinh_vien")
    private Student student;

	@Column(name = "tieu_de")
	private String tieuDe;

	@Column(name = "noi_dung", length = 1500)
	private String noiDung;
	
	private Timestamp createdAt;

	@Column(name = "tra_loi", length = 1500)
    private String traLoi;
	
	@ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getTraLoi() {
		return traLoi;
	}

	public void setTraLoi(String traLoi) {
		this.traLoi = traLoi;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
