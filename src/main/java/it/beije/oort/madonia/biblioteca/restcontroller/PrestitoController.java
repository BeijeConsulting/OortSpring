package it.beije.oort.madonia.biblioteca.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.service.PrestitoService;

@RestController
@RequestMapping(value = "/api")
public class PrestitoController {
	
	@Autowired
	private PrestitoService prestitoService;
	
	@GetMapping("/prestiti/utente/{id}")
	public List<Prestito> getPrestitiUtente(@PathVariable Integer id) {
		return prestitoService.trovaPerIdUtente(id);
	}
	
	@GetMapping("/prestito/{id}")
	public Prestito getPrestito(@PathVariable Integer id) {
		return prestitoService.trova(id);
	}
	
	@PostMapping("/prestito")
	public Prestito postPrestito(@RequestBody Prestito prestito) {
		return prestitoService.inserisci(prestito);
	}
	
	@PutMapping("/prestito/{id}")
	public Prestito putPrestito(@PathVariable Integer id, @RequestBody Prestito prestito) {
		return prestitoService.modifica(id, prestito);
	}
	
	@DeleteMapping("/prestito/{id}")
	public void deletePrestito(@PathVariable Integer id) {
		prestitoService.cancella(id);
	}
	
}
