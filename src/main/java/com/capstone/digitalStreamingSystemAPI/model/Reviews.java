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
@Table(name = "reviews")
public class Reviews implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "review_id")
	private Long review_id;
	
	@Column(name="date_posted", length = 25, nullable = false)
	private String date_posted;
	
	@Column(name="description", length = 5000, nullable = false)
	private String description;
	
	@Column(name="rating", length = 1, nullable = false)
	private Integer rating;
	
	@Column(name = "movie_id")
	private Long movie_id;
}
