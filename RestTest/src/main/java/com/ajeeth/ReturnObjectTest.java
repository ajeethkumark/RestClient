package com.ajeeth;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.repository.Repository;

@Path("/return")
public class ReturnObjectTest {
	
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/data")
	public List<DataClass> getData() throws SQLException
	{
		
		System.out.println("Enter.. to returnobject getdata");
		
	/*	DataClass dc=new DataClass();
		dc.setName("hello");
		dc.setValue(100);
		List l=new ArrayList<DataClass>();
		l.add(dc);  */
		return new Repository().getData();
		
	
	}
	@GET
	@Path("/particulardata/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DataClass getData(@PathParam("id") int id) throws SQLException
	{
		return new Repository().getData(id);
	}
	
	@POST
	@Path("/setdata")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response setData(DataClass dc,@Context UriInfo uriInfo)
	{
		try
		{
		/*System.out.println("post method called");
		new Repository().createData(dc);
		System.out.println(dc.size());
		System.out.println("post method called over");*/
		//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		return Response.created(uriInfo.getAbsolutePath()).entity(new Repository().createData(dc)).build();
		}
		catch(Exception e)
		{
			System.out.println("past exception");
			e.printStackTrace();
		}

		//return dc;
		return null;
	}
	
	
	
	@PUT
	@Path("/updatedata")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<DataClass> updateData(List<DataClass> dc)
	{
		try
		{
		System.out.println("update method called");
		new Repository().madifyData(dc);
		System.out.println(dc.size());
		System.out.println("update method called over");
		//@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		}
		catch(Exception e)
		{
			System.out.println("update exception");
			e.printStackTrace();
		}

		return dc;
	}
	
	@DELETE
	@Path("/remove/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<DataClass> removeData(@PathParam("id") int id)
	{
		DataClass dc=new Repository().getData(id);
		if(dc.getValue()!=0)
		{
			new Repository().deleteData(id);
		}
		return new Repository().getData();
	}
	
	@GET
	@Path("/subpath")
	public SubResourceImplementation test()
	{
		System.out.println("entering to test method");
		//sub folder implementation not working
		return new SubResourceImplementation();
		//return "test";
	}

}


