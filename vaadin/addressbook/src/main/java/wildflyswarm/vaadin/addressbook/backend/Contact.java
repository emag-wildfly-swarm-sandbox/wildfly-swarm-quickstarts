package wildflyswarm.vaadin.addressbook.backend;

import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Yoshimasa Tanabe
 */
public class Contact implements Serializable, Cloneable {

  private Long id;

  private String firstName = "";
  private String lastName = "";
  private String phone = "";
  private String email = "";
  private Date birthDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public Contact clone() throws CloneNotSupportedException {
    try {
      return (Contact) BeanUtils.cloneBean(this);
    } catch (Exception e) {
      throw new CloneNotSupportedException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contact contact = (Contact) o;

    return id != null ? id.equals(contact.id) : contact.id == null;

  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Contact{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", phone='" + phone + '\'' +
      ", email='" + email + '\'' +
      ", birthDate=" + birthDate +
      '}';
  }

}
