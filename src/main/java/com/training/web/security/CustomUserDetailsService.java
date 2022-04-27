package com.training.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.web.security.entities.User;
import com.training.web.security.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findByUsername(username);
		if(user ==null)
		{
			throw new UsernameNotFoundException(username+"not registered");
		}
		return new CustomUserDetails(user);
	}


}
