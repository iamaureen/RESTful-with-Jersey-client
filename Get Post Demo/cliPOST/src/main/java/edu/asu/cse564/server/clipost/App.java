/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.cse564.server.clipost;

import com.sun.jersey.api.client.ClientResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author calliss
 */
public class App {
    
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
         
    public static void main( String[] args )
    {
       
        
        CustomGreetingClient greetingClient = new CustomGreetingClient();
        
        greetingClient.postTextGreeting("This is my greeting message");
        
        String responseMessage = greetingClient.getHtmlGreeting();
        
        System.out.println("The message is ");
        System.out.println(responseMessage);
        
        
        
    }
    
}
