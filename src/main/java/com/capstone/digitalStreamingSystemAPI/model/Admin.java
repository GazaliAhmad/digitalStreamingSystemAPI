package com.capstone.digitalStreamingSystemAPI.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "admin")
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private Long admin_id;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String first_name;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String last_name;
	
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@Column(name = "password", length = 50, nullable=false, unique=true)
	private String password;
	
	@Column(name = "email", length = 50, nullable=false, unique=true)
	private String email;
}
