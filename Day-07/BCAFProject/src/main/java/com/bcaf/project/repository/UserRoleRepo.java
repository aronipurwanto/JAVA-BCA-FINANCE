package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

}
