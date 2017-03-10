/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.server.clipost;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;



/**
 * Jersey REST client generated for REST resource:CustomGreetingClient
 * [myresource]<br>
 * USAGE:
 * <pre>
        CustomGreetingClient client = new CustomGreetingClient();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author calliss
 */
public class CustomGreetingClient {

   

    private WebResource webResource = null;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/servPOST/webapi";

    public CustomGreetingClient() {
        System.out.println("Creating a Greeting REST Client");
        
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        
        webResource = client.resource(BASE_URI).path("myresource");
        System.out.println("<client> webResource = "+ webResource.getURI());
    }

    public void postTextGreeting(String greetingMessage) throws UniformInterfaceException {
        System.out.println("<client> Send the greeting message \"" + greetingMessage + "\" to the Custom Greeting REST Server");
        webResource.type(MediaType.TEXT_PLAIN).post(greetingMessage);
    }

    public String getHtmlGreeting() throws UniformInterfaceException  {
        System.out.println("Retrieving the greeting message from to the Custom Greeting REST Server");
        
        WebResource resource = webResource;
        String retrievedGreeting = resource.accept(MediaType.TEXT_HTML).get(String.class);
        System.out.println("<client> <from server> " + retrievedGreeting);
        
        return retrievedGreeting;
    }

    public void close() {
        
        System.out.println("Closing the REST Client");
        
        client.destroy();
    }
    
}
