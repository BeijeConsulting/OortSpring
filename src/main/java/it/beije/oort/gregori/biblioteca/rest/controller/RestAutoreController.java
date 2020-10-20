package it.beije.oort.gregori.biblioteca.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.gregori.biblioteca.Autore;
import it.beije.oort.gregori.biblioteca.service.AutoreService;

@RestController
@RequestMapping(value = "/api")
public class RestAutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@RequestMapping(value = "/autori", method = RequestMethod.GET)
	public List<Autore> getAutori() {
		List<Autore> autori = autoreService.findAll();
		
		System.out.println("autori: " + autori);
		
		return autori;
	}
	
	@PostMapping("/autori")
	public Autore autore(@RequestBody Autore autore, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati autore..." + autore);
		
		autoreService.insert(autore);
		
		return autore;
	}
	
	@PutMapping("/autori/{id}")
	public Autore autore(@RequestBody Autore autore, @PathVariable Integer id, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati autore..." + autore);
		
		if (autore.getId() != null && autore.getId() != id) {
			throw new IllegalArgumentException("ID NON VALIDO!!!");
		}
		
		return autoreService.update(id, autore);
	}


}
