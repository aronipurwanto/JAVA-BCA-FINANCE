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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_kecamatan")
public class Kecamatan {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kecamatan_index")
	@TableGenerator(name="tbl_kecamatan_index", table = "tbl_index", 
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	@Column(name="id")
	private Long id;
	
	@Column(name="kecamatan_code", nullable = false, length = 64)
	private String code;
	
	@Column(name="kecamatan_name", nullable = false, length = 100)
	private String name;
	
	@Column(name="kota_id", nullable = false)
	private Long kotaId;
	
	@ManyToOne
	@JoinColumn(name="kota_id", foreignKey = @ForeignKey(name="fk_kec_kota_id"), insertable = false, updatable = false)
	private Kota kota;
	
	public Kecamatan() {
		
	}
	
	public Kecamatan(String code, String name) {
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

	public Long getKotaId() {
		return kotaId;
	}

	public void setKotaId(Long kotaId) {
		this.kotaId = kotaId;
	}

	public Kota getKota() {
		return kota;
	}

	public void setKota(Kota kota) {
		this.kota = kota;
	}
}
