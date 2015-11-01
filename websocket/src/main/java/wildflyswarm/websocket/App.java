package wildflyswarm.websocket;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {

    Container container = new Container();

    WARArchive deployment = ShrinkWrap.create(WARArchive.class);
    deployment.staticContent("/");
    deployment.addPackage("wildflyswarm.websocket");

    container.start().deploy(deployment);

  }
}
