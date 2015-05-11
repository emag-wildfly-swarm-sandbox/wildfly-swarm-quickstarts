package wildflyswarm.jaxrscdi.api;

import wildflyswarm.jaxrscdi.domain.model.Employee;
import wildflyswarm.jaxrscdi.domain.service.EmployeeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationScoped
@Path("/employees")
public class EmployeeController {

  @Inject
  private EmployeeService employeeService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

}
