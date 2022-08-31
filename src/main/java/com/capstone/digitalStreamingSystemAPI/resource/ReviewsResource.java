package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Reviews;
import com.capstone.digitalStreamingSystemAPI.repository.ReviewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsResource {
	
	private final ReviewsRepository reviewsRepository;
	
	public ReviewsResource(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}
	
	@RequestMapping("/all")
	public List<Reviews> getAllReviews() {
		return reviewsRepository.findAll();
	}
	
	@RequestMapping("/find/{Id}")
	public ResponseEntity<Reviews> findReviewById(@PathVariable("Id") Long id) {
		Reviews review = reviewsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Review with ID: " + id + " not found"));
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
	
	@RequestMapping("/add")
	public ResponseEntity<Reviews> addReview(@RequestBody Reviews review) {
		return new ResponseEntity<>(reviewsRepository.save(review), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Reviews> updateReview(@RequestBody Reviews review) {
		return new ResponseEntity<>(reviewsRepository.save(review), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public void deleteReview(@PathVariable("Id") Long id) {
		reviewsRepository.deleteById(id);
	}
}
