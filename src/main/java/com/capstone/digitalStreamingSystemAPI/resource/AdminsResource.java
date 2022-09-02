package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Admin;
import com.capstone.digitalStreamingSystemAPI.repository.AdminsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminsResource {
	
	private final AdminsRepository adminsRepository;
	
	public AdminsResource(AdminsRepository adminsRepository) {
		this.adminsRepository = adminsRepository;
	}
	
	@GetMapping("/all")
	public List<Admin> getAllAdmins() {
		return adminsRepository.findAll();
	}
	//Authorization
	@GetMapping("/auth/{email}/{password}")
	public ResponseEntity<List<Admin>> findAdminByEmailPassword(@PathVariable("email") String email,
	                                                      @PathVariable("password") String password) {
		System.out.println("email: " + email + " password: " + password);
		List<Admin> adminList = adminsRepository.findAll();
		//-> new RuntimeException("Admin with ID: " + email + " not found"));
		return new ResponseEntity<>(adminsRepository.getByEmailAndPassword(email, password), HttpStatus.OK);
	}
	
	@GetMapping("/add")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminsRepository.save(admin), HttpStatus.OK);
	}
	
	@GetMapping("/find/{Id}")
	public ResponseEntity<Admin> findAdminById(@PathVariable("Id") Integer id) {
		Admin admin= adminsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Admin with ID: " + id + " not found"));
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminsRepository.save(admin), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public void deleteAdmin(@PathVariable("Id") Integer id) {
		adminsRepository.deleteById(id);
	}
	
}
