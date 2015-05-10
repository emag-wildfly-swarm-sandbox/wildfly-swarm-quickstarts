package wildflyswarm.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/arquillian-test")
public class ArquillianTestController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {
    return "{\"test\": true}";
  }

}
