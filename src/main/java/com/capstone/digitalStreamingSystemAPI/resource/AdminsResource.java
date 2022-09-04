package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Admin;
import com.capstone.digitalStreamingSystemAPI.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminsResource {
	
	@Autowired
	private AdminsRepository adminsRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> admins = adminsRepository.findAll();
		return new ResponseEntity<>(admins, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") Integer id) {
		adminsRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@Transactional
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		adminsRepository.save(admin);
		return new ResponseEntity<>(admin, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@Transactional
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminsRepository.save(admin), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Admin> findAdminById(@PathVariable("id") Integer id) {
		Admin admin = adminsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Admin with ID: " + id + " not found"));
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	@GetMapping("/{email}/{password}")
	public Boolean getAdmin(@PathVariable("email") String email, @PathVariable("password") String password) {
		Optional<Admin> admin = adminsRepository.findByEmailAndPassword(email, password);
		return admin.isPresent();
	}
}
