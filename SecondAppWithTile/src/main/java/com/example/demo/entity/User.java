package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="user")
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long UID;
	
	@NotNull
	private String username;
	
	@NotNull
	private String Email;
	
	@NotNull
	private String pass;
	
	
	
	private String Gender;
	
	
	private Long Monumber;
	
	private String Hobbies;
	
	private String state;
	
	private String city;
	
	private String role;
	
	
	private String Languages;


	public User() {
	
	}


	public User(Long uID, String username, String email, String pass, String gender, Long monumber, String hobbies,
			String state, String city, String role, String languages) {
		super();
		UID = uID;
		this.username = username;
		Email = email;
		this.pass = pass;
		Gender = gender;
		Monumber = monumber;
		Hobbies = hobbies;
		this.state = state;
		this.city = city;
		this.role = role;
		Languages = languages;
	}


	public Long getUID() {
		return UID;
	}


	public void setUID(Long uID) {
		UID = uID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public Long getMonumber() {
		return Monumber;
	}


	public void setMonumber(Long monumber) {
		Monumber = monumber;
	}


	public String getHobbies() {
		return Hobbies;
	}


	public void setHobbies(String hobbies) {
		Hobbies = hobbies;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getLanguages() {
		return Languages;
	}


	public void setLanguages(String languages) {
		Languages = languages;
	}


	@Override
	public String toString() {
		return "User [UID=" + UID + ", username=" + username + ", Email=" + Email + ", pass=" + pass + ", Gender="
				+ Gender + ", Monumber=" + Monumber + ", Hobbies=" + Hobbies + ", state=" + state + ", city=" + city
				+ ", role=" + role + ", Languages=" + Languages + "]";
	}
	
	
	
	

}
