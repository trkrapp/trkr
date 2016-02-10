package com.blueteam.trkr.entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
@XmlRootElement
public class Event implements Serializable {

	@Id
	private Float id;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private static final long serialVersionUID = 1L;

	public Event() {
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
