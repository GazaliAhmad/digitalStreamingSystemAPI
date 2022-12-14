package com.capstone.digitalStreamingSystemAPI.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "reviews")
public class Reviews implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "review_id")
	private Long review_id;
	
	@Column(name = "date_posted", length = 25, nullable = false)
	private String date_posted;
	
	@Column(name = "description", length = 5000, nullable = false)
	private String description;
	
	@Column(name = "rating", length = 1, nullable = false)
	private Integer rating;
	
	@ManyToMany
	@JoinTable(name ="MoviesReviews", joinColumns = @JoinColumn(name = "mr_reviews_id",
	referencedColumnName = "review_id"),
			inverseJoinColumns = @JoinColumn(name = "mr_movie_id",
					referencedColumnName = "movie_id"))
	
	 private Collection<Movies> movies;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"review_id = " + review_id + ", " +
				"date_posted = " + date_posted + ", " +
				"description = " + description + ", " +
				"rating = " + rating + ")";
	}
}

// ManyToMany relationship with Movies
// 01/01/2022 CS zone
//@Column(name = "movie_id")
//private Long movie_id;
