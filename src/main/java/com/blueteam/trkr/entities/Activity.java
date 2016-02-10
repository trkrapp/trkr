package com.blueteam.trkr.entities;

import com.blueteam.trkr.entities.Location;
import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Activity
 *
 */
@Entity
@XmlRootElement
public class Activity implements Serializable {

	@Id
	private Float id;

	@ManyToOne
	private Location location;

	@ManyToMany
	private List<Event> events = new ArrayList<>();

	private Integer dificulty;
	private String name;
	private String description;
	private static final long serialVersionUID = 1L;

	public Activity() {
		super();
	}

	public Float getId() {
		return this.id;
	}

	public void setId(Float id) {
		this.id = id;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public Integer getDificulty() {
		return this.dificulty;
	}

	public void setDificulty(Integer dificulty) {
		this.dificulty = dificulty;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
