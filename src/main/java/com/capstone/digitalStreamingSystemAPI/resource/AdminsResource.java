package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Admin;
import com.capstone.digitalStreamingSystemAPI.repository.AdminsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminsResource {
	
	private final AdminsRepository adminsRepository;
	
	public AdminsResource(AdminsRepository adminsRepository) {
		this.adminsRepository = adminsRepository;
	}
	
	@RequestMapping("/all")
	public List<Admin> getAllAdmins() {
		return adminsRepository.findAll();
	}
	
	@RequestMapping("/find/{Id}")
	public ResponseEntity<Admin> findAdminById(@PathVariable("Id") Long id) {
		Admin admin= adminsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Admin with ID: " + id + " not found"));
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@RequestMapping("/add")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminsRepository.save(admin), HttpStatus.OK);
	}
	
	@RequestMapping("/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminsRepository.save(admin), HttpStatus.OK);
	}
	
	@RequestMapping("/delete/{Id}")
	public void deleteAdmin(@PathVariable("Id") Long id) {
		adminsRepository.deleteById(id);
	}
	
}
