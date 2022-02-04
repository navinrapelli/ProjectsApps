package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomeUserDetail;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;




@Service
public class CustomUserDetailService implements UserDetailsService {

	
    @Autowired
	private	UserRepo repo;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= this.repo.findByUsername(username);
		if (user ==null)
		{
			
			throw new UsernameNotFoundException("No_USER");
		}
		
		return new CustomeUserDetail(user);
	}

}
