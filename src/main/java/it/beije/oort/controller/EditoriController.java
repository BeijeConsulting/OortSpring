package it.beije.oort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sb.jpa.JPDBtools;
import it.beije.oort.service.EditoriService;

@Controller
public class EditoriController {
	
	@Autowired
	private EditoriService editoriService;
	
	@RequestMapping(value = "/catalogoeditori", method = RequestMethod.GET)
	public String catalogoEditori(Model model) {	
		model.addAttribute("editori", editoriService.loadEditori());
		return "editori";
	}


}
