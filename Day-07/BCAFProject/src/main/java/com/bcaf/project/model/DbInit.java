package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcaf.project.repository.RoleRepo;
import com.bcaf.project.repository.UserRepo;

@Service
public class DbInit implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {
		// insert user
		if(this.userRepo.findAll().size()==0) {
			List<User> listUser = new ArrayList<User>();
			listUser.add(new User("user",passwordEncoder.encode("user123"),"user@bcaf.co.id"));
			listUser.add(new User("staff",passwordEncoder.encode("staff123"),"staff@bcaf.co.id"));
			listUser.add(new User("admin",passwordEncoder.encode("admin123"),"admin@bcaf.co.id"));
			listUser.add(new User("manager",passwordEncoder.encode("manager123"),"manager@bcaf.co.id"));
			
			// simpan kedatabase
			this.userRepo.saveAll(listUser);
		}
		
		//insert role
		if(this.roleRepo.findAll().size()==0) {
			List<Role> listRole = new ArrayList<Role>();
			listRole.add(new Role("ROLE_ADMIN","Role Admin"));
			listRole.add(new Role("ROLE_USER","Role User"));
			listRole.add(new Role("ROLE_STAFF","Role Staff"));
			listRole.add(new Role("ROLE_MANAGER","Role Manager"));
			
			// simpan role ke databse
			this.roleRepo.saveAll(listRole);
		}
		
	}

}
