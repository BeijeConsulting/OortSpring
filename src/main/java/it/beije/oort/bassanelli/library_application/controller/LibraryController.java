package it.beije.oort.bassanelli.library_application.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.entity.User;


@Controller
public class LibraryController {
	
	private static final String root = "/library";
	
	@RequestMapping(value = root, method = RequestMethod.GET)
	public String enterLoginPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("path: " + request.getContextPath());
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			
			return root + "/home";
			
		} else {
			
			return root +"/login";
			
		}
	}
	
	@RequestMapping(value = root + "/sign_in", method = RequestMethod.GET)
	public String enterSignInPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("path: " + request.getContextPath());
		
		return root +"/sign_in";
	}
	
	@RequestMapping(value = root + "/profile", method = RequestMethod.GET)
	public String enterProfilePage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("path: " + request.getContextPath());
		
		return root +"/profile";
	}
	
	@RequestMapping(value = root + "/view", method = RequestMethod.GET)
	public String enterViewPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("path: " + request.getContextPath());
		
		return root +"/view";
	}
	
}
