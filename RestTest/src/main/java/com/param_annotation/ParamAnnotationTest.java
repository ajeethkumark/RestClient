package com.param_annotation;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test1")
public class ParamAnnotationTest {
	@PathParam("pathParam") private String pathParamExample;
	@QueryParam("query") private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String paramTest(@MatrixParam("param") String matrixParam, @HeaderParam("customeHeaderValue") String headerValue)
	{
		//path sample:  http://localhost:8080/RestTest/rest/ok/test1;param=:matrix?query=querytest
		//cookies param still pending
		//FormParam is not widly use, make the request from html these param used (it have key value pair pattern)
		return "It work! pathParam value is:"+pathParamExample+"  queryParam value is:"+queryParamExample+"   MatrixParam:"+matrixParam
				+"    HeaderValue:"+headerValue;
	}

}
