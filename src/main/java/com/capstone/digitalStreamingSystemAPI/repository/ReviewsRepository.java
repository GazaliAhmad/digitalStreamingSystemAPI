package com.capstone.digitalStreamingSystemAPI.repository;

import com.capstone.digitalStreamingSystemAPI.model.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("reviews")
@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {

}
