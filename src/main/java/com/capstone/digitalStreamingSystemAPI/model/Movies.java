package com.capstone.digitalStreamingSystemAPI.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movies implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long movie_id;
	
	// Setting ManyToMany relationship with Actors class
	
	@ManyToMany
	@JoinTable(name = "MoviesActors", joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private Set<Actors> actors = new HashSet<Actors>();
	
	
	
	// End construction zone
	private String movie_title;
	private Integer movie_cost;
	private Integer movie_year;
	
	public Movies() {
	}
	
	public Movies(Long movie_id, String movie_title, Integer movie_cost, Integer movie_year) {
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.movie_cost = movie_cost;
		this.movie_year = movie_year;
	}
	
	public Long getMovie_id() {
		return movie_id;
	}
	
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	
	public String getMovie_title() {
		return movie_title;
	}
	
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	
	public Integer getMovie_cost() {
		return movie_cost;
	}
	
	public void setMovie_cost(Integer movie_cost) {
		this.movie_cost = movie_cost;
	}
	
	public Integer getMovie_year() {
		return movie_year;
	}
	
	public void setMovie_year(Integer movie_year) {
		this.movie_year = movie_year;
	}
	
	//
	
	public Set<Actors> getActors() {
		return actors;
	}
	
	public void addActor(Long actorsId) {
	}
	
	//
	@Override
	public String toString() {
		return "Movies{" +
				"movie_id=" + movie_id +
				", movie_title='" + movie_title + '\'' +
				", movie_cost=" + movie_cost +
				", movie_year=" + movie_year +
				'}';
	}

}


