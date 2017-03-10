package com.github.fr3d3rico.testespringapacheoltu.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/test")
public class FirstTestController {
	
	@GET
	@Path("/get1")
	public String get1() {
		return "/get1";
	}
	
	@GET
	@Path("/get2")
	public String get2() {
		return "/get2";
	}

}
