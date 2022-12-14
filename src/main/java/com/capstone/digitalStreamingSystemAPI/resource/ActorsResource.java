package com.capstone.digitalStreamingSystemAPI.resource;

import com.capstone.digitalStreamingSystemAPI.model.Actors;
import com.capstone.digitalStreamingSystemAPI.repository.ActorsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsResource {
	private final ActorsRepository actorsRepository;
	
	public ActorsResource(ActorsRepository actorsRepository) {
		this.actorsRepository = actorsRepository;
	}
	@GetMapping("/all")
	public List<Actors> getAllActors() {
		return actorsRepository.findAll();
	}
	
	@GetMapping("/find/{Id}")
	public ResponseEntity<Actors> findActorById(@PathVariable("Id") Long id) {
		Actors actor = actorsRepository.findById(id).orElseThrow(()
				-> new RuntimeException("Actor with ID: " + id + " not found"));
		return new ResponseEntity<>(actor, HttpStatus.OK);
	}
	
	@GetMapping("/add")
	public ResponseEntity<Actors> addActor(@RequestBody Actors actor) {
		return new ResponseEntity<>(actorsRepository.save(actor), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Actors> updateActor(@RequestBody Actors actor) {
		return new ResponseEntity<>(actorsRepository.save(actor), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{Id}")
	public void deleteActors(@PathVariable("Id") Long id) {
		actorsRepository.deleteById(id);
	}
	
}

// ("/find/{Id}")
// another method instead like in MoviesResource. Throws exception if not found.