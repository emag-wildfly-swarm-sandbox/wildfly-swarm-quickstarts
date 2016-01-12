package wildflyswarm.jpa_duplicate_service_exception_with_arq;

import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

/**
 * @author Yoshimasa Tanabe
 */
public class MyDeployment {

  public static Archive createDeployment() throws Exception {
    JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);

//    deployment.addPackages(true, App.class.getPackage());

//    deployment.addAsWebInfResource(
//      new ClassLoaderAsset("META-INF/persistence.xml", App.class.getClassLoader()), "classes/META-INF/persistence.xml");

    deployment.addAllDependencies();

    return deployment;
  }

}
