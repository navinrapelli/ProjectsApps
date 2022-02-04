package com.example.demo.entity;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name="state")
public class StateEntity implements Serializable {

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stateid;
	
	@NotNull
	private String statename;

	
	
	
	
	
	public StateEntity() {
	
	}






	public StateEntity(int stateid, String statename) {
		
		this.stateid = stateid;
		this.statename = statename;
	}






	public int getStateid() {
		return stateid;
	}






	public void setStateid(int stateid) {
		this.stateid = stateid;
	}






	public String getStatename() {
		return statename;
	}






	public void setStatename(String statename) {
		this.statename = statename;
	}






	@Override
	public String toString() {
		return "StateEntity [stateid=" + stateid + ", statename=" + statename + "]";
	}
	
	
	
	
	
}
