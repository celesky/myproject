package com.jersey.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by pan on 16/8/19.
 */
@Path("/helloworld")
public class HelloWorldResource {


    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
         // Return some cliched textual content
        return "Hello World";
    }
}
