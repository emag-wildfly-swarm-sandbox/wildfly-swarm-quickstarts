package wildflyswarm.jsf;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container();
    container.start();

    WARArchive deployment = ShrinkWrap.create(WARArchive.class);
    deployment.staticContent();
    deployment.addAsWebInfResource(new StringAsset(
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        "<web-app version=\"3.1\" xmlns=\"http://xmlns.jcp.org/xml/ns/javaee\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
        "         xsi:schemaLocation=\"http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd\">\n" +
        "  <servlet>\n" +
        "    <servlet-name>Faces Servlet</servlet-name>\n" +
        "    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>\n" +
        "    <load-on-startup>1</load-on-startup>\n" +
        "  </servlet>\n" +
        "  <servlet-mapping>\n" +
        "    <servlet-name>Faces Servlet</servlet-name>\n" +
        "    <url-pattern>*.xhtml</url-pattern>\n" +
        "  </servlet-mapping>\n" +
        "</web-app>"), "web.xml");

    container.deploy(deployment);
  }

}
