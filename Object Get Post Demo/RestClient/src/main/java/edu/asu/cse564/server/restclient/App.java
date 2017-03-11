/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.server.restclient;



import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;


/**
 *
 * @author Ishrat Ahmed
 */
public class App {
    
   
         
    public static void main( String[] args )
    {
       Client client;
       String BASE_URI = "http://localhost:8080/RestServer/webapi";
       WebResource webResource = null;
        
        try {

			Student st = new Student("Ishrat", "Maureen", 10, 0011);

			ClientConfig config = new DefaultClientConfig();
                        client = com.sun.jersey.api.client.Client.create(config);

                        webResource = client.resource(BASE_URI).path("xmlServices").path("send");
                        System.out.println("<client> webResource = "+ webResource.getURI());
                        
                        ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).post(ClientResponse.class, st);

                        
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response : ");
			System.out.println(output);
                        
                        
                        //get student object 
                        webResource = client.resource(BASE_URI).path("xmlServices").path("print/maureen");
                        Student stu = webResource.accept(MediaType.APPLICATION_XML).get(Student.class);
                        System.out.println("<get object from client> :: " +stu.getFirstName());

		} catch (Exception e) {

			e.printStackTrace();

                        
		}       
        
        
        
        
    }
    
 
    
    
}
