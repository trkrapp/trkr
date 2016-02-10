package com.blueteam.trkr.entities;

import com.blueteam.trkr.entities.Activity;
import com.blueteam.trkr.entities.Person;
import java.io.Serializable;
import java.lang.Float;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity
@XmlRootElement
public class Review implements Serializable {

	@Id
	private Float id;

	@ManyToOne
	private Activity activity;

	@ManyToOne
	private Person person;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private Integer rating;
	
	private String comment;

	private static final long serialVersionUID = 1L;

	public Review() {
		super();
	}
	public Float getId() {
		return this.id;
	}

	public void setId(Float id) {
		this.id = id;
	}
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public Integer getRating() {
		return rating;
	}

}
