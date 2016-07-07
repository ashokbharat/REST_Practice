package org.ashok.bharat.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ashok.bharat.model.Profile;
import org.ashok.bharat.service.ProfileService;
@Path("/profiles")
public class ProfileResource {
  private static ProfileService prfSrvce = null;
  static{
    prfSrvce = new ProfileService();
  }
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Profile> getAllProfiles(){
    return prfSrvce.getAllProfiles();
  }
  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Profile getProfile(@PathParam("name") String profileName){    
      return prfSrvce.getProfile(profileName);
  }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Profile addProfile(Profile profile){
    return prfSrvce.addProfile(profile);
  }
  @PUT
  @Path("/{name}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Profile updateProfile(@PathParam("name")String pfName, Profile profile){
    return prfSrvce.updateProfile(profile);
  }
  @DELETE
  @Path("/{name}")
  public void deleteProfile(@PathParam("name")String profileName){
    prfSrvce.removeProfile(profileName);
  }
}
