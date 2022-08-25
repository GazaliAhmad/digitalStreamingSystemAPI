package com.capstone.digitalStreamingSystemAPI.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MoviesActors implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long ma_id;
	private Long movie_id;
	private Long actor_id;
	
	public MoviesActors() {
	}
	
	public MoviesActors(Long ma_id, Long movie_id, Long actor_id) {
		this.ma_id = ma_id;
		this.movie_id = movie_id;
		this.actor_id = actor_id;
	}
	
	public Long getMa_id() {
		return ma_id;
	}
	
	public void setMa_id(Long ma_id) {
		this.ma_id = ma_id;
	}
	
	public Long getMovie_id() {
		return movie_id;
	}
	
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	
	public Long getActor_id() {
		return actor_id;
	}
	
	public void setActor_id(Long actor_id) {
		this.actor_id = actor_id;
	}
	
	@Override
	public String toString() {
		return "MoviesActors{" +
				"ma_id=" + ma_id +
				", movie_id=" + movie_id +
				", actor_id=" + actor_id +
				'}';
	}
}
