package it.beije.oort.bm.library.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibraryHomeController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping( value = "/", method = RequestMethod.GET)
	public String home() {
		log.debug("/ : get");
		return "home";
	}
}
