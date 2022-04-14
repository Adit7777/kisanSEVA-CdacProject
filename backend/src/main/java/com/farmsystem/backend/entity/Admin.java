package com.farmsystem.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aid")
	private int aid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
   private String lastame;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_name")
	private String user_name;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastame() {
		return lastame;
	}
	public void setLastame(String lastame) {
		this.lastame = lastame;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Admin(String firstname, String lastame, String email, String password, String user_name) {
		super();
		this.firstname = firstname;
		this.lastame = lastame;
		this.email = email;
		this.password = password;
		this.user_name = user_name;
	}
	public Admin() {
		
	}
	
}
