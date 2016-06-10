package com.movies.dto;

import java.util.Date;

import com.movies.model.Actor;

public class ActorDTO {
	
	public ActorDTO(Actor actor) {
		this.id = actor.getId();
		this.firstname = actor.getFirstname();
		this.lastname = actor.getLastname();
		this.birthday = actor.getBirthday();
		this.shortBiography = actor.getShortBiography();
	}

	private Long id;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String shortBiography;
	
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
	
}
