package com.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.dto.ActorDTO;
import com.movies.service.ActorsService;

@RestController
@RequestMapping("/actors")
public class ActorsController {

	private ActorsService actorsService;
	
	@Autowired
	public ActorsController(ActorsService actorsService) {
		this.actorsService = actorsService;
	}
	
	@RequestMapping("/findByName/{name}")
	public @ResponseBody List<ActorDTO> findActorsByName(@PathVariable("name") String actorName) {
		return actorsService.findByName(actorName);
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody List<ActorDTO> findAllActors() {
		return actorsService.findAllActors();
	}
}
