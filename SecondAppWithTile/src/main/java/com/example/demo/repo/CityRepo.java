package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CityEnity;




@Repository
public interface CityRepo extends CrudRepository<CityEnity,Integer> {
	
	
	public List<CityEnity> findByStid(Integer stateid);

}
