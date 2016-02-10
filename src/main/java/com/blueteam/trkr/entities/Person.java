package com.blueteam.trkr.entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
@XmlRootElement
public class Person implements Serializable {

	@Id
	private Float id;

	private String name;

	@OneToMany
	private List<Person> following = new ArrayList<>();

	@OneToMany
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany
	private List<Event> events = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	public Person() {
		super();
	}

	public Float getId() {
		return this.id;
	}

	public void setId(Float id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getFollowing() {
		return this.following;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public List<Review> getReviews() {
		return reviews;
	}

}
