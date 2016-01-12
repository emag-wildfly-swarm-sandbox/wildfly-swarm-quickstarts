package wildflyswarm.jpa_duplicate_service_exception_with_arq;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * @author Yoshimasa Tanabe
 */
@RunWith(Arquillian.class)
public class ArqIT {

  @Deployment
  public static Archive createDeployment() throws Exception {
    JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

    deployment.addAllDependencies();

    return deployment;
  }

  @Test
  public void testNothing() throws Exception {}

}
