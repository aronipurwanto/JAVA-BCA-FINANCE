package com.bcaf.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaf.project.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	public User findByEmail(String email);
}
