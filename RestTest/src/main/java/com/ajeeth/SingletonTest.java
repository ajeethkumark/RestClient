package com.ajeeth;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/singleton")
public class SingletonTest {

		private int count=0;
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String singletonMethodTest()
		{
			count++;
			return Integer.toString(count);
		}
}
