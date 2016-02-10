package com.blueteam.trkr.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Person
 *
 */
@Entity
@XmlRootElement
public class Person implements Serializable {

	@Id
	private String userName;

	private String name;

	@OneToMany
	private Set<Person> following = new HashSet<>();

	@OneToMany
	private Set<Review> reviews = new HashSet<>();

	@ManyToMany
	private Set<Event> events = new HashSet<>();

	private static final long serialVersionUID = 1L;

	public Person() {
		super();
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Person> getFollowing() {
		return this.following;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

}
