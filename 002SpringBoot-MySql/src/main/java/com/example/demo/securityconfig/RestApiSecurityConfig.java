package com.example.demo.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class RestApiSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 
		 * 
		 */
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}password").roles("USER")
			.and()
			.withUser("manager").password("{noop}password").roles("USER", "MANAGER")
			.and()
			.withUser("admin").password("{noop}password").roles("USER", "MANAGER","ADMIN")
			.and()
			.withUser("monitor").password("{noop}password").roles("MONITOR");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			//includes GET with /all and /{id}
			.antMatchers(HttpMethod.GET,"/api/**").hasAnyRole("USER", "MANAGER", "ADMIN")
			//includes POST with /add and /{id}
			.antMatchers(HttpMethod.POST,"/api/**").hasAnyRole("MANAGER", "ADMIN")
			//includes DELETE with /{id}
			.antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/monitor/**").hasRole("MONITOR")
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
	}

	
	
}
