package com.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movies.model.Actor;

@Repository
public interface ActorsRepository extends JpaRepository<Actor, Long> {

	 @Query("SELECT a FROM Actor a WHERE a.firstname LIKE %:name%")
	 public List<Actor> searchWithJPQLQuery(@Param("name") String name);
}
