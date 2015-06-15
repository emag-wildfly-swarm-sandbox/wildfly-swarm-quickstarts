package wildflyswarm.jsf;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.StaticDeployment;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container();

    StaticDeployment deployment = new StaticDeployment(container);

    container.start(deployment);
  }

}
