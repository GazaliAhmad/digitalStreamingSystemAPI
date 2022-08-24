package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Movies;
import com.capstone.digitalStreamingSystemAPI.service.MoviesService;
import org.apache.coyote.Response;
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
	
	//Get all movies
	@GetMapping("/all")
	public ResponseEntity<List<Movies>> getAllMovies() {
		List<Movies> movies = moviesService.getAllMovies();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Movies> findMoviesById(@PathVariable("id") Long id) {
		Movies movie = moviesService.findMoviesById(id);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Movies> addMovies(@RequestBody Movies movie) {
		Movies newMovie = moviesService.addMovies(movie);
		return new ResponseEntity<>(newMovie, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Movies> updateMovies(@RequestBody Movies movie) {
		Movies updatedMovie = moviesService.updateMovies(movie);
		return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMovies(@PathVariable("id") Long id) {
		moviesService.deleteMovies(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
