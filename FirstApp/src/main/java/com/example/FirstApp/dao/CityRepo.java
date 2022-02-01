package com.example.FirstApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstApp.CityEnity;
import com.example.FirstApp.StateEntity;
import com.example.FirstApp.UserRegistration;


@Repository
public interface CityRepo extends CrudRepository<CityEnity,Integer> {
	
	
	public List<CityEnity> findByStid(Integer stateid);

}
