package com.capstone.digitalStreamingSystemAPI.service;

import com.capstone.digitalStreamingSystemAPI.model.Actors;
import com.capstone.digitalStreamingSystemAPI.repository.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService {
	private final ActorsRepository actorsRepository;
	
	@Autowired
	public ActorsService(@Qualifier("actors") ActorsRepository actorsRepository) {
		this.actorsRepository = actorsRepository;
	}
	
	public List<Actors> getAllActors() {
		return actorsRepository.findAll();
	}
	
	public Actors findActorById(Long id) {
		return actorsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Actor with ID: " + id + " not found"));
	}
	
	public Actors addActor(Actors actor) {
		return actorsRepository.save(actor);
	}
	
	public Actors updateActor(Actors actor) {
		return actorsRepository.save(actor);
	}
	
	public void deleteActor(Long id) {
		actorsRepository.deleteById(id);
	}
}
