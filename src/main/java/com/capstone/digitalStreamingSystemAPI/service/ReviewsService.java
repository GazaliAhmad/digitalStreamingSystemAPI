package com.capstone.digitalStreamingSystemAPI.service;

import com.capstone.digitalStreamingSystemAPI.model.Reviews;
import com.capstone.digitalStreamingSystemAPI.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
	private final ReviewsRepository reviewsRepository;
	
	@Autowired
	public ReviewsService(@Qualifier("reviews") ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}
	
	public List<Reviews> getAllReviews() {
		return reviewsRepository.findAll();
	}
	
	public Reviews findReviewById(Long id){
		return reviewsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Review with ID: " + id + " not found"));
	}
	
	public Reviews addReview(Reviews review) {
		return reviewsRepository.save(review);
	}
	
	public Reviews updateReview(Reviews review) {
		return reviewsRepository.save(review);
	}
	
	public void deleteReview(Long id) {
		reviewsRepository.deleteById(id);
	}
}

/*
// ManyToMany relationship between Reviews and Movies
	
	public ResponseEntity<Object> getAllReviews() {
		List<Reviews> reviews = reviewsRepository.findAll();
		if (reviews.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	*/