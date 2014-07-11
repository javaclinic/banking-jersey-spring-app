package banking.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banking.dao.CustomerDao;
import banking.model.Customer;

@Path("customers")
public class CustomerResource {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public CustomerResource() {
		LOGGER.info("Constructing CustomerResource object.");
	}
	
	private CustomerDao dao;
	
	@Inject
	public void setDao(CustomerDao dao)  {
		LOGGER.info("Injecting dao object: " + dao);
		this.dao = dao;
	}

	@GET
	public Response getCustomers() {
		return Response.ok(dao.findCustomers()).build();
	}

	@GET
	@Path("{id}")
	public Response getCustomer(@PathParam("id") Integer id) {
		Customer customer = dao.findCustomerById(id);
		if ( customer == null ) return Response.status(Status.NOT_FOUND).build();
		return Response.ok(dao.findCustomerById(id)).build();
	}
	
}
