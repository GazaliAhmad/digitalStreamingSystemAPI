package com.capstone.digitalStreamingSystemAPI.service;

import com.capstone.digitalStreamingSystemAPI.model.Admin;
import com.capstone.digitalStreamingSystemAPI.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminsService {
	private final AdminsRepository adminsRepository;
	
	@Autowired
	public AdminsService(@Qualifier("admins") AdminsRepository adminsRepository) {
		this.adminsRepository = adminsRepository;
	}
	
	public List<Admin> getAllAdmins() {
		return adminsRepository.findAll();
	}
	
	public Admin findAdminById(Long id){
		return adminsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Admin with ID: " + id + " not found"));
	}
	
	public Admin addAdmin(Admin admin){
		return adminsRepository.save(admin);
	}
	
	public Admin updateAdmin(Admin admin){
		return adminsRepository.save(admin);
	}
	
	public void deleteAdmin(Long id){
		adminsRepository.deleteById(id);
	}
}
