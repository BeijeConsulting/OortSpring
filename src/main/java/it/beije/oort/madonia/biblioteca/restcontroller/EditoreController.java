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

import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.service.EditoreService;

@RestController
@RequestMapping(value = "/api")
public class EditoreController {

	@Autowired
	private EditoreService editoreService;
	
	@GetMapping("/editori")
	public List<Editore> getEditori() {
		return editoreService.trovaTutti();
	}
	
	@GetMapping("/editore/{id}")
	public Editore getEditore(@PathVariable Integer id) {
		return editoreService.trova(id);
	}
	
	@PostMapping("/editore")
	public Editore postEditore(@RequestBody Editore editore) {
		return editoreService.inserisci(editore);
	}
	
	@PutMapping("/editore/{id}")
	public Editore putEditore(@PathVariable Integer id, @RequestBody Editore editore) {
		return editoreService.modifica(id, editore);
	}
	
	@DeleteMapping("/editore/{id}")
	public void deleteEditore(@PathVariable Integer id) {
		editoreService.cancella(id);
	}
}
