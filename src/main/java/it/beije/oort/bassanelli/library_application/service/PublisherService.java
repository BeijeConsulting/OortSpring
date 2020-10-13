package it.beije.oort.bassanelli.library_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.entity.Publisher;
import it.beije.oort.bassanelli.library_application.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}
	
}
