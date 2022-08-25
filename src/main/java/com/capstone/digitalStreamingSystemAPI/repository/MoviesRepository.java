package com.capstone.digitalStreamingSystemAPI.repository;

import com.capstone.digitalStreamingSystemAPI.model.Movies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("movies")
@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
}

