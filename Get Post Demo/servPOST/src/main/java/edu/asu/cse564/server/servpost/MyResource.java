package edu.asu.cse564.server.servpost;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
    
        private static String greeting;
  

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces("text/html")
    public Response getHtmlGreeting() {
       
        
        Response response;
        response = Response.status(Response.Status.OK).entity(greeting).build();
        
        return response;
    }
    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response postTextGreeting(String content) {
       
        
        greeting = "<html><body><h1>" + content + "</body></h1></html>";
       
        
        Response response;
        response = Response.status(Response.Status.CREATED).build();
        
        return response;
    }
}
