package wildflyswarm.keycloak;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jpa.JPAFraction;
import wildflyswarm.keycloak.api.EmployeeController;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container();

    container.fraction(new DatasourcesFraction()
      .jdbcDriver("h2", (d) -> {
        d.driverDatasourceClassName("org.h2.Driver");
        d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
        d.driverModuleName("com.h2database.h2");
      })
      .dataSource("MyDS", (ds) -> {
        ds.driverName("h2");
        ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        ds.userName("sa");
        ds.password("sa");
      })
    );

    container.fraction(new JPAFraction()
      .inhibitDefaultDatasource()
      .defaultDatasource("jboss/datasources/MyDS")
    );

    container.start();

    JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

    deployment.addResource(EmployeeController.class);

    deployment.addPackages(true, "wildflyswarm");
    
    deployment.addAsWebInfResource(
      new ClassLoaderAsset("META-INF/persistence.xml", App.class.getClassLoader()), "classes/META-INF/persistence.xml");
    deployment.addAsWebInfResource(
      new ClassLoaderAsset("import.sql", App.class.getClassLoader()), "classes/import.sql");

    container.deploy(deployment);
    ;
  }
}
