package com.bcaf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Kota;

@Repository
public interface KotaRepo extends JpaRepository<Kota, Long> {
	public List<Kota> findByProvinsiId(Long provinsiId);
	public Kota findByCode(String code);
	public Kota findByName(String name);
}
