package it.beije.oort.lauria.biblioteca;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.biblioteca.Editore;
import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.biblioteca.Utente;
import it.beije.oort.lauria.repository.PrestitoRepository;
import it.beije.oort.lauria.service.AutoreService;
import it.beije.oort.lauria.service.EditoreService;
import it.beije.oort.lauria.service.LibroService;
import it.beije.oort.lauria.service.PrestitoService;
import it.beije.oort.lauria.service.UtenteService;


@Controller
public class VisualController {
	
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutoreService autoreService;
	
	@Autowired
	private EditoreService editoreService;
	
	@Autowired
	private PrestitoService prestitoService;
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/visualizza_libri", method = RequestMethod.GET)
	public String visualizzaLibri( HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual libri get...");
		List<Libro> libri = libroService.findAll(); // JPADBtools.selectLibri();
		model.addAttribute("libri", libri);
		//request.getSession().setAttribute("catalogoLibri", libri);
		List<Autore> autori = autoreService.findAll(); // JPADBtools.selectAutori();
		model.addAttribute("autori", autori);
		//request.getSession().setAttribute("catalogoAutori", autori);
		List<Editore> editori = editoreService.findAll(); //JPADBtools.selectEditori();
		model.addAttribute("editori", editori);
		//request.getSession().setAttribute("catalogoEditori", editori);
		//request.getSession().getAttribute("utente");
//		request.getSession().setAttribute("userBean", utente);
//		System.out.println(utente.getNome());
		return "visualizza_libri";
	}
	
	@RequestMapping(value = "/visualizza_autori", method = RequestMethod.GET)
	public String visualizzaAutori(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual autori get...");
		
		List<Autore> autori = autoreService.findAll(); // JPADBtools.selectAutori();
		model.addAttribute("autori", autori);
		//request.getSession().setAttribute("catalogoAutori", autori);
		
		return "visualizza_autori";
	}
	
	@RequestMapping(value = "/visualizza_editori", method = RequestMethod.GET)
	public String visualizzaEditori(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual editori get...");
		
		List<Editore> editori = editoreService.findAll(); //JPADBtools.selectEditori();
		model.addAttribute("editori", editori);
		//request.getSession().setAttribute("catalogoEditori", editori);
		
		return "visualizza_editori";
	}

	@RequestMapping(value = "/visualizza_utenti", method = RequestMethod.GET)
	public String visualizzaUtenti(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual editori get...");
		
		List<Utente> utenti = utenteService.findAll(); //JPADBtools.selectEditori();
		model.addAttribute("utenti", utenti);
		//request.getSession().setAttribute("catalogoEditori", editori);
		
		return "visualizza_utenti";
	}
	@RequestMapping(value = "/visualizza_prestiti", method = RequestMethod.GET)
	public String visualizzaPrestiti(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual editori get...");
		
		List<Prestito> prestiti = prestitoService.findAll(); //JPADBtools.selectEditori();
		model.addAttribute("prestiti", prestiti);
		//request.getSession().setAttribute("catalogoEditori", editori);
		
		List<Libro> libri = libroService.findAll(); // JPADBtools.selectLibri();
		model.addAttribute("libri", libri);
		List<Utente> utenti = utenteService.findAll(); //JPADBtools.selectEditori();
		model.addAttribute("utenti", utenti);
		
		return "visualizza_prestiti";
	}

//	@RequestMapping(value = "/visualizza_prestitiUtente", method = RequestMethod.GET)
//	public String visualizzaPrestitiUtente(HttpServletRequest request, HttpServletResponse response, Model model) {
//		System.out.println("visual editori get...");
//		
//		List<Prestito> prestitiUtente = prestitoService.findByIdUtente(((Utente)request.getSession().getAttribute("utente")).getId()); //JPADBtools.selectEditori();
//		model.addAttribute("prestitiUtente", prestitiUtente);
//		//request.getSession().setAttribute("catalogoEditori", editori);
//		
//		List<Libro> libri = libroService.findAll(); // JPADBtools.selectLibri();
//		model.addAttribute("libri", libri);
//		
//		return "visualizza_prestitiUtente";
//	}
	
}
