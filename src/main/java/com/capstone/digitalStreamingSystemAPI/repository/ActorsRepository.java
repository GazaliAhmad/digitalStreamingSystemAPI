package com.capstone.digitalStreamingSystemAPI.repository;

import com.capstone.digitalStreamingSystemAPI.model.Actors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("actors")
@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {
}
