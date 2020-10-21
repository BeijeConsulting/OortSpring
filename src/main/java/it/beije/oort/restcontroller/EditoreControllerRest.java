package it.beije.oort.restcontroller;

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

import it.beije.oort.sb.biblioteca.Editori;
import it.beije.oort.service.EditoriService;

@RestController
@RequestMapping("/api")
public class EditoreControllerRest {
	
	@Autowired
	private EditoriService editoriService;
	
	@GetMapping("/editore")
	public List<Editori> editore() {	
		return editoriService.loadEditori();
	}
	
	@PostMapping("/editore")
	public Editori editore(@RequestBody Editori editore) {
		System.out.println("ricevendo dati autore");
		editoriService.insert(editore);
		return editore;	
	}
	
	@PutMapping("/editore/{id}")
	public Editori editore(@RequestBody Editori editore, @PathVariable Integer id) {
		System.out.println("ricevo dati autore..." + editore);
		
		return editoriService.update(id, editore);
	}
	
	@DeleteMapping("/editore/{id}")
	public String editore(@PathVariable Integer id) {
		return editoriService.deleteById(id);
	}

}
