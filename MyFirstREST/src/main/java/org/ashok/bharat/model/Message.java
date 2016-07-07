package org.ashok.bharat.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {
  private long id;
  private String msg;
  private String author;
  private Date created;
  
  public Message(){
    
  }
  
  public Message(long id, String msg, String author) {
    super();
    this.id = id;
    this.msg = msg;
    this.author = author;
    this.created = new Date();
  }
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public Date getCreated() {
    return created;
  }
  public void setCreated(Date created) {
    this.created = created;
  }
  
}
