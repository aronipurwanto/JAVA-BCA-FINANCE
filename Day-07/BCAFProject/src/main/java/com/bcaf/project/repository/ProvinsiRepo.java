package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Provinsi;

@Repository
public interface ProvinsiRepo extends JpaRepository<Provinsi, Long> {

}
