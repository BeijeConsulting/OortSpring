package it.beije.oort.controller;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RubricaController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
		
	@RequestMapping(value = "/conf", method = RequestMethod.GET)
	public String conferma() {
		log.info("ESEGUO..");
		return "conferma";
	}
	
	@RequestMapping(value = "/h", method = RequestMethod.GET)
	public String home() {
		log.debug("HOME...");
		return "home";
	}
}
