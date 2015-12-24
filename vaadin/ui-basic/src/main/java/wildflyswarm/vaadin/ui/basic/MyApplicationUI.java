package wildflyswarm.vaadin.ui.basic;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * @author Yoshimasa Tanabe
 */
public class MyApplicationUI extends UI {

  @Override
  protected void init(VaadinRequest request) {
    VerticalLayout view = new VerticalLayout();
    view.addComponent(new Label("Hello Vaadin!"));
    setContent(view);
  }

  @WebServlet(urlPatterns = "/*")
  @VaadinServletConfiguration(ui = MyApplicationUI.class, productionMode = false)
  public static class MyUIServlet extends VaadinServlet {}

}
