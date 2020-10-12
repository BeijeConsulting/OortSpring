package it.beije.oort.lauria.biblioteca.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.entity.Autore;
import it.beije.oort.lauria.biblioteca.entity.Editore;
import it.beije.oort.lauria.biblioteca.entity.Libro;
import it.beije.oort.lauria.biblioteca.entity.Utente;

@Controller
public class VisualLibriController {
	
	@RequestMapping(value = "/visualizza_libri", method = RequestMethod.GET)
	public String visualizzaLibri(Utente utente, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual libri get...");
		List<Libro> libri = JPADBtools.selectLibri();
		model.addAttribute("libri", libri);
		//request.getSession().setAttribute("catalogoLibri", libri);
		List<Autore> autori = JPADBtools.selectAutori();
		model.addAttribute("autori", autori);
		//request.getSession().setAttribute("catalogoAutori", autori);
		List<Editore> editori = JPADBtools.selectEditori();
		model.addAttribute("editori", editori);
		//request.getSession().setAttribute("catalogoEditori", editori);
		request.getSession().getAttribute("utente");
		System.out.println(utente.getNome());
		return "visualizza_libri";
	}

}
