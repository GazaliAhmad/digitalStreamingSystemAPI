package com.capstone.digitalStreamingSystemAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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
	
	//31/08/2022 ManyToMany relationship with movies
	
	@ManyToMany
	@JoinTable(name ="MoviesActors", joinColumns = @JoinColumn(name = "ma_actor_id",
			referencedColumnName = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "ma_movie_id",
					referencedColumnName = "movie_id"))
	
	private Collection<Movies> movies;
	
	// This is the owner side of the relationship
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"actor_id = " + actor_id + ", " +
				"first_name = " + first_name + ", " +
				"last_name = " + last_name + ", " +
				"gender = " + gender + ", " +
				"age = " + age + ")";
	}
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


