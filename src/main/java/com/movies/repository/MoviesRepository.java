package com.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movies.model.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {

	 @Query("SELECT m FROM Movie m WHERE m.name LIKE %:name%")
	 public List<Movie> searchWithJPQLQuery(@Param("name") String name);
	 
}
