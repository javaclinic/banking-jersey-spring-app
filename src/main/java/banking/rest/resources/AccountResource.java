package banking.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banking.dao.AccountDao;
import banking.model.Account;

@Path("accounts")
public class AccountResource {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public AccountResource() {
		LOGGER.info("Constructing AccountResource object.");
	}
	
	private AccountDao dao;
	
	@Inject
	public void setDao(AccountDao dao)  {
		LOGGER.info("Injecting dao object: " + dao);
		this.dao = dao;
	}

	@GET
	public Response getAccount() {
		return Response.ok(dao.findAccounts()).build();
	}

	@GET
	@Path("{id}")
	public Response getAccount(@PathParam("id") Integer id) {
		Account account = dao.findAccountById(id);
		if ( account == null ) return Response.status(Status.NOT_FOUND).build();
		return Response.ok(dao.findAccountById(id)).build();
	}

}
