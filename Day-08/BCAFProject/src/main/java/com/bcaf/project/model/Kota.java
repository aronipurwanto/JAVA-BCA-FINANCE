package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_kota")
public class Kota {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kota_index")
	@TableGenerator(name="tbl_kota_index", table = "tbl_index", 
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	@Column(name="id")
	private Long id;
	
	@Column(name="kota_code", nullable = false, length = 64)
	private String code;
	
	@Column(name="kota_name", nullable = false, length = 100)
	private String name;
	
	@Column(name="provinsi_id",nullable = false)
	private Long provinsiId;
	
	@ManyToOne
	@JoinColumn(name="provinsi_id", foreignKey = @ForeignKey(name="fk_kota_provinsi_id"), insertable = false, updatable = false)
	private Provinsi provinsi;
	
	public Kota() {
	}
	
	public Kota(String code, String name) {
		this.name=name;
		this.code=code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(Long provinsiId) {
		this.provinsiId = provinsiId;
	}

	public Provinsi getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}
}
