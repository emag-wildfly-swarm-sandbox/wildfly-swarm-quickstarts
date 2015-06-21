package wildflyswarm.websocket;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.jaxrs.JAXRSDeployment;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {

    Container container = new Container();

    JAXRSDeployment deployment = new JAXRSDeployment(container);
    deployment.staticContent("/");
    deployment.getArchive().addPackage("wildflyswarm.websocket");

    container.start().deploy(deployment);

  }
}
