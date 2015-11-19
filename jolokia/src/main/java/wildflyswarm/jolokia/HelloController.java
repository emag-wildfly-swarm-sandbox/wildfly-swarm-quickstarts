package wildflyswarm.jolokia;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jolokia.JolokiaFraction;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationPath("/api")
@Path("/")
public class HelloController extends Application {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {
    return "{\"test\": true}";
  }

}
