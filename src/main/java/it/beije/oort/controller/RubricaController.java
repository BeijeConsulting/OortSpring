package it.beije.oort.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.oort.entity.ContattoSpring;
import it.beije.oort.service.CancellaCont;
import it.beije.oort.service.InserimentoCont;
import it.beije.oort.service.ModificaCont;
import it.beije.oort.service.VisualizzaCont;



@Controller
public class RubricaController {
	
	@Autowired 
	private VisualizzaCont visualizzacont;
	
	@Autowired
	private InserimentoCont insertcont;
	
	@Autowired
	private CancellaCont cancelcont;
	
	
	@RequestMapping(value = "/conf", method = RequestMethod.GET)
	public String conferma() {
		System.out.println("ESEGUITO..");
		
		return "conferma";
	}
	
	@RequestMapping(value = "/h", method = RequestMethod.GET)
	public String home() {
		System.out.println("home...");
		
		return "home";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showTo() {
		System.out.println("form visualizza...");
		
		return "showcontatto";
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delTo() {
		System.out.println("form cancellazione...");
		
		return "deletecontatto";
	}
	
	@RequestMapping(value = "/ins", method = RequestMethod.GET)
	public String insTo() {
		System.out.println("form inserimento...");
		
		return "inscontatto";
	}
		
	@RequestMapping(value = "/showall", method = RequestMethod.POST)
	public String visual(Model model) {
		model.addAttribute("showall", visualizzacont.showall());
		return "showall";
		
	} 
		
		
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String cancel(@RequestParam Integer id,  HttpServletRequest request, HttpServletResponse response) throws IOException {
		cancelcont.cancella(id, request, response);
		return "conferma";
	}

	
	@RequestMapping(value = "/ins", method = RequestMethod.POST)
	public String inserisci(ContattoSpring contatto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		insertcont.insert(contatto);
		return "conferma";
		}
	
	
}
