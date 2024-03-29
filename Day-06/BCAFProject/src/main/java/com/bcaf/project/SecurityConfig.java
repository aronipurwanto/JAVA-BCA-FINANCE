package com.bcaf.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("user1").password(passwordEncoder().encode("user123")).roles("USER")
			.and()
			.withUser("user2").password(passwordEncoder().encode("user123")).roles("USER","ADMIN","MANAGER")
			.and()
			.withUser("admin1").password(passwordEncoder().encode("admin123")).roles("ADMIN")
			.and()
			.withUser("manager1").password(passwordEncoder().encode("manager123")).roles("MANAGER");
	}
	
	@Override
	public void configure(final HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").hasRole("USER")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/manager").hasRole("MANAGER")
		.antMatchers("/login*").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
