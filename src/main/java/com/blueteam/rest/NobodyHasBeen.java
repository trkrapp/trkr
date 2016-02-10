package com.blueteam.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.blueteam.trkr.entities.Location;

@RequestScoped
@Path("nobodyHasBeen")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class NobodyHasBeen {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	
	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Location> getAllUnconqueredLocations(){
		Query findAllQuery =  em 
				.createNativeQuery("SELECT location.* FROM Activity INNER JOIN LOCATION ON Location.id=Activity.location_id LEFT JOIN Activity_event ON Activity.id=Activity_id WHERE Activity_id is null",
						Location.class);
		final List<Location> results = findAllQuery.getResultList();
		return results;
	}

}
