package com.example.FirstApp.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstApp.UserRegistration;


@Repository
public interface UserRepo extends CrudRepository<UserRegistration,Long> {
	


	public UserRegistration findByUsernameAndPass(String Username, String Pass);


}
