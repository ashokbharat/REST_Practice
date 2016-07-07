package org.ashok.bharat.database;

import java.util.HashMap;
import java.util.Map;

import org.ashok.bharat.model.Message;
import org.ashok.bharat.model.Profile;

public class Db_Stub {
  private static Map<Long,Message> messages = new HashMap<>();
  private static Map<String,Profile> profiles = new HashMap<>();
  
  public static Map<Long, Message> getMessages() {
    return messages;
  }
  public static Map<String, Profile> getProfiles() {
    return profiles;
  }
  
  
  
  
}
