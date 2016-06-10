package com.movies.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table(name="MOVIE")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_generator")
	@SequenceGenerator(name = "movie_generator", sequenceName="movie_id_seq")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "TAGLINE")
	private String tagline;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ElementCollection
	@CollectionTable(name="USERS_COMMENT",
		    		 joinColumns=@JoinColumn(name="MOVIE_ID"))
	@Column(name="USERS_COMMENT")
	private List<String> usersComments;
	
	@ManyToMany(mappedBy="movies", fetch=FetchType.LAZY)
	private Set<Actor> actors;
	
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public void setUsersComments(List<String> usersComments) {
		this.usersComments = usersComments;
	}
	
	public List<String> getUsersComments() {
		return usersComments;
	}
	
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
	public Set<Actor> getActors() {
		return actors;
	}

}
