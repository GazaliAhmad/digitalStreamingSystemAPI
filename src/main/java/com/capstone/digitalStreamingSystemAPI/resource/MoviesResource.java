package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Movies;
import com.capstone.digitalStreamingSystemAPI.service.MoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesResource {
	private final MoviesService moviesService;
	
	public MoviesResource(MoviesService moviesService) {
		this.moviesService = moviesService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Movies>> getAllMovies() {
		List<Movies> movies = moviesService.getAllMovies();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/find/{Id}")
	public ResponseEntity<Movies> findMovieById(@PathVariable("Id") Long id) {
		Movies movie = moviesService.findMoviesById(id);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
		Movies newMovie = moviesService.addMovies(movie);
		return new ResponseEntity<>(newMovie, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Movies> updateMovie(@RequestBody Movies movie) {
		Movies updatedMovie = moviesService.updateMovies(movie);
		return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
		moviesService.deleteMovies(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Construction Zone
	
	//@PutMapping("/{movieId}/actors/{actorsId}")
	//public ResponseEntity<Movies> addActorToMovie(@PathVariable("movieId") Long movieId, @PathVariable("actorsId") Long actorsId) {
	//	Movies movie = moviesService.addActorToMovie(movieId, actorsId);
	//	return new ResponseEntity<>(movie, HttpStatus.OK);
	//}
	
	//
	
}
