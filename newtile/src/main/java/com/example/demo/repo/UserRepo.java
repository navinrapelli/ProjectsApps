package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.entity.User;



public interface UserRepo extends CrudRepository<User,Long> {
	public User findByUsernameAndPass(String username, String password);
	
	

	public User findByUsername(String Username);
}
