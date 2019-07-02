package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bcaf.project.repository.RoleRepo;
import com.bcaf.project.repository.UserRepo;
import com.bcaf.project.repository.UserRoleRepo;

@Service
public class DbInit implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRoleRepo userRoleRepo;

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
		
		if(this.userRoleRepo.findAll().size()==0) {
			List<UserRole> listUserRole = new ArrayList<UserRole>();
			// mencari user dulu
			User user1 = this.userRepo.findByUsername("user");
			Role role1 = this.roleRepo.findByCode("ROLE_USER");
			listUserRole.add(new UserRole(user1.getId(), role1.getId()));
			
			User user2 = this.userRepo.findByUsername("staff");
			Role role2 = this.roleRepo.findByCode("ROLE_STAFF");
			listUserRole.add(new UserRole(user2.getId(), role2.getId()));
			
			User user3 = this.userRepo.findByUsername("manager");
			Role role3 = this.roleRepo.findByCode("ROLE_MANAGER");
			listUserRole.add(new UserRole(user3.getId(), role3.getId()));
			
			User user4 = this.userRepo.findByUsername("admin");
			Role role4 = this.roleRepo.findByCode("ROLE_ADMIN");
			listUserRole.add(new UserRole(user4.getId(), role4.getId()));
			
			this.userRoleRepo.saveAll(listUserRole);
			
		}
		
		
	}

}
