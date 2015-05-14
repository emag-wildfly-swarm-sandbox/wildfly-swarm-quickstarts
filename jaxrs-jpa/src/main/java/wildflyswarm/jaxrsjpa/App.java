package wildflyswarm.jaxrsjpa;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.Datasource;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.datasources.Driver;
import org.wildfly.swarm.jaxrs.JaxRsDeployment;
import wildflyswarm.jaxrsjpa.api.EmployeeController;
import wildflyswarm.jaxrsjpa.domain.model.Employee;
import wildflyswarm.jaxrsjpa.domain.repository.EmployeeRepository;
import wildflyswarm.jaxrsjpa.domain.service.EmployeeService;

/**
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
          .authentication("sa", "sa")
      ));

    JaxRsDeployment jaxRsDeployment = new JaxRsDeployment();
    jaxRsDeployment
      .addResource(Employee.class)
      .addResource(EmployeeController.class)
      .addResource(EmployeeService.class)
      .addResource(EmployeeRepository.class);

    container.deploy(jaxRsDeployment);
  }
}
