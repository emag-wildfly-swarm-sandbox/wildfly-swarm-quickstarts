package wildflyswarm.jpapostgresql;

import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;

/**
 * @author Yoshimasa Tanabe
 */
public class MyContainer {

  public static Container newContainer(String... args) throws Exception {
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

    return container;
  }

}
