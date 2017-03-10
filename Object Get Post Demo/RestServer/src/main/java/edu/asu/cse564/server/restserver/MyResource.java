/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.server.restserver;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




/**
 * Root resource (exposed at "myresource" path)
 */
@Path("xmlServices")
public class MyResource {

      @GET
    	@Path("/print/{name}")
    	@Produces(MediaType.APPLICATION_XML)
    	public Student responseMsg( @PathParam("name") String name ) {

    		Student st = new Student(name, "Quraishi",22,1);

    		return st;
        //in the browser- http://localhost:8080/RestServer/webapi/xmlServices/print/mau

	}

      @POST
      @Path("send")
      @Consumes(MediaType.APPLICATION_XML)
	public Response consumeXML( Student student ) {

		String output = student.toString();
		return  Response.status(200).entity(output).build();
	}
}
