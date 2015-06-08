package wildflyswarm.keycloak.domain.repository;

import wildflyswarm.keycloak.domain.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationScoped
public class EmployeeRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Employee> findAll() {
    return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
  }

  public Employee find(Long id) {
    return em.find(Employee.class, id);
  }

  @Transactional
  public Employee save(Employee employee) {
    if (employee.getId() == null) {
      em.persist(employee);
      return employee;
    } else {
      return em.merge(employee);
    }
  }

  @Transactional
  public void delete(Long id) {
    delete(em.find(Employee.class, id));
  }

  @Transactional
  private void delete(Employee employee) {
    em.remove(employee);
  }

  @Transactional
  public void deleteAll() {
    findAll().forEach(this::delete);
  }

}
