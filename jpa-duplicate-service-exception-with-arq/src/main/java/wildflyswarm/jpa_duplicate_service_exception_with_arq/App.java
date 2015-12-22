package wildflyswarm.jpa_duplicate_service_exception_with_arq;

import org.wildfly.swarm.container.Container;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    new Container()
      .start()
      .deploy(MyDeployment.createDeployment());
  }

}
