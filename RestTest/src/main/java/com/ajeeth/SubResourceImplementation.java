package com.ajeeth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

@Path("/")
public class SubResourceImplementation {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("enter")
	public String subResourcetest()
	{
		System.out.println("entering to subfolder method");
		return  "test";
	}

}
