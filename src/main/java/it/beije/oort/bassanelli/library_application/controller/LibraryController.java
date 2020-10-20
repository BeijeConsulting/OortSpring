package it.beije.oort.bassanelli.library_application.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.entity.User;


@Controller
public class LibraryController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String root = "/library";
	
	@RequestMapping(value = root, method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		return enterIndexPage(request, response, model, locale);
	}
	
	
	@RequestMapping(value = root + "/index", method = RequestMethod.GET)
	public String enterIndexPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			
			return root + "/index";
			
		} else {
			
			return root + "/login";
			
		}
	}
	
	@RequestMapping(value = root + "/sign_in", method = RequestMethod.GET)
	public String enterSignInPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/sign_in";
	}
	
	@RequestMapping(value = root + "/profile", method = RequestMethod.GET)
	public String enterProfilePage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/profile";
	}
	
	@RequestMapping(value = root + "/view", method = RequestMethod.GET)
	public String enterViewPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/view";
	}
	
	@RequestMapping(value = root + "/borrow", method = RequestMethod.GET)
	public String enterBorrowPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/borrow";
	}
	
	@RequestMapping(value = root + "/manage/users", method = RequestMethod.GET)
	public String enterManageUsersPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/manage/users";
	}
	
	@RequestMapping(value = root + "/manage/books", method = RequestMethod.GET)
	public String enterManageBooksPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/manage/books";
	}
	
	@RequestMapping(value = root + "/manage/authors", method = RequestMethod.GET)
	public String enterManageAuthorsPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/manage/authors";
	}
	
	@RequestMapping(value = root + "/manage/publishers", method = RequestMethod.GET)
	public String enterManagePublishersPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/manage/publishers";
	}
	
	@RequestMapping(value = root + "/manage/borrows", method = RequestMethod.GET)
	public String enterManageBorrowsPage(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		log.info("PATH: " + request.getContextPath());
		
		return root +"/manage/borrows";
	}
	
	
}
