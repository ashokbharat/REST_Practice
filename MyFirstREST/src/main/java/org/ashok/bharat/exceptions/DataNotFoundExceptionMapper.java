package org.ashok.bharat.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ashok.bharat.model.ExceptionMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
  //provider annotation is to register the custom mapper with jerser jax rs
  @Override
  public Response toResponse(DataNotFoundException exception) {
    ExceptionMessage msg = new ExceptionMessage(404, exception.getMessage(), "http://org.ashok.bharat");
    //return Response.status(Status.NOT_FOUND).build();
    return Response.status(Status.NOT_FOUND).entity(msg).build();
  }

}
