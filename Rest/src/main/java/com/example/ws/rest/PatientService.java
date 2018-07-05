package com.example.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.example.ws.rest.model.patient;

@Consumes("application/json")
@Produces("application/json")
@Path("/patientservice")
public interface PatientService  {
	@Path("/patients")
	@GET
	List<patient> getpatientslist();
	
	@Path("/patients/{id}")
	@GET
	patient getPatient(@PathParam("id") long id);
	
	
	@Path("/patientcrt")
	@POST
	Response createPatient(patient paient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam("id") long id);
	
	@Path("/patients")
	@PUT
	Response updatePatient(patient patent);
}
