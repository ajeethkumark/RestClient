package com.ajeeth.beanparam;

import javax.ws.rs.QueryParam;

public class StudentFilterBean {
	@QueryParam("name1") String name1;
	@QueryParam("name2") String name2;
	@QueryParam("name3") String name3;
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	
	

}
