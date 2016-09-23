package com.service.user;

import javax.ws.rs.*;
import org.codehaus.jettison.json.JSONObject;

@Path("/user/service")
public class UserServices {
	@GET
	public void getUser() {
		System.out.println("Inside getUser()!");
	}

	@POST
	public void updateUser(UserDetails user) {
		System.out.println("Inside updateUser() - "+user.getName() + " - "+ user.getEmail());
		ManagerDiscuss mgr = new ManagerDiscuss();
		mgr.validateUser(user);
	}	
}
