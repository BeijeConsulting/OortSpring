package it.beije.oort.sala.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sala.controller.beans.*;

@Controller
public class PrestitiController {
	
	@RequestMapping(value = "/prestiti/{s}", method = RequestMethod.POST)
	public String prestiti(Prestito p) {
		return "prestiti";
		}
	}
