package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Actors;
import com.capstone.digitalStreamingSystemAPI.model.Review;
import com.capstone.digitalStreamingSystemAPI.repository.ReviewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsResource {
	
	private final ReviewsRepository reviewsRepository;
	
	public ReviewsResource(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}
	
	@RequestMapping("/all")
	public List<Review> getAllReviews() {
		return reviewsRepository.findAll();
	}
	
	@RequestMapping("/find/{Id}")
	public ResponseEntity<Review> findReviewById(@PathVariable("Id") Long id) {
		Review review = reviewsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Actor with ID: " + id + " not found"));
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	@RequestMapping("/add")
	public ResponseEntity<Review> addReview(@RequestBody Review review) {
		return new ResponseEntity<>(reviewsRepository.save(review), HttpStatus.OK);
	}
	
	@RequestMapping("/update")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) {
		return new ResponseEntity<>(reviewsRepository.save(review), HttpStatus.OK);
	}
	
	@RequestMapping("/delete/{Id}")
	public void deleteReview(@PathVariable("Id") Long id) {
		reviewsRepository.deleteById(id);
	}
}
