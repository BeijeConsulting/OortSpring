package it.beije.oort.bm.library.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bm.library.entity.User;
import it.beije.oort.bm.library.service.AuthorService;
import it.beije.oort.bm.library.service.BookService;
import it.beije.oort.bm.library.service.LoanService;
import it.beije.oort.bm.library.service.PublisherService;
import it.beije.oort.bm.library.service.UserService;

@Controller
public class LibraryHomeController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private PublisherService publisherService;
	
	@RequestMapping( value = "/", method = RequestMethod.GET)
	public String home() {
		log.debug("/ - get");
		return "home";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping( value = "/{res}", method = RequestMethod.GET)
	public String home(@PathVariable String res, HttpSession session, Model model) {
		log.debug("/" + res + " - get");
		User logged = (User) session.getAttribute("user");
		List list = null;
		List selector1 = null;
		List selector2 = null;
		switch(res) {
			case "books":
				list = bookService.getAll();
				selector1 = authorService.getAll();
				selector2 = publisherService.getAll();
				model.addAttribute("authors", selector1);
				model.addAttribute("publishers", selector2);
				break;
			case "authors":
				list = authorService.getAll();
				break;
			case "publish":
				list = publisherService.getAll();
				break;
			case "loans":
				if(logged != null) {
					list = loanService.getLoans(logged);
				}
				break;
			case "users":
				list = userService.getAll();
				break;
		}
		session.setAttribute("status", res);
		model.addAttribute("data_list", list);
		return "home";
	}
	
}
