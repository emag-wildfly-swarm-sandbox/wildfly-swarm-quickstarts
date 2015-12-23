package wildflyswarm.vaadin.addressbook.backend;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yoshimasa Tanabe
 */
public class ContactService {

  static String[] firstNames = {"Peter", "Alice", "John", "Mike", "Olivia",
    "Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene", "Lisa",
    "Linda", "Timothy", "Daniel", "Brian", "George", "Scott",
    "Jennifer"};

  static String[] lastNames = {"Smith", "Johnson", "Williams", "Jones",
    "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
    "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin",
    "Thompson", "Young", "King", "Robinson"};

  private static ContactService instance;

  public static ContactService createDemoService() {
    if (instance == null) {
      final ContactService contactService = new ContactService();

      Random r = new Random(0);
      Calendar cal = Calendar.getInstance();
      for (int i = 0; i < 100; i++) {
        Contact contact = new Contact();
        contact.setFirstName(firstNames[r.nextInt(firstNames.length)]);
        contact.setLastName((lastNames[r.nextInt(lastNames.length)]));
        contact.setEmail(contact.getFirstName().toLowerCase() + "@" + contact.getLastName().toLowerCase() + ".com");
        contact.setPhone("+ 358 555 " + (100 + r.nextInt(900)));
        cal.set(1930 + r.nextInt(70), r.nextInt(11), r.nextInt(28));
        contact.setBirthDate(cal.getTime());
        contactService.save(contact);
      }

      ContactService.instance = contactService;
    }

    return instance;
  }

  private Map<Long, Contact> contacts = new HashMap<>();
  private long nextId;

  public synchronized List<Contact> findAll(String stringFilter) {
    List<Contact> filteredContacts = new ArrayList<>();

    for (Contact contact : contacts.values()) {
      try {
        boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
          || contact.toString().toLowerCase().contains(stringFilter.toLowerCase());

        if (passesFilter) {
          filteredContacts.add(contact.clone());
        }
      } catch (CloneNotSupportedException e) {
        Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, e);
      }
    }

    Collections.sort(filteredContacts, (o1, o2) -> (int) (o2.getId() - o1.getId()));

    return filteredContacts;
  }

  public synchronized long count() {
    return contacts.size();
  }

  public synchronized void delete(Contact contact) {
    contacts.remove(contact.getId());
  }

  public strictfp void save(Contact contact) {
    if (contact.getId() == null) {
      contact.setId(nextId++);
    }
    try {
      contact = (Contact) BeanUtils.cloneBean(contact);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    contacts.put(contact.getId(), contact);
  }

}
