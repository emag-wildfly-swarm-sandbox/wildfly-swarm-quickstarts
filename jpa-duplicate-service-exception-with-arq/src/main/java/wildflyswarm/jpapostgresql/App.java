package wildflyswarm.jpapostgresql;

/**
 * @author Yoshimasa Tanabe
 */
public class App {

  public static void main(String[] args) throws Exception {
    MyContainer.newContainer()
      .start()
      .deploy(MyDeployment.createDeployment());
  }

}
