package wildflyswarm.jaxrsjpa;

import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.Datasource;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.datasources.Driver;
import org.wildfly.swarm.jaxrs.JAXRSDeployment;
import wildflyswarm.jaxrsjpa.api.EmployeeController;
import wildflyswarm.jaxrsjpa.domain.model.Employee;
import wildflyswarm.jaxrsjpa.domain.repository.EmployeeRepository;
import wildflyswarm.jaxrsjpa.domain.service.EmployeeService;

/**g
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    Container container = new Container();

    container.subsystem(new DatasourcesFraction()
      .driver(
        new Driver("h2")
          .xaDatasourceClassName("org.h2.jdbcx.JdbcDataSource")
          .module("com.h2database.h2"))
      .datasource(new Datasource("ExampleDS")
          .driver("h2")
          .connectionURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
          .authentication("sa", "sa"))
    );

    container.start();

    JAXRSDeployment jaxRsDeployment = new JAXRSDeployment(container);
    jaxRsDeployment.addResource(EmployeeController.class);
    jaxRsDeployment.getArchive().addClasses(
      Employee.class,
      EmployeeService.class,
      EmployeeRepository.class);
    jaxRsDeployment.getArchive().addAsWebInfResource(
      new ClassLoaderAsset("META-INF/persistence.xml", App.class.getClassLoader()), "classes/META-INF/persistence.xml");
    jaxRsDeployment.getArchive().addAsWebInfResource(
      new ClassLoaderAsset("import.sql", App.class.getClassLoader()), "classes/import.sql");

    container.deploy(jaxRsDeployment);
  }
}
