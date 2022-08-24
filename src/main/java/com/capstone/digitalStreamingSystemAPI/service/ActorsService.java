package com.capstone.digitalStreamingSystemAPI.service;

import com.capstone.digitalStreamingSystemAPI.model.Actors;
import com.capstone.digitalStreamingSystemAPI.repository.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService {
	private final ActorsRepository actorsRepository;
	
	@Autowired
	public ActorsService(ActorsRepository actorsRepository) {
		this.actorsRepository = actorsRepository;
	}
	
	public List<Actors> getAllActors() {
		return actorsRepository.findAll();
	}
	
	public Actors findActorsById(Long id) {
		return actorsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Actor with ID: " + id + " not found"));
	}
	
	public Actors addActors(Actors actor) {
		return actorsRepository.save(actor);
	}
	
	public Actors updateActors(Actors actor) {
		return actorsRepository.save(actor);
	}
	
	public void deleteActors(Long id) {
		actorsRepository.deleteById(id);
	}
}
