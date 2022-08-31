package com.capstone.digitalStreamingSystemAPI.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MoviesActors implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ma_id")
	private Long ma_id;
	
	@Column(name="movie_id")
	private Long movie_id;
	
	@Column(name="actor_id")
	private Long actor_id;
	
}
