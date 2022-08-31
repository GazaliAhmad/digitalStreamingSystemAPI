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
@Table(name = "actors")
public class Actors implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "actor_id")
	private Long actor_id;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String first_name;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String last_name;
	
	@Column(name = "gender", length = 1, nullable=false)
	private char gender;
	
	@Column(name = "age",length = 2, nullable=false)
	private Integer age;
}
	
	
	// Setting ManyToMany relationship with Movies class
	
	// The following 2 lines works
	//@ManyToMany(mappedBy = "actors")
	//private Set<Movies> movies = new HashSet<>();
	
	
	//@ManyToMany
	//@JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "actor_id"),
	//		inverseJoinColumns = @JoinColumn(name = "movie_id"))
	//Set<Movies> movies;
	
	// End construction zone
	
	
	
	// This is to create a OneToOne relationship between Actors and Movies.
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_movie_id")
	private Movies movie;
	
	public Movies getMovie() {
		return movie;
	}
	
	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	*/


