package com.movies.dto;

import com.movies.model.Movie;

public class MovieDTO {
	
	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.tagline = movie.getTagline();
		this.description = movie.getDescription();
		this.year = movie.getYear();
	}

	private Long id;
	private String name;
	private String tagline;
	private String description;
	private Integer year;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTagline() {
		return tagline;
	}
	
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
}
