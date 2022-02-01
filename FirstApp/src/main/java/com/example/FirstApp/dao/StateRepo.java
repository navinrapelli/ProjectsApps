package com.example.FirstApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstApp.StateEntity;


@Repository
public interface StateRepo extends CrudRepository<StateEntity,Integer>{

}
