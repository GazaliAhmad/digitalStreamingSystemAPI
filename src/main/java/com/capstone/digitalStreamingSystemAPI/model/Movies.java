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
@Table(name = "movies")
public class Movies implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private Long movie_id;
	
	@Column(name = "movie_title", length = 100, nullable = false)
	private String movie_title;
	
	@Column(name = "movie_cost", nullable = false)
	private Integer movie_cost;
	
	@Column(name = "movie_year", length = 25, nullable = false)
	private String movie_year;
}
	
	// 26/08/2022
	/*
	@OneToMany(cascade = CascadeType.ALL)
	
	@JoinColumn(name = "movie_id" , referencedColumnName = "movie_id")
	
	private List<MoviesActors> moviesActors = new ArrayList<>(0);
	public List<MoviesActors> getMoviesActors() {
		return moviesActors;
	}
	public void setMoviesActors(List<MoviesActors> moviesActors) {
		this.moviesActors = moviesActors;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"movie_id = " + movie_id + ", " +
				"movie_title = " + movie_title + ", " +
				"movie_cost = " + movie_cost + ", " +
				"movie_year = " + movie_year + ")";
	}
}
*/

// Setting ManyToMany relationship with Actors class
//25/08/2022
//@ManyToMany
//@JoinTable(name = "MoviesActors", joinColumns = @JoinColumn(name = "movie_id"),
//		inverseJoinColumns = @JoinColumn(name = "actor_id"))
//private Set<Actors> actors = new HashSet<Actors>();
// End construction zone