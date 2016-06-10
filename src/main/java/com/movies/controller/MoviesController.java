package com.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.dto.CommentMovie;
import com.movies.dto.MovieDTO;
import com.movies.model.Movie;
import com.movies.service.MoviesService;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	private MoviesService moviesService;
	
	@Autowired
	public MoviesController(MoviesService moviesService) {
		this.moviesService = moviesService;
	}
	
	@RequestMapping("/findByName/{name}")
	public @ResponseBody List<MovieDTO> findMoviesByName(@PathVariable("name") String movieName) {
		return moviesService.findByName(movieName);
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody List<MovieDTO> findAllMovies() {
		return moviesService.findAllMovies();
	}
	
	@RequestMapping("/findById/{id}")
	public @ResponseBody Movie findMovieById(@PathVariable("id") Long id) {
		return moviesService.findById(id);
	}
	
	@RequestMapping(value = "/comment/add", method = RequestMethod.POST)
	public void addComment(@RequestBody CommentMovie commentMovie) {
		moviesService.addComment(commentMovie);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie) {
		moviesService.addMovie(movie);
	}
	
}
