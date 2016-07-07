package org.ashok.bharat.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.ashok.bharat.database.Db_Stub;
import org.ashok.bharat.exceptions.DataNotFoundException;
import org.ashok.bharat.model.Message;
import org.ashok.bharat.model.Profile;

public class MessageService {
  private Map<Long,Message> messages = Db_Stub.getMessages();
  
//Service Stubs created to fetch data from DB(here in memory static objects)
    public MessageService(){
      messages.put(1L,new Message(1,"REST Services","Bharat"));
      messages.put(2L,new Message(2,"MDM Analysis","Praveen"));
    }
    public List<Message> getAllMessages(){
      //List<Message> messages = new ArrayList<>();
      /*Message m1  = new Message(1,"REST Services","Bharat");
      Message m2  = new Message(2,"MDM Analysis","Praveen");
      messages.add(m1);
      messages.add(m2);*/
      //messages = new ArrayList<Message>(messages.values());
      return new ArrayList<Message>(messages.values());
    }
    //Query Param usage for returning messages by year
    public List<Message> getMessagesByYear(int year){
      List<Message> msgList = new ArrayList<Message>();
      Calendar cal = Calendar.getInstance();
      for(Message msg : messages.values()){
        msg.setCreated(cal.getTime());
        if(cal.get(Calendar.YEAR)== year){
          msgList.add(msg);
        }
      }
      return msgList;
    }
    //Query Param usage for returning messages by pagination
    public List<Message> getMessagesPaginated(int start,int size){
      List<Message> msgList = new ArrayList<Message>(messages.values());
      if(start+size > msgList.size()){
        return null;
      }
      return msgList.subList(start, start+size);
    }
    
    public Message getMessage(long id){
      Message msg = messages.get(id);
      if(msg ==null){
        throw new DataNotFoundException("Message with id :" + id + " Not Found");
      }
      return msg;
    }
    public Message addMessage(Message msg){
      msg.setId(messages.size() + 1);
      messages.put(msg.getId(), msg);
      return messages.get(msg.getId());
    }
    
    public Message updateMessage(Message msg){
      if(messages.get(msg.getId())==null){
        return null;
      }else{
        messages.put(msg.getId(), msg);
        return msg;
      }
    }
    
    public Message remove(long id){
      return messages.remove(id);
    }
}
