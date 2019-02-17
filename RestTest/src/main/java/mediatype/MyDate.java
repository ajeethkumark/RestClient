package mediatype;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/date")
public class MyDate {

	@GET
	@Produces("datemedia/test")
	public Date getDate()
	{
		System.out.println("Enter into mydate");
		return Calendar.getInstance().getTime();
		
	}
}
