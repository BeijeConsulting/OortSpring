package it.beije.oort.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.service.ModificaCont;

@Controller
public class ModificaController {
	

	@Autowired 
	private ModificaCont modcont;
	
	
	@RequestMapping(value = "/modifica", method = RequestMethod.GET)
	public String modTo(Model model, HttpServletRequest request) {
		model.addAttribute("id", request.getParameter("id"));
		System.out.println("form modifica...");
		return "modif";
	}

	
	@RequestMapping(value = "/modifica", method = RequestMethod.POST)
	public String update(@RequestParam Integer id ,ContattoSpring datiContatto) {
		System.out.println("update utente : "+ id);
		modcont.update(id, datiContatto);
		return "conferma";
	}
	
}
