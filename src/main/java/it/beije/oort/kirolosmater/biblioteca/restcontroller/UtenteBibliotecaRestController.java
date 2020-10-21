package it.beije.oort.kirolosmater.biblioteca.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.kirolosmater.biblioteca.model.UtenteBiblioteca;
import it.beije.oort.kirolosmater.biblioteca.service.UtenteBibliotecaService;

@RestController
@RequestMapping("/biblioteca")
public class UtenteBibliotecaRestController {
	
	@Autowired
	private UtenteBibliotecaService utenteBibliotecaService;

	@RequestMapping(value = "/utente/{id}", method = RequestMethod.GET)
	public UtenteBiblioteca utente(@PathVariable Integer id, Model model) {
		System.out.println("utente : " + id);
		
		UtenteBiblioteca utente = utenteBibliotecaService.load(id);
		
		return utente;
	}
	
}
