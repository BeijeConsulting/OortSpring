package it.beije.oort.sala.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sala.beans.*;
import it.beije.oort.sala.controller.services.*;


@Controller
public class OperationController {
	
	@Autowired
	private PrestitoService prestitoService;
	@Autowired
	private LibroService libroService;
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private EditoreService editoreService;
	
	@RequestMapping(value = "/prestiti/{op}", method = RequestMethod.POST)
	public String prestiti(@PathVariable String op, Prestito p, HttpServletRequest request) {
		if(op.equals("insert")) {
			prestitoService.insert(p);
		} else if(op.equals("delete")) {
			prestitoService.delete(p.getIdPrestito());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("idPrestito"));

			if(field!=null && newValue!=null && id!=null) prestitoService.update(field, newValue, id);
			else throw new IllegalArgumentException();
		}
		return "biblioteca/sub-admin/prestiti";
	}
	
	@RequestMapping(value = "/libri/{op}", method = RequestMethod.POST)
	public String libri(@PathVariable String op, Libro l, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			libroService.insert(l);
		} else if(op.equals("delete")) {
			libroService.delete(l.getIdLibro());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
			
			if(field!=null && newValue!=null && id!=null) libroService.update(field, newValue, id);
			else throw new IllegalArgumentException();
			
		} else if(op.equals("select")) {
			model.addAttribute("libri", libroService.getAll());
		}
		return "biblioteca/sub-admin/libri";
	}
	
	@RequestMapping(value = "/utenti/{op}", method = RequestMethod.POST)
	public String utenti(@PathVariable String op, Utente u, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			utenteService.insert(u);
		} else if(op.equals("delete")) {
			utenteService.delete(u.getIdUtente());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			if(field!=null && newValue!=null && id!=null) utenteService.update(field, newValue, id);
			else throw new IllegalArgumentException();

		} else if(op.equals("select")) {
			model.addAttribute("utenti", utenteService.getAll());
		}
		return "biblioteca/sub-admin/utenti";
	}
	
	@RequestMapping(value = "/editori/{op}", method = RequestMethod.POST)
	public String editori(@PathVariable String op, Editore e, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			editoreService.insert(e);
		} else if(op.equals("delete")) {
			editoreService.delete(e.getIdEditore());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
			
			if(field!=null && newValue!=null && id!=null) editoreService.update(field, newValue, id);
			else throw new IllegalArgumentException();

		} else if(op.equals("select")) {
			model.addAttribute("editori", editoreService.getAll());
		}
		return "biblioteca/sub-admin/editori";
	}
	
	@RequestMapping(value = "/autori/{op}", method = RequestMethod.POST)
	public String autori(@PathVariable String op, Autore a, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			autoreService.insert(a);
		} else if(op.equals("delete")) {
			autoreService.delete(a.getIdAutore());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			if(field!=null && newValue!=null && id!=null) autoreService.update(field, newValue, id);
			else throw new IllegalArgumentException();

		} else if(op.equals("select")) {
			model.addAttribute("autori", autoreService.getAll());
		}
		return "biblioteca/sub-admin/autori";
	}
}