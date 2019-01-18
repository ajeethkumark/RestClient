package ajeeth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ok")
public class StringReturn {
	
	
	@GET
	@Path("/data")
	@Produces(MediaType.TEXT_PLAIN)
	public String getString()
	{
		return "Make It Ajeeth";
	}

}
