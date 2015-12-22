package wildflyswarm.jpapostgresql;

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
