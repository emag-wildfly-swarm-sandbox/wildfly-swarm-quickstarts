package wildflyswarm.vaadin.addressbook;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import wildflyswarm.vaadin.addressbook.backend.Contact;

/**
 * @author Yoshimasa Tanabe
 */
public class ContactForm extends FormLayout {

  Button save = new Button("Save", this::save);
  Button cancel = new Button("Cancel", this::cancel);
  TextField firstName = new TextField("First name");
  TextField lastName = new TextField("Last name");
  TextField phone = new TextField("Phone");
  TextField email = new TextField("Email");
  DateField birthDate = new DateField("Birth date");

  Contact contact;

  BeanFieldGroup<Contact> formFieldBindings;

  public ContactForm() {
    configureComponents();
    buildLayout();
  }

  private void configureComponents() {
    save.setStyleName(ValoTheme.BUTTON_PRIMARY);
    save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    setVisible(false);
  }

  private void buildLayout() {
    setSizeUndefined();
    setMargin(true);

    HorizontalLayout actions = new HorizontalLayout(save, cancel);
    actions.setSpacing(true);

    addComponents(actions, firstName, lastName, phone, email, birthDate);
  }

  public void save(Button.ClickEvent event) {
    try {
      formFieldBindings.commit();

      getUI().service.save(contact);

      String message = String.format("Saved '%s %s'.",
        contact.getFirstName(), contact.getLastName());
      Notification.show(message, Notification.Type.TRAY_NOTIFICATION);
      getUI().refreshContacts();
    } catch (FieldGroup.CommitException e) {
      e.printStackTrace();
    }
  }

  public void cancel(Button.ClickEvent event) {
    Notification.show("Cancelled", Notification.Type.TRAY_NOTIFICATION);
    getUI().contactList.select(null);
  }

  void edit(Contact contact) {
    this.contact = contact;
    if (contact != null) {
      formFieldBindings = BeanFieldGroup.bindFieldsBuffered(contact, this);
      firstName.focus();
    }
    setVisible(contact != null);
  }

  @Override
  public AddressbookUI getUI() {
    return (AddressbookUI) super.getUI();
  }
}
