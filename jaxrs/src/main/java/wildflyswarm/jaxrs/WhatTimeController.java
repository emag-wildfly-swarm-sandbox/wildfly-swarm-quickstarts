package wildflyswarm.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

/**
 * @author Yoshimasa Tanabe
 */
@Path( "/what-time" )
public class WhatTimeController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {
    return "Howdy at " + LocalDateTime.now();
  }

}
