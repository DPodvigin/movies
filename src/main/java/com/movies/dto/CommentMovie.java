package com.movies.dto;

public class CommentMovie {

	private Long movieId;
	private String comment;
	
	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
