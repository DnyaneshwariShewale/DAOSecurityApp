package com.training.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService userDetailsService ;
	@Bean 
	AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers("/h2")
		.permitAll()
		.antMatchers("/regularuser")
		.hasAuthority("/USER")
		.antMatchers("/admin")
		.hasAuthority("ADMIN")
		.anyRequest()
		.authenticated();
	}
}
