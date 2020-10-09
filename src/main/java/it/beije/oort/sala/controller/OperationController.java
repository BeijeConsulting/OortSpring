package it.beije.oort.sala.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sala.controller.beans.*;
import it.beije.oort.sala.controller.db.JPAToolset;

@Controller
public class OperationController {
	
	@RequestMapping(value = "/prestiti/{op}", method = RequestMethod.POST)
	public String prestiti(@PathVariable String op, Prestito p, HttpServletRequest request) {
		if(op.equals("insert")) {
			JPAToolset.insertJPA(p);
		} else if(op.equals("delete")) {
			JPAToolset.deleteJPA("Prestito", p.getId_prestito());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			JPAToolset.updateJPA("Prestito", field, newValue, id);
		}
		return "sub-admin/prestiti";
	}
	
	@RequestMapping(value = "/libri/{op}", method = RequestMethod.POST)
	public String libri(@PathVariable String op, Libro l, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			JPAToolset.insertJPA(l);
		} else if(op.equals("delete")) {
			JPAToolset.deleteJPA("Libro", l.getId_libro());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			JPAToolset.updateJPA("Libro", field, newValue, id);
		} else if(op.equals("select")) {
			model.addAttribute("libri", JPAToolset.selectJPA("Libro"));
		}
		return "sub-admin/libri";
	}
	
	@RequestMapping(value = "/utenti/{op}", method = RequestMethod.POST)
	public String utenti(@PathVariable String op, Utente u, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			JPAToolset.insertJPA(u);
		} else if(op.equals("delete")) {
			JPAToolset.deleteJPA("Utente", u.getId_utente());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			JPAToolset.updateJPA("Utente", field, newValue, id);
		} else if(op.equals("select")) {
			model.addAttribute("utenti", JPAToolset.selectJPA("Utente"));
		}
		return "sub-admin/utenti";
	}
	
	@RequestMapping(value = "/editori/{op}", method = RequestMethod.POST)
	public String editori(@PathVariable String op, Editore e, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			JPAToolset.insertJPA(e);
		} else if(op.equals("delete")) {
			JPAToolset.deleteJPA("Editore", e.getId_editore());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			JPAToolset.updateJPA("Editore", field, newValue, id);
		} else if(op.equals("select")) {
			model.addAttribute("editori", JPAToolset.selectJPA("Editore"));
		}
		return "sub-admin/editori";
	}
	
	@RequestMapping(value = "/autori/{op}", method = RequestMethod.POST)
	public String autori(@PathVariable String op, Autore a, HttpServletRequest request, Model model) {
		if(op.equals("insert")) {
			JPAToolset.insertJPA(a);
		} else if(op.equals("delete")) {
			JPAToolset.deleteJPA("Prestito", a.getId_autore());
		} else if(op.equals("update")) {
			String newValue = request.getParameter("value");
			String field = request.getParameter("field");
			Integer id = new Integer(request.getParameter("id"));
					
			JPAToolset.updateJPA("Autore", field, newValue, id);
		} else if(op.equals("select")) {
			model.addAttribute("autori", JPAToolset.selectJPA("Autore"));
		}
		return "sub-admin/autori";
	}
}
