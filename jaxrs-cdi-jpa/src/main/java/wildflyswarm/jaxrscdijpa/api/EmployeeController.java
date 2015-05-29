package wildflyswarm.jaxrscdijpa.api;

import wildflyswarm.jaxrscdijpa.domain.model.Employee;
import wildflyswarm.jaxrscdijpa.domain.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/employees")
public class EmployeeController {

  @Inject
  private EmployeeService employeeService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GET
  @Path(("{id}"))
  @Produces(MediaType.APPLICATION_JSON)
  public Response find(@PathParam("id") long id) {
    Employee employee = employeeService.find(id);

    if (employee == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok(employee).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(@Context UriInfo uriInfo, Employee employee) {
    Employee created = employeeService.save(employee);

    return Response
      .created(
        uriInfo.getAbsolutePathBuilder()
          .path(String.valueOf(created.getId()))
          .build())
      .build();
  }

  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response update(@PathParam("id") long id, Employee employee) {
    Employee old = employeeService.find(id);

    if (old == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    old.setName(employee.getName());
    employeeService.save(old);

    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") Long id) {
    if (employeeService.find(id) == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    employeeService.delete(id);

    return Response.noContent().build();
  }

  @DELETE
  public Response deleteAll() {
    employeeService.deleteAll();
    return Response.noContent().build();
  }

}
