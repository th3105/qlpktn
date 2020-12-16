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
@Table(name = "nurse")

public class Nurse {
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
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "trinhdo")
	private String trinhdo;
	
	@Column(name = "thamnien")
	private String thamnien;

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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public String getThamnien() {
		return thamnien;
	}

	public void setThamnien(String thamnien) {
		this.thamnien = thamnien;
	}
	
	
}
