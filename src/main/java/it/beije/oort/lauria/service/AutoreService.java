package it.beije.oort.lauria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
	public List<Autore> findAll(){
		
		List<Autore> autori = autoreRepository.findByIdGreaterThan(0);
		
		return autori;
		
	}
}
