package com.example.FirstApp;

import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sun.istack.NotNull;


@Entity
@Table(name="user")
public class UserRegistration implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long UID;
	
	@NotNull
	private String username;
	
	@NotNull
	private String Email;
	
	@NotNull
	private String pass;
	
	     //used to storing the lar
	@NotNull
	@Lob
	private byte[]image;
	
	private String Gender;
	
	
	private Long Monumber;
	
	private String Hobbies;
	
	private String State;
	
	private String City;
	
	
	private String Languages;
	

	public UserRegistration() {
		
	}



	
	
	
	









	public UserRegistration(Long uID, String username, String email, String pass, byte[] image, String gender,
			Long monumber, String hobbies, String state, String city, String languages) {
	
		UID = uID;
		this.username = username;
		Email = email;
		this.pass = pass;
		this.image = image;
		Gender = gender;
		Monumber = monumber;
		Hobbies = hobbies;
		State = state;
		City = city;
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
	
	


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}



	public String getLanguages() {
		return Languages;
	}


	public void setLanguages(String languages) {
		Languages = languages;
	}


	public byte[] getImage() {
		return image;
	}








	public void setImage(byte[] image) {
		this.image = image;
	}








	public String getState() {
		return State;
	}
















	public void setState(String state) {
		State = state;
	}
















	@Override
	public String toString() {
		return "UserRegistration [UID=" + UID + ", username=" + username + ", Email=" + Email + ", pass=" + pass
				+ ", image=" + Arrays.toString(image) + ", Gender=" + Gender + ", Monumber=" + Monumber + ", Hobbies="
				+ Hobbies + ", State=" + State + ", City=" + City + ", Languages=" + Languages + "]";
	}



























	


	
	
	
	
	
	
	

}
