package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
