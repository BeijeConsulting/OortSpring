package it.beije.oort.bm.library.controller;

//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import it.beije.oort.bm.library.entity.User;
//import it.beije.oort.bm.library.service.UserService;

@Controller
public class LibraryAuthenticationController {

//	private Logger log = Logger.getLogger(this.getClass());
//	
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping( value = "/login", method = RequestMethod.POST)
//	public String login(HttpServletRequest req, Model model) {
//		log.debug("/login - post");
//		HttpSession session = req.getSession();
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		session.setAttribute("user", userService.login(email, password, model));
//		return "home";
//	}
//	
//	@RequestMapping( value = "/register", method = RequestMethod.POST)
//	public String register(User user, HttpServletRequest req, HttpServletResponse resp, Model model) {
//		log.debug("/register - post");
//		boolean result = false;
//		String pswd_conf = req.getParameter("reg_pswd_conf");
//		if(user==null) {
//			throw new IllegalArgumentException("user is null");
//		}else if(user.getEmail() == null || user.getEmail().equals("")) {
//			model.addAttribute("registrationProblem", "Field 'Email' is required.");
//		}else if(!user.getPassword().equals(pswd_conf)) {
//			model.addAttribute("registrationProblem", "Field 'Password' and field 'Confirm Password' must be equals.");
//		}else {
//			result = userService.register(user);
//		}
//		if(!result) {
//			model.addAttribute("registrationProblem", "Email already in use.");
//		} else {
//			try {
//				resp.sendRedirect("/login");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return "home";
//	}
}
