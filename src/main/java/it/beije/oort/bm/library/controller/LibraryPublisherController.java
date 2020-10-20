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

import it.beije.oort.bm.library.entity.Publisher;
import it.beije.oort.bm.library.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class LibraryPublisherController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping(value = "/all")
	public List<Publisher> getAll(){
		log.debug("/publisher/all : get");
		return publisherService.getAll();
	}
	
	@GetMapping(value = "/get/{id}")
	public Publisher get(@PathVariable int id){
		log.debug("/publisher/get/{if} : get : id := " + id);
		return publisherService.getPublisher(id);
	}
	
	@PostMapping( value = "/insert")
	public Publisher insert(@RequestBody Publisher publisher) {
		log.debug("/publisher/insert : post : Object := " + publisher);
		publisherService.addPublisher(publisher);
		return publisher;
	}
	
	@PutMapping( value = "/update/{id}")
	public Publisher update(@RequestBody Publisher publisher, @PathVariable int id){
		log.debug("/publisher/upgrade/{if} : get : id := " + id + " : Object := " + publisher);
		publisher.setId(id);
		return publisherService.updatePublisher(id, publisher);
	}
	@DeleteMapping( value = "/delete/{id}")
	public boolean delete(@PathVariable int id) {
		log.debug("/publisher/delete - post - id: " + id);
		return publisherService.deletePublisher(id);
	}
	
}
