package com.example.ClinicServer.business;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "cmt")
	private int cmt;
	
	@Column(name = "ngaysinh")
	private String ngaysinh;
	
	@Column(name = "diachi")
	private String diachi;
	
	@Column(name = "bacnghe")
	private String bacnghe;
	
	@Column(name = "thamnien")
	private String thamnien;
	
	@Column(name = "trinhdo")
	private String trinhdo;
	
	@Column(name = "chuyenmon")
	private String chuyenmon;
	
	//@OneToMany(mappedBy = "doctor")
	//private List<Patinet>  = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getCmt() {
		return cmt;
	}

	public void setCmt(int cmt) {
		this.cmt = cmt;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getBacnghe() {
		return bacnghe;
	}

	public void setBacnghe(String bacnghe) {
		this.bacnghe = bacnghe;
	}

	public String getThamnien() {
		return thamnien;
	}

	public void setThamnien(String thamnien) {
		this.thamnien = thamnien;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public String getChuyenmon() {
		return chuyenmon;
	}

	public void setChuyenmon(String chuyenmon) {
		this.chuyenmon = chuyenmon;
	}
	/*
	public List<Doctor> getDoctordd() {
		return doctordd;
	}

	public void setDoctordd(List<Doctor> doctordd) {
		this.doctordd = doctordd;
	}
	
	*/
}
