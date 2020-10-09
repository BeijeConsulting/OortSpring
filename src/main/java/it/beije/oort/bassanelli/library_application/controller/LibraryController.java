package it.beije.oort.bassanelli.library_application.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.database_manager.JavaPersistenceDBManager;
import it.beije.oort.bassanelli.library_application.entity.User;


@Controller
public class LibraryController {
	
	private static final String root = "/library";
	
	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("path: " + request.getContextPath());
		
		return root +"/login";
	}
	
	@RequestMapping(value = "/library/login-user", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) throws UnsupportedEncodingException {
		System.out.println("path: " + request.getContextPath());
		
		String email = URLDecoder.decode(request.getParameter("email"), "UTF-8");
		String password = request.getParameter("password");
		
		User user = JavaPersistenceDBManager.loginUser(email, password);
		
		if(user != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return root +"/index";
			
		} else {
			
			return root +"/login";
			
		}
	}
	
	
	
}
