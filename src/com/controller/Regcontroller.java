package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.model.Regvo;

@Controller
public class Regcontroller {

	@RequestMapping(value = "form.xyz" , method = RequestMethod.GET)
	public ModelAndView form()
	{
		return new ModelAndView("form");
	}
	
	@RequestMapping(value = "r_form.xyz" , method = RequestMethod.POST)
	public ModelAndView data(@RequestParam("fn") String fn, @RequestParam("ln") String ln, @RequestParam("un") String un, @RequestParam("pass") String pass, HttpSession session)
	{
		session.setAttribute("fn", fn);
		session.setAttribute("ln", ln);
		session.setAttribute("un", un);
		session.setAttribute("pass", pass);
		
		return new ModelAndView("login_form");
	}
	
	@RequestMapping(value = "l_form.xyz" , method = RequestMethod.POST)
	public ModelAndView data(@RequestParam("un") String un, @RequestParam("pass") String pass, HttpSession session)
	{
		String un_1 = (String)session.getAttribute("un");
		String pass_1 = (String)session.getAttribute("pass");
		
		if(un.equals(un_1) && pass.equals(pass_1))
		{
			return new ModelAndView("welcome");
		}
		else	
		{
			return new ModelAndView("login_form");
		}
	}
	
}
