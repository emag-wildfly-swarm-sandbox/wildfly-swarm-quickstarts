package wildflyswarm.jpa_duplicate_service_exception_with_arq;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.junit.Assert.*;

/**
 * @author Yoshimasa Tanabe
 */
@RunWith(Arquillian.class)
public class ArqIT {

  @ArquillianResource
  private URI deploymentURI;

  @Deployment(testable = false)
  public static Archive createDeployment() throws Exception {
    return MyDeployment.createDeployment();
  }

  @Test
  public void test() throws Exception {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(UriBuilder.fromUri(deploymentURI));

    // ClassNotFoundException
    assertTrue(target.request(MediaType.APPLICATION_JSON).get(String.class)
      .contains("The time is"));

    client.close();
  }

}
