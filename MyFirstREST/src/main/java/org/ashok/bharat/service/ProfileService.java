package org.ashok.bharat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ashok.bharat.database.Db_Stub;
import org.ashok.bharat.model.ExceptionMessage;
import org.ashok.bharat.model.Profile;

public class ProfileService {
  private Map<String,Profile> profiles = Db_Stub.getProfiles();
  
  public ProfileService() {
    profiles.put("Girija", new Profile("Girija","Chitti","Papa") );
    profiles.put("Rohita", new Profile("Rohita","Rohi","Lilly") );
  }

  public List<Profile> getAllProfiles(){
    return new ArrayList<Profile>(profiles.values());
  }
  
  public Profile getProfile(String profileName){
    Profile profile = profiles.get(profileName);
    Response response=null;//Usage of WebApplicationException, default mappers provided by jersey jax rs
    ExceptionMessage msg = new ExceptionMessage(404, "NOT_FOUND", "http://org.ashok.bharat");
    response = Response.status(Status.NOT_FOUND).entity(msg).build();
    if(profile == null){
      throw new WebApplicationException(response);
    }
    return profiles.get(profileName);
  }
  public Profile addProfile(Profile pfle){
    profiles.put(pfle.getProfileName(), pfle);
    return profiles.get(pfle.getProfileName());
  }
  
  public Profile updateProfile(Profile pfle) {
    if (profiles.get(pfle.getProfileName()) == null) {
      return null;
    }
    else {
      profiles.put(pfle.getProfileName(), pfle);
      return profiles.get(pfle.getProfileName());
    }
  }
  
  public void removeProfile(String profileName){
    profiles.remove(profileName);
  }
}
