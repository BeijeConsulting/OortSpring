package it.beije.oort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.service.AutoriService;

@Controller
public class AutoriController {

	@Autowired
	private AutoriService autoriService;
	
	@RequestMapping(value = "/CatalogoAutori", method = RequestMethod.GET)
	public String catalogoAutori(Model model) {	
		model.addAttribute("autori", autoriService.loadAutori());
		return "autori";
	}
}
