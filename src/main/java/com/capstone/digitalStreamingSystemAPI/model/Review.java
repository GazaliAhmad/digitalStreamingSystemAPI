package com.capstone.digitalStreamingSystemAPI.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Review implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long review_id;
	private String date_posted;
	private String description;
	private String rating;
	private String movie_id;
	
	public Review() {
	}
	
	public Review(Long review_id, String date_posted, String description, String rating, String movie_id) {
		this.review_id = review_id;
		this.date_posted = date_posted;
		this.description = description;
		this.rating = rating;
		this.movie_id = movie_id;
	}
	
	public Long getReview_id() {
		return review_id;
	}
	
	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}
	
	public String getDate_posted() {
		return date_posted;
	}
	
	public void setDate_posted(String date_posted) {
		this.date_posted = date_posted;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getMovie_id() {
		return movie_id;
	}
	
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	
	@Override
	public String toString() {
		return "Review{" +
				"review_id=" + review_id +
				", date_posted='" + date_posted + '\'' +
				", description='" + description + '\'' +
				", rating='" + rating + '\'' +
				", movie_id='" + movie_id + '\'' +
				'}';
	}
}
