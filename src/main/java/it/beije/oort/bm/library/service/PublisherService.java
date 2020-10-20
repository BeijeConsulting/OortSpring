package it.beije.oort.bm.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

	public Publisher addPublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}

	public Publisher updatePublisher(int id, Publisher publisher) {
		Optional<Publisher> optSaved = publisherRepo.findById(id);
		Publisher saved = null;
		if(optSaved.isPresent()) {
			saved = optSaved.get();
			BeanUtils.copyProperties(publisher, saved);
			publisherRepo.save(saved);
		}
		return saved;
	}

	public boolean deletePublisher(int id) {
		boolean ret = false;
		if(publisherRepo.findById(id).isPresent()) {
			publisherRepo.deleteById(id);
			ret = true;
		}
		return ret;
	}
}
