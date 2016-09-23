package com.service.user;

public class ManagerDiscuss {
	public String validateUser (UserDetails user) {
		if((user.getName()==null || user.getName().isEmpty())) {
			return "Please enter User Name value.";
		}
		else {
			UserDML userChange = new UserDML();
			return userChange.insert(user);
		}
	}
}
