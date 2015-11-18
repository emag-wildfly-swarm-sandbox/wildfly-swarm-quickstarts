package wildflyswarm.jolokia;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jolokia.JolokiaFraction;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container();
    container.start();
  }

}
