package it.beije.oort.bassanelli.library_application.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.entity.Author;
import it.beije.oort.bassanelli.library_application.service.AuthorService;
import it.beije.oort.entity.Utente;

@Controller
public class AuthorController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorService authorService;
	
	private static final String root = "/library";
	
	@RequestMapping(value = root + "/author/{id}", method = RequestMethod.GET)
	public String author(@PathVariable Integer id, Model model) {
	
		Author author = authorService.load(id);
		
		model.addAttribute("author", author);
		
		return root + "/entity/author";
	}
	
}
