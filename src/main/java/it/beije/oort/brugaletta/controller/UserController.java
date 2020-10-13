package it.beije.oort.brugaletta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.oort.brugaletta.entity.Libro;
import it.beije.oort.brugaletta.entity.Prestito;
import it.beije.oort.brugaletta.entity.User;
import it.beije.oort.brugaletta.services.BookService;
import it.beije.oort.brugaletta.services.LoanService;

@Controller
public class UserController {
	@Autowired
	private LoanService loanService;
	@Autowired
	private BookService bookService;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/prestiti")
	public String showLoans(HttpServletRequest request, Model model) {
		User sessionUser = (User)request.getSession().getAttribute("loggedUser");
		log.debug(sessionUser.toString());
		List<Prestito> loans = loanService.showUserLoans(sessionUser.getId());
		model.addAttribute("prestiti", loans);
		return "prestiti_utente";
	}
	
	@GetMapping("/nuovoPrestito")
	public String insertLoan(Model model) {
		List<Libro> books = bookService.showBooks();
		log.debug(books.toString());
		model.addAttribute("libri",books);
		return "nuovo_prestito";
	}
}
