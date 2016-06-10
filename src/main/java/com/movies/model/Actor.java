package com.movies.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "ACTOR")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_generator")
	@SequenceGenerator(name = "actor_generator", sequenceName="actor_id_seq")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@Column(name = "LASTNAME")
	private String lastname;
	
	@Column(name = "BIRTHDAY")
	private Date birthday;
	
	@Column(name = "SHORT_BIOGRAPHY")
	private String shortBiography;
	
	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ACTOR_MOVIE", 
          	   joinColumns=@JoinColumn(name="ACTOR_ID"),
               inverseJoinColumns=@JoinColumn(name="MOVIE_ID"))
	private Set<Movie> movies;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getShortBiography() {
		return shortBiography;
	}
	
	public void setShortBiography(String shortBiography) {
		this.shortBiography = shortBiography;
	}
	
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	public Set<Movie> getMovies() {
		return movies;
	}
}
