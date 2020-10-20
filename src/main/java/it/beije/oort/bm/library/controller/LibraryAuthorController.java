package it.beije.oort.bm.library.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.bm.library.entity.Author;
import it.beije.oort.bm.library.service.AuthorService;

@RestController
@RequestMapping("/author")
public class LibraryAuthorController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping(value = "/all")
	public List<Author> getAll(){
		log.debug("/author/all : get");
		return authorService.getAll();
	}
	
	@GetMapping(value = "/get/{id}")
	public Author get(@PathVariable int id){
		log.debug("/author/get/{if} : get : id := " + id);
		return authorService.getAuthor(id);
	}
	
	@PostMapping( value = "/insert")
	public Author insert(@RequestBody Author author) {
		log.debug("/author/insert : post : Object := " + author);
		authorService.addAuthor(author);
		return author;
	}
	
	@PutMapping( value = "/update/{id}")
	public Author update(@RequestBody Author author, @PathVariable int id){
		log.debug("/author/upgrade/{if} : get : id := " + id + " : Object := " + author);
		author.setId(id);
		return authorService.updateAuthor(id, author);
	}
	@DeleteMapping( value = "/delete/{id}")
	public boolean delete(@PathVariable int id) {
		log.debug("/author/delete - post - id: " + id);
		return authorService.deleteAuthor(id);
	}
	
}
