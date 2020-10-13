package it.beije.oort.bm.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.bm.library.entity.Publisher;
import it.beije.oort.bm.library.repository.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository publisherRepo;

	public List<Publisher> getAll(){
		return publisherRepo.findAll();
	}
}
