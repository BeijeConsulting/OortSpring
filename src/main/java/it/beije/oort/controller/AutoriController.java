package it.beije.oort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.sb.biblioteca.Autori;
import it.beije.oort.service.AutoriService;

@Controller
public class AutoriController {

	@Autowired
	private AutoriService autoriService;
	
	@RequestMapping(value = "/catalogoautori", method = RequestMethod.GET)
	public String catalogoAutori(Model model) {	
		model.addAttribute("autori", autoriService.loadAutori());
		return "autori";
	}
	
	@RequestMapping(value="/deleteautore", method= RequestMethod.GET)
	public String deleteAutoreG(){
		return "deleteautore";
	}
	
	@RequestMapping(value="/deleteautore", method= RequestMethod.POST)
	public String deleteAutoreP(@RequestParam String id, Model model){
		try {
			int indice = Integer.parseInt(id);
			autoriService.deleteById(indice);
			model.addAttribute("messaggio", "Record Autore Cancellato Correttamente");
		} catch(NumberFormatException e) {
			model.addAttribute("messaggio", "Valore Id Autore Errato");
			return "deleteautore";
		} catch(Exception e) {
			model.addAttribute("messaggio", "Impossibile Cancellare Record Autore");
		}	
		return "menubiblioteca";
	}
	
	@RequestMapping(value="/newautore", method= RequestMethod.GET)
	public String newAutoreG(){
		return "newautore";
	}
	
	@RequestMapping(value="/newautore", method= RequestMethod.POST)
	public String newAutoreP(Autori autore, Model model, @RequestParam String dataDiNascita, @RequestParam String dataDiMorte){
		model.addAttribute("messaggio", autoriService.insert(dataDiNascita, dataDiMorte, autore));
		return "menubiblioteca";
	}
}
