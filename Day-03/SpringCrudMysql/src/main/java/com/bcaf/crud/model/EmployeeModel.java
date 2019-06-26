package com.bcaf.crud.model;

import java.util.Date;

public class EmployeeModel {
	private Integer id;
	private String nama;
	private String alamat;
	private String tptLahir;
	private Date tglLahir;
	private String agama;
	private String gender;
	private String golDarah;
	private Integer departmentId;
	private Integer jobtitleId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getTptLahir() {
		return tptLahir;
	}
	public void setTptLahir(String tptLahir) {
		this.tptLahir = tptLahir;
	}
	public Date getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}
	public String getAgama() {
		return agama;
	}
	public void setAgama(String agama) {
		this.agama = agama;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGolDarah() {
		return golDarah;
	}
	public void setGolDarah(String golDarah) {
		this.golDarah = golDarah;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getJobtitleId() {
		return jobtitleId;
	}
	public void setJobtitleId(Integer jobtitleId) {
		this.jobtitleId = jobtitleId;
	}
	
}
