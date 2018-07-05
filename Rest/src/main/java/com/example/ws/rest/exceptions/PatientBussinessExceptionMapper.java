package com.example.ws.rest.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientBussinessExceptionMapper implements ExceptionMapper<PatientBussinessException> {

	@Override
	public Response toResponse(PatientBussinessException e) {

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"Status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Try again later\"");
		sb.append("}");

		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
