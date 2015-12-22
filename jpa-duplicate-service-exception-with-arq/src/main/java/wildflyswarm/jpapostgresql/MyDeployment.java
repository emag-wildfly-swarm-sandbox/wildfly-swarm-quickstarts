package wildflyswarm.jpapostgresql;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * @author Yoshimasa Tanabe
 */
public class MyDeployment {

  public static JAXRSArchive createDeployment() throws Exception {
    JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

    deployment.addPackages(true, App.class.getPackage());

    deployment.addAsWebInfResource(
      new ClassLoaderAsset("META-INF/persistence.xml", App.class.getClassLoader()), "classes/META-INF/persistence.xml");

    deployment.addAllDependencies();

    return deployment;
  }

}
