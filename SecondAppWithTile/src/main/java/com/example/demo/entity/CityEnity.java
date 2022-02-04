package com.example.demo.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="city")
public class CityEnity  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cityid;
	
	@NotNull
	private int stid;
	
	@NotNull
	private String cityname;

	public CityEnity() {
		
	}

	public CityEnity(int cityid, int stid, String cityname) {
		
		this.cityid = cityid;
		this.stid = stid;
		this.cityname = cityname;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	public String toString() {
		return "CityEnity [cityid=" + cityid + ", stid=" + stid + ", cityname=" + cityname + "]";
	}
	
	
	

}
