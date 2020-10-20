package it.beije.oort.bassanelli.library_application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.bassanelli.library_application.entity.Publisher;
import it.beije.oort.bassanelli.library_application.service.PublisherService;

@Controller
class PublisherController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PublisherService publisherService;
	
	private static final String root = "/library";
	
	@RequestMapping(value = root + "/publisher/{id}", method = RequestMethod.GET)
	public String publisher(@PathVariable Integer id, Model model) {
		
		Publisher publisher = publisherService.load(id);
		
		model.addAttribute("publisher", publisher);
		
		return root + "/entity/publisher";
	}
}
