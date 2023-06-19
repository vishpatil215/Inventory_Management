package com.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String loginPage()
	{
		return "index";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request)
	{
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(uname.equals("vishal215@gmail.com") && pass.equals("vishal@215"))
		{
			return "dashboard";
		}
		else{
		return "index";}
	}
	@RequestMapping("/rawM")
	public String raw()
	{
		return "rawM";
	}

}
