package com.bcaf.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_jobtitle")
public class JobTitleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "jobtitle_index")
	@TableGenerator(name="jobtitle_index",table = "tbl_index", 
		pkColumnName = "index_id", valueColumnName = "index_value", 
		initialValue = 0, allocationSize = 1)
	@Column(name="id")
	private Integer id;
	
	@Column(name="code", nullable = false, length = 10)
	private String code;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name="description", nullable = false, length = 225)
	private String description;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
