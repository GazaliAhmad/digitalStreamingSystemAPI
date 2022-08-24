package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Movies;
import com.capstone.digitalStreamingSystemAPI.service.MoviesService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
