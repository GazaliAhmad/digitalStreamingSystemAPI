package com.capstone.digitalStreamingSystemAPI.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long admin_id;
	private String first_name;
	private String last_name;
	private String password;
	
	public Admin() {
	}
	
	public Admin(Long admin_id, String first_name, String last_name, String password) {
		this.admin_id = admin_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
	}
	
	public Long getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Admin{" +
				"admin_id=" + admin_id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
