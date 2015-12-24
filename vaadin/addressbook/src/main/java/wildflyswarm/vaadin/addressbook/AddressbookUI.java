package wildflyswarm.vaadin.addressbook;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import wildflyswarm.vaadin.addressbook.backend.Contact;
import wildflyswarm.vaadin.addressbook.backend.ContactService;

import javax.servlet.annotation.WebServlet;

/**
 * @author Yoshimasa Tanabe
 */
@Title("Addressbook")
@Theme("valo")
public class AddressbookUI extends UI {

  TextField filter = new TextField();
  Grid contactList = new Grid();
  Button newContact = new Button("New contact");

  ContactForm contactForm = new ContactForm();

  ContactService service = ContactService.createDemoService();

  @Override
  protected void init(VaadinRequest request) {
    configureComponents();
    buildLayout();
  }

  private void configureComponents() {
    newContact.addClickListener(event -> contactForm.edit(new Contact()));

    filter.setInputPrompt("Filter contacts...");
    filter.addTextChangeListener(event -> refreshContacts(event.getText()));

    contactList.setContainerDataSource(new BeanItemContainer<>(Contact.class));
    contactList.setColumnOrder("firstName", "lastName", "email");
    contactList.removeColumn("id");
    contactList.removeColumn("birthDate");
    contactList.removeColumn("phone");
    contactList.setSelectionMode(Grid.SelectionMode.SINGLE);
    contactList.addSelectionListener(event -> contactForm.edit((Contact) contactList.getSelectedRow()));

    refreshContacts();
  }

  private void buildLayout() {
    HorizontalLayout actions = new HorizontalLayout(filter, newContact);
    actions.setWidth("100%");
    filter.setWidth("100%");
    actions.setExpandRatio(filter, 1);

    VerticalLayout left = new VerticalLayout(actions, contactList);
    left.setSizeFull();
    contactList.setSizeFull();
    left.setExpandRatio(contactList, 1);

    HorizontalLayout mainLayout = new HorizontalLayout(left, contactForm);
    mainLayout.setSizeFull();
    mainLayout.setExpandRatio(left, 1);

    setContent(mainLayout);
  }

  public void refreshContacts() {
    refreshContacts(filter.getValue());
  }

  private void refreshContacts(String stringFilter) {
    contactList.setContainerDataSource(new BeanItemContainer<>(Contact.class, service.findAll(stringFilter)));
    contactForm.setVisible(false);
  }

  @WebServlet(urlPatterns = "/*")
  @VaadinServletConfiguration(ui = AddressbookUI.class, productionMode = false)
  public static class MyUIServlet extends VaadinServlet {}

}
