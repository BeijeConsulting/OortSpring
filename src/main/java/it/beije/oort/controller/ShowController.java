package it.beije.oort.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.service.VisualizzaCont;

@Controller
public class ShowController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private VisualizzaCont visualizzacont;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showTo() {
		log.debug("FORM VISUALIZZAZIONE...");
		
		return "showcontatto";
	}

	@RequestMapping(value = "/showall", method = RequestMethod.POST)
	public String visual(Model model) {
		model.addAttribute("showall", visualizzacont.showall());
		log.debug("ESEGUO VISUALIZZAZIONE DI TUTTI CONTATTI..");
		return "showall";
	} 
}
