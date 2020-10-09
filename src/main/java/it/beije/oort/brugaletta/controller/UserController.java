package it.beije.oort.brugaletta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.beije.oort.brugaletta.db.JPDBUtilities;
import it.beije.oort.brugaletta.entity.Libro;
import it.beije.oort.brugaletta.entity.Prestito;
import it.beije.oort.brugaletta.entity.User;

@Controller
public class UserController {
	@GetMapping("/prestiti")
	public String showLoans(HttpServletRequest request, Model model) {
		User sessionUser = (User)request.getSession().getAttribute("loggedUser");
		List<Prestito> loans = JPDBUtilities.exportLoans(sessionUser.getId());
		List<Libro> books = JPDBUtilities.exportBooks(sessionUser.getId());
		model.addAttribute("prestiti",loans);
		model.addAttribute("libri", books);
		return "prestiti_utente";
	}
	
	@GetMapping("/nuovoPrestito")
	public String insertLoan() {
		return "nuovo_prestito";
	}
}
