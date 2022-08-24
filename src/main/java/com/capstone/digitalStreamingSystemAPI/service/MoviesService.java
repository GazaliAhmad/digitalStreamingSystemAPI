package com.capstone.digitalStreamingSystemAPI.service;

import com.capstone.digitalStreamingSystemAPI.model.Movies;
import com.capstone.digitalStreamingSystemAPI.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
	private final MoviesRepository moviesRepository;
	
	@Autowired
	public MoviesService(MoviesRepository moviesRepository) {
		this.moviesRepository = moviesRepository;
	}
	
	public List<Movies> getAllMovies() {
		return moviesRepository.findAll();
	}
	
	public Movies findMoviesById(Long id) {
		return moviesRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Movie with ID: " + id + " not found"));
	}
	
}
