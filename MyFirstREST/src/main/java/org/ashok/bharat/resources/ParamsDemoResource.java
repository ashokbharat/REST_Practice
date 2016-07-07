package org.ashok.bharat.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.message.internal.HttpHeaderReader;

@Path("/annotations")
public class ParamsDemoResource {
  @GET
  public String getParams(@MatrixParam("param") String param,
                          @HeaderParam("header")String header,
                          @CookieParam("cookie") String cookie){
    return "Matrix Param is:" + param + "Header Param is:" + header + "Cookie Param is:" + cookie;
  }
  
  @GET
  @Path("/context")
  //public String getContextParams(@Context UriInfo uriInfo){
    public String getContextParams(@Context HttpHeaders httpHeader){
    return "Context Param httpHeader is:" +httpHeader.getCookies().toString(); 
  }
}
