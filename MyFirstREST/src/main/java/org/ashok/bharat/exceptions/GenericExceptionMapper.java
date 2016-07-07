package org.ashok.bharat.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.ashok.bharat.model.ExceptionMessage;
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

  @Override
  public Response toResponse(Throwable exception) {
    ExceptionMessage msg = new ExceptionMessage(500, exception.getMessage(), "http://org.ashok.bharat");
    //return Response.status(Status.NOT_FOUND).build();
    return Response.status(Status.INTERNAL_SERVER_ERROR).entity(msg).build();
  }

}
