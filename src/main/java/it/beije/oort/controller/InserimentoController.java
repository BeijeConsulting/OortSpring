package it.beije.oort.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.service.InserimentoCont;

@Controller
public class InserimentoController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InserimentoCont insertcont;
	
	@RequestMapping(value = "/ins", method = RequestMethod.GET)
	public String insTo() {
		log.debug("FORM INSERIMENTO...");
		return "inscontatto";
	}
	
	@RequestMapping(value = "/ins", method = RequestMethod.POST)
	public String inserisci(ContattoSpring contatto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		insertcont.insert(contatto);
		log.debug("ESEGUO INSERIMENTO NUOVO CONTATTO..");
		return "conferma";
		}

}
