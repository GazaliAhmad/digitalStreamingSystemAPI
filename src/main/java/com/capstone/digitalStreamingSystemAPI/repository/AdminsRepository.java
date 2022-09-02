package com.capstone.digitalStreamingSystemAPI.repository;

import com.capstone.digitalStreamingSystemAPI.model.Admin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Qualifier("admins")
@Repository
public interface AdminsRepository extends JpaRepository<Admin, Integer> {
	//Optional<List<Admin>> findByAdminName(String name);
	//@Query(value = "SELECT * FROM ADMINS WHERE ADMIN_EMAIL = ?1 AND PASSWORD = ?2" ,  nativeQuery = true)
	List<Admin> getByEmailAndPassword(String email, String password);
}

