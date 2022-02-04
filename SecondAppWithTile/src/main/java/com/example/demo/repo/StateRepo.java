package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StateEntity;




@Repository
public interface StateRepo extends CrudRepository<StateEntity,Integer>{

}
