package wildflyswarm.jaxrs;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author Yoshimasa Tanabe
 */
@RunWith(Arquillian.class)
@RunAsClient
public class ArquillianTestControllerIT {

  @Deployment
  public static JavaArchive deploy() {
    /* Future api
      return ShrinkWrap.create(WildFlySwarmImporter.class)
            .loadPomFromFile(new File("pom.xml"))
            .importBuildOutput().as(JavaArchive.class);
    */

    return ShrinkWrap.createFromZipFile(
      JavaArchive.class,
      new File("target/jaxrs-arquillian-cube-1.0.0-swarm.jar")
    );
  }

  @ArquillianResource
  private URI deploymentUri;

  @Test
  public void test() throws Exception {
    TimeUnit.SECONDS.sleep(1);

    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(UriBuilder.fromUri(deploymentUri).path("arquillian-test"));

    String response = target.request().get(String.class);

    Assert.assertThat(response, is("{\"test\": true}"));

  }
}