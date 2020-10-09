package it.beije.oort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CatalogoController {

	@RequestMapping(value = "/CatalogoAutori", method = RequestMethod.GET)
	public String catalogoAutori() {				
		return "autori";
	}

}
