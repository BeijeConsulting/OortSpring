package it.beije.oort.bm.library.service;

import java.util.List;
import java.util.Optional;
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

	public Publisher getPublisher(int id) {
		Optional<Publisher> data = publisherRepo.findById(id);
		Publisher ret = data.isPresent() ? data.get() : null;
		return ret;
	}
}
