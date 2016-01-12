package wildflyswarm.jpa_duplicate_service_exception_with_arq;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Yoshimasa Tanabe
 */
@RunWith(Arquillian.class)
public class ArqIT {

  @Deployment
  public static Archive createDeployment() throws Exception {
    Archive deployment = MyDeployment.createDeployment();

//    System.err.println(deployment.toString(true));

    return deployment;
  }

  @Test
  public void testNothing() throws Exception {}

}
