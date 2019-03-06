package com.ajeeth.beanparam;


import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/beanparamtest")
public class StudentInformation {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBeanParamValues(@BeanParam StudentFilterBean filter)
	{
		// always remember paging and filtering don't repeat the get function for each scenario
		return "name1:"+filter.getName1()+"  name2:"+filter.getName2()+"  name3:"+filter.getName3();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("test")
	public String test()
	{
		return "test";
	}

}
