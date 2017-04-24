package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm()
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, 
										@RequestParam String password, ModelMap mode)
	{
		if(service.validateUser(name, password)){
			mode.put("name", name);
			mode.put("pass", password);
		} else {
			mode.put("errorMessage", "Los parametros de login no son los correctos");
			return "login";
		}
		return "welcome";
	}
	
	
	
}
