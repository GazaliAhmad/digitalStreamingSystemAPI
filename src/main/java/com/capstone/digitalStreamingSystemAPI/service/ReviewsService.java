package com.capstone.digitalStreamingSystemAPI.service;

import com.capstone.digitalStreamingSystemAPI.model.Review;
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
	
	public List<Review> getAllReviews() {
		return reviewsRepository.findAll();
	}
	
	public Review findReviewById(Long id) {
		return reviewsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Review with ID: " + id + " not found"));
	}
	
	public Review addReview(Review review) {
		return reviewsRepository.save(review);
	}
	
	public Review updateReview(Review review) {
		return reviewsRepository.save(review);
	}
	
	public void deleteReview(Long id) {
		reviewsRepository.deleteById(id);
	}
	
}
