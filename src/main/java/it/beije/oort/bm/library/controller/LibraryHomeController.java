package it.beije.oort.bm.library.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.beije.oort.bm.library.database.*;
import it.beije.oort.bm.library.entity.*;

@Controller
public class LibraryHomeController {
	
	private static Database db = ConcreteDatabase.getDatabase();
	
	@RequestMapping( value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping( value = "/", method = RequestMethod.POST)
	public String home(HttpServletRequest req, Model model) {
		String param = req.getParameter("res");
		HttpSession session = req.getSession();
		User logged = (User) session.getAttribute("user");
		List list = null;
		List selector1 = null;
		List selector2 = null;
		switch(param) {
			case "books":
				list = db.getAll(Book.class);
				selector1 = db.getAll(Author.class);
				selector2 = db.getAll(Publisher.class);
				model.addAttribute("authors", selector1);
				model.addAttribute("publishers", selector2);
				break;
			case "authors":
				list = db.getAll(Author.class);
				break;
			case "publish":
				list = db.getAll(Publisher.class);
				break;
			case "loans":
				if(logged != null && !logged.getAdmin()) {
					Loan searchParams = new Loan();
					searchParams.setUser(logged);
					list = db.searchRecord(Loan.class, searchParams);
				} else {
					list = db.getAll(Loan.class);
				}
				break;
			case "users":
				list = db.getAll(User.class);
				break;
		}
		req.getSession().setAttribute("status", param);
		model.addAttribute("data_list", list);
		return "home";
	}
	
	@RequestMapping( value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User u = new User();
		u.setPassword(password);
		u.setEmail(email);
		List<User> result = db.searchRecord(User.class, u);
		if(result.size() != 1) {
			model.addAttribute("tmpEmail", email);
			model.addAttribute("loginError", "Credenziali errate, riprova.");
		}else {
			session.setAttribute("user", result.get(0));
		}
		
		return "home";
	}
	
	@RequestMapping( value = "/register", method = RequestMethod.POST)
	public String register(User user, HttpServletRequest req, Model model) {
		boolean result = false;
		String pswd_conf = req.getParameter("reg_pswd_conf");
		if(!user.getPassword().equals(pswd_conf)) {
			model.addAttribute("registrationProblem", "Field 'Password' and field 'Confirm Password' must be equals.");
		}else {
			result = db.add(user);
		}
		if(!result) {
			model.addAttribute("registrationProblem", "Email already in use.");
		} else {
			req.getSession().setAttribute("status", "login");
		}
		return "home";
	}
}
