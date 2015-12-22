package wildflyswarm.jpapostgresql;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.ContainerFactory;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * @author Yoshimasa Tanabe
 */
@RunWith(Arquillian.class)
public class ArqIT implements ContainerFactory {

  @Deployment
  public static JAXRSArchive createDeployment() throws Exception {
    JAXRSArchive deployment = MyDeployment.createDeployment();

//    System.err.println(deployment.toString(true));

    return deployment;
  }

  @Override
  public Container newContainer(String... args) throws Exception {
    return MyContainer.newContainer();
  }

  @Test
  public void testNothing() throws Exception {}

}
