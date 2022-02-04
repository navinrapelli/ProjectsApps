package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;



@Service
public class UserService {

	
	
	@Autowired
	private UserRepo repo;
	
	
	
	public User addUser(User user)
	{
		return repo.save(user);
		
		
	}
	
	
	
	public User editUser(User user)
	{
		return repo.save(user);
		
		
	}
	
	
	public List<User> getAllUsers()
	{
		List<User> users=(List<User>) repo.findAll();
		
		System.out.println(users.size());
		
		
		return users ;
		
		
		
	}
	
	
	public  User getUser(Long UID){
		return  repo.findById(UID).get();
		
		
		
	}
	
	
	public void deleteUser(Long UID)
	{
		
		repo.deleteById(UID);
		
		
	}
	
	
	public User getUserwithUsername(String username){
		return  repo.findByUsername(username);
		
		
		
	}
	
	

	
}