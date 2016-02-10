package com.blueteam.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.WebServiceContext;

import com.blueteam.trkr.entities.Person;

/**
 * 
 */
@Stateless
@Path("/people")
public class PersonEndpoint {
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Resource
	private WebServiceContext context;
	

	@POST
	@Consumes("application/json")
	public Response create(Person entity) {
		em.persist(entity);
		return Response.created(
				UriBuilder.fromResource(PersonEndpoint.class)
						.path(String.valueOf(entity.getId())).build()).build();
	}

	@DELETE
	@Path("/{userName}")
	public Response deleteByUserName(@PathParam("userName") String userName) {
		Person entity = em.find(Person.class, userName);
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.remove(entity);
		return Response.noContent().build();
	}

	@GET
	@Path("/")
	@Produces("application/json")
	public Response fndMe() {
		return findById(context.getUserPrincipal().getName());
	}
	
	@GET
	@Path("/{userName}")
	@Produces("application/json")
	public Response findById(@PathParam("userName") String userName) {
		TypedQuery<Person> findByIdQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.following LEFT JOIN FETCH p.reviews LEFT JOIN FETCH p.events WHERE p.userName = :entityId ORDER BY p.userName",
						Person.class);
		findByIdQuery.setParameter("entityId", userName);
		Person entity;
		try {
			entity = findByIdQuery.getSingleResult();
		} catch (NoResultException nre) {
			entity = null;
		}
		if (entity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(entity).build();
	}

	@GET
	@Produces("application/json")
	public List<Person> listAll(@QueryParam("start") Integer startPosition,
			@QueryParam("max") Integer maxResult) {
		TypedQuery<Person> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.following LEFT JOIN FETCH p.reviews LEFT JOIN FETCH p.events ORDER BY p.userName",
						Person.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		final List<Person> results = findAllQuery.getResultList();
		return results;
	}

	@PUT
	@Path("/{userName}")
	@Consumes("application/json")
	public Response update(@PathParam("userName") String userName, Person entity) {
		if (entity == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (userName == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!userName.equals(entity.getId())) {
			return Response.status(Status.CONFLICT).entity(entity).build();
		}
		if (em.find(Person.class, userName) == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		try {
			entity = em.merge(entity);
		} catch (OptimisticLockException e) {
			return Response.status(Response.Status.CONFLICT)
					.entity(e.getEntity()).build();
		}

		return Response.noContent().build();
	}
}
