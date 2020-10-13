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
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.service.CancellaCont;

@Controller
public class CancelController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CancellaCont cancelcont;
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delTo() {
		log.debug("FORM CANCELLAZIONE...");
		
		return "deletecontatto";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String cancel(@RequestParam Integer id,  HttpServletRequest request, HttpServletResponse response) throws IOException {
		cancelcont.cancella(id, request, response);
		log.debug("ESEGUO CANCELLAZIONE CONTATTO TRAMITE ID..");
		return "conferma";
	}

}
