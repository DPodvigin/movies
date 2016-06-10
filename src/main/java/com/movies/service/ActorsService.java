package com.movies.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.movies.dto.ActorDTO;
import com.movies.repository.ActorsRepository;

@Service
public class ActorsService {

	private ActorsRepository actorsRepository;
	
	@Autowired
	public ActorsService(ActorsRepository actorsRepository) {
		this.actorsRepository = actorsRepository;
	}
	
	public List<ActorDTO> findByName(String name) {
		return StringUtils.isEmpty(name) ? findAllActors() :
				actorsRepository.searchWithJPQLQuery(name.toLowerCase())
								.stream()
								.map(ActorDTO::new)
								.collect(Collectors.toList());
	}
	
	public List<ActorDTO> findAllActors() {
		return actorsRepository.findAll()
								.stream()
								.map(ActorDTO::new)
								.collect(Collectors.toList());
	}
}
