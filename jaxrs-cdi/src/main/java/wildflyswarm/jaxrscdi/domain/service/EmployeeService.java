package wildflyswarm.jaxrscdi.domain.service;

import wildflyswarm.jaxrscdi.domain.model.Employee;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationScoped
public class EmployeeService {

  public List<Employee> findAll() {
    return new ArrayList<Employee>() {{
      add(new Employee(1L, "emp01"));
      add(new Employee(2L, "emp02"));
    }};
  }

}
