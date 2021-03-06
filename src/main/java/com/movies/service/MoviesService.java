package com.movies.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.movies.dto.CommentMovie;
import com.movies.dto.MovieDTO;
import com.movies.model.Movie;
import com.movies.repository.MoviesRepository;

@Service
public class MoviesService {

	private MoviesRepository moviesRepository;
	
	@Autowired
	public MoviesService(MoviesRepository moviesRepository) {
		this.moviesRepository = moviesRepository;
	}
	
	public List<MovieDTO> findByName(String name) {
		return StringUtils.isEmpty(name) ? findAllMovies() :
				moviesRepository.searchWithJPQLQuery(name.toLowerCase())
								.stream()
								.map(MovieDTO::new)
								.collect(Collectors.toList());
	}
	
	public List<MovieDTO> findAllMovies() {
		return moviesRepository.findAll()
								.stream()
								.map(MovieDTO::new)
								.collect(Collectors.toList());
	}
	
	public Movie findById(Long id) {
		return moviesRepository.findOne(id);
	}
	
	@Transactional
	public void addComment(CommentMovie commentMovie) {
		Movie movie = moviesRepository.findOne(commentMovie.getMovieId());
		movie.getUsersComments().add(commentMovie.getComment());
		moviesRepository.save(movie);
	}
	
	@Transactional
	public void addMovie(Movie movie) {
		moviesRepository.save(movie);
	}
}
