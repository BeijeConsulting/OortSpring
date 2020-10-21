package it.beije.oort.sala.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.sala.beans.Libro;
import it.beije.oort.sala.controller.services.LibroService;

@RestController
@RequestMapping(value="/api")
public class LibroApiController {

		@Autowired
		private LibroService libroService;
		
		@RequestMapping(value = "/libri", method = RequestMethod.GET)
		public List<Libro> libri(){
			List<Libro> utenti = libroService.getAll();
			return utenti;	
		}
		
		@RequestMapping(value="/libro/{id}", method = RequestMethod.GET)
		public Libro libro(@PathVariable Integer id) {
			return libroService.get(id);
		}
		
		@PostMapping("/libro")
		public Libro libro(@RequestBody Libro libro) {
			return libroService.insert(libro);
		}
		
		@PutMapping("/libro/{id}")
		public Libro libro(@RequestBody Libro libro,@PathVariable Integer id) {
			if(id==null) throw new IllegalArgumentException();
			return libroService.update(libro, id);
		}
}
