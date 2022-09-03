package com.capstone.digitalStreamingSystemAPI.repository;

import com.capstone.digitalStreamingSystemAPI.model.Admin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Qualifier("admins")
@Repository
public interface AdminsRepository extends JpaRepository<Admin, Integer> {
	
	Optional<Admin> findByEmailAndPassword(String email, String password);

	}

