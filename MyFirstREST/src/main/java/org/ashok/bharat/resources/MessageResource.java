package org.ashok.bharat.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.ashok.bharat.model.Message;
import org.ashok.bharat.service.MessageService;
import org.glassfish.jersey.server.Uri;

@Path("/messages")
public class MessageResource {
  private static MessageService msgSrvce = null;
  static{
    msgSrvce = new MessageService();
  }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //public List<Message> getMessages(@QueryParam("year") int year,
      //                               @QueryParam("start") int start,
        //                             @QueryParam("size") int size){
      //public List<Message> getMessages(@BeanParam MessageBean msgBean){
    public List<Message> getMessages(){
      //MessageService msgSrvce = new MessageService();
      List<Message> messageList = null;
     // if(msgBean.getYear() > 0){
       // messageList = msgSrvce.getMessagesByYear(msgBean.getYear());
      //}else if(msgBean.getStart() >=0 && msgBean.getSize()>=0){
       // messageList = msgSrvce.getMessagesPaginated(msgBean.getStart(), msgBean.getSize());
      //}
        //else{
        messageList = msgSrvce.getAllMessages();
      //}
      return messageList;
    }
    @GET
    @Path("/{messageid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam ("messageid") long messageid){
      return msgSrvce.getMessage(messageid);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(@Context UriInfo uriInfo, Message msg){
      Message newMssg = msgSrvce.addMessage(msg);
      String newId = String.valueOf(newMssg.getId());
      //return msgSrvce.addMessage(msg);
      URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();//Location Header
      return Response.created(uri).entity(newMssg).build();
      //return Response.status(Status.CREATED).entity(newMssg).build();//Status Codes 201-Created
      
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("id")long id,Message msg){
      //msg.setId(id);
      return msgSrvce.updateMessage(msg);
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message deleteMessage(@PathParam("id") long id){
      return msgSrvce.remove(id);
    }
}
