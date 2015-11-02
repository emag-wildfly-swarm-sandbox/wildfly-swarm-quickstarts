package wildflyswarm.jaxrscdijpa.domain.service;

import wildflyswarm.jaxrscdijpa.domain.model.Employee;
import wildflyswarm.jaxrscdijpa.domain.repository.EmployeeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationScoped
public class EmployeeService {

  @Inject
  private EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Employee find(Long id) {
    return employeeRepository.find(id);
  }

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void delete(Long id) {
    employeeRepository.delete(id);
  }

  public void deleteAll() {
    employeeRepository.deleteAll();
  }

}
