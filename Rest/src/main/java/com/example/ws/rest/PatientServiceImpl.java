package com.example.ws.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.example.ws.rest.exceptions.PatientBussinessException;
import com.example.ws.rest.model.patient;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long, patient> patients = new HashMap<>();
	long pid=123;
	long pid1=40;

	public PatientServiceImpl() {
		init();
	}

	private void init() {
		// this my first change after commit
		patient patent = new patient();
		patent.setId(pid);
		patent.setName("sai");
		patients.put(patent.getId(), patent);
		addonemore();
         // this is my my second commit before staging 
	}

	private void addonemore() {
		
		patient patent = new patient();
		patent.setId(pid1);
		patent.setName("sai");
		patients.put(patent.getId(), patent);
	}

	@Override
	public List<patient> getpatientslist() {
		Collection<patient> results = patients.values();
		
		List<patient> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public patient getPatient(long id) {
		if(patients.get(id)==null)
		{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
				return patients.get(id);
	}

	
	public Response createPatient(patient patent) {
		patent.setId(++pid);
		patients.put(patent.getId(),patent);
		return Response.ok(patent).build();
	}

	public Response updatePatient(patient patent)
	{
		patient currentpatient=patients.get(patent.getId());
		Response response;
		if(currentpatient!=null){
			patients.put(patent.getId(), patent);
			response= Response.ok().build();
		}
		else
		{
			throw new PatientBussinessException();
		}
		return response;
	}
	@Override
	public Response deletePatient(long id) {
		patient patient = patients.get(id);
		
		Response response;
		if(patient!=null){
			patients.remove(id);
			response= Response.ok().build();
		}
		else {
			response= Response.notModified().build();
		}
		return response;
	}
}