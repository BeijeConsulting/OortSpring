package it.beije.oort.bassanelli.library_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.entity.Publisher;
import it.beije.oort.bassanelli.library_application.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	public Publisher load(Integer id) {
		
		Optional<Publisher> publisher = publisherRepository.findById(id);
		
		return publisher.isPresent() ? publisher.get() : null;
	}
	
	public List<Publisher> getAllPublishers() {
		return publisherRepository.findAll();
	}
	
	public String getPublisherName(Integer id) {
		
		Optional<Publisher> publisher = publisherRepository.findById(id);
		
		return publisher.isPresent() ? publisher.get().getName() : null;
		
	}
	
}
