package wildflyswarm.jpa_duplicate_service_exception_with_arq;

import org.joda.time.DateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/")
public class MyResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {
    return String.format("{\"value\" : \"The time is %s\"}", new DateTime());
  }

}
