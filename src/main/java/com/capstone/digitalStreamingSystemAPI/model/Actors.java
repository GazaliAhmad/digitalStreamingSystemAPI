package com.capstone.digitalStreamingSystemAPI.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Actors implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long actor_id;
	private String first_name;
	private String last_name;
	private char gender;
	private Integer age;
	
	// This is to create a OneToOne relationship between Actors and Movies.
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_movie_id")
	private Movies movie;
	
	public Movies getMovie() {
		return movie;
	}
	
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	*/
	public Actors() {
	}
	
	public Actors(Long actor_id, String first_name, String last_name, char gender, Integer age) {
		this.actor_id = actor_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.age = age;
	}
	
	public Long getActor_id() {
		return actor_id;
	}
	
	public void setActor_id(Long actor_id) {
		this.actor_id = actor_id;
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
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Actors{" +
				"actor_id=" + actor_id +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", gender=" + gender +
				", age=" + age +
				'}';
	}
}
