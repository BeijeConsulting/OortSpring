package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.AutoriRepository;
import it.beije.oort.sb.biblioteca.Autori;


@Service
public class AutoriService {

	@Autowired
	private AutoriRepository autoriRepository;
	
	public List<Autori> loadAutori(){
		return autoriRepository.findAll();
	}
	
	public Autori loadById(Integer id) {
		Optional<Autori> autore = autoriRepository.findById(id);
		return autore.isPresent() ? autore.get() : null;
	}
}
