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
@Table(name="tbl_kelurahan")
public class Kelurahan {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tbl_kelurahan_index")
	@TableGenerator(name="tbl_kelurahan_index", table = "tbl_index", 
		pkColumnName = "index_id", valueColumnName = "index_value",
		allocationSize = 1, initialValue = 0)
	@Column(name="id")
	private Long id;
	
	@Column(name="kelurahan_code", nullable = false, length = 64)
	private String code;
	
	@Column(name="kelurahan_name", nullable = false, length = 100)
	private String name;
	
	@Column(name="kecamatan_id", nullable = false)
	private Long kecamatanId;
	
	@ManyToOne
	@JoinColumn(name="kecamatan_id", foreignKey = @ForeignKey(name="fk_kel_kec_id"), insertable = false, updatable = false)
	private Kecamatan kecamatan;
	
	public Kelurahan() {
	}
	
	public Kelurahan(String code, String name) {
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

	public Long getKecamatanId() {
		return kecamatanId;
	}

	public void setKecamatanId(Long kecamatanId) {
		this.kecamatanId = kecamatanId;
	}

	public Kecamatan getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(Kecamatan kecamatan) {
		this.kecamatan = kecamatan;
	}
}
