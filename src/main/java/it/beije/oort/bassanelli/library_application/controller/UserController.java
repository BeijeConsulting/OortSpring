package it.beije.oort.bassanelli.library_application.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.beije.oort.bassanelli.library_application.database_manager.JavaPersistenceDBManager;
import it.beije.oort.bassanelli.library_application.entity.User;
import it.beije.oort.bassanelli.library_application.service.UserService;

@Controller
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;

	private static final String root = "/library";

	@RequestMapping(value = root + "/login-user", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale)
			throws UnsupportedEncodingException {

		log.info("PATH: " + request.getContextPath());

		HttpSession session = request.getSession();

		String email = URLDecoder.decode(request.getParameter("email"), "UTF-8");
		String password = request.getParameter("password");

		User user = userService.login(email, password);
		
		// User user = JavaPersistenceDBManager.loginUser(email, password);

		if (user != null) {
			// log.debug(user.toString());
			session.setAttribute("user", user);
			
			if(user.getAdmin()) {
				return root + "/admin";
			} else {
				return root + "/index";
			}
		} else {
			
			model.addAttribute("message", "The user is not valid");
			
			return root + "/login";
		}
	}

	@RequestMapping(value = root + "/logout-user", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale)
			throws UnsupportedEncodingException {
		log.info("PATH: " + request.getContextPath());

		HttpSession session = request.getSession();
		session.setAttribute("user", null);

		return root + "/index";

	}

	@RequestMapping(value = root + "/signin-user", method = RequestMethod.POST)
	public String signin(User user, HttpServletRequest request, HttpServletResponse response, Model model,
			Locale locale) throws UnsupportedEncodingException {
		log.info("PATH: " + request.getContextPath());

		user.setAdmin(false);

		// JavaPersistenceDBManager.signinUser(user);

		userService.insert(user);
		
		model.addAttribute("message", "The user has been registered");

		return root + "/sign_in";

	}

	@RequestMapping(value = root + "/edit-user", method = RequestMethod.POST)
	public String edit(User user, HttpServletRequest request, HttpServletResponse response, Model model, Locale locale)
			throws UnsupportedEncodingException {
		log.info("PATH: " + request.getContextPath());

		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");

		// System.out.println(userSession.getId());
		
		// JavaPersistenceDBManager.editUser(userSession.getId(), user);
		
		user.setId(userSession.getId());
		user.setFiscalCode(userSession.getFiscalCode());
		user.setEmail(userSession.getEmail());
		user.setAdmin(userSession.getAdmin());
		
		userService.update(userSession.getId(), user);
		
		session.setAttribute("user", user);

		model.addAttribute("message", "The user is updated");

		return root + "/profile";

	}
}