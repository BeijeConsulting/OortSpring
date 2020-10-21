package it.beije.oort.kirolosmater.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.kirolosmater.biblioteca.model.Prestito;
import it.beije.oort.kirolosmater.biblioteca.repository.PrestitoRepository;

@Service
public class PrestitoService {

	@Autowired
	private PrestitoRepository prestitoRepository;
	
	public Prestito load(Integer id) {
		
		Optional<Prestito> prestito = prestitoRepository.findById(id);
		
		return prestito.isPresent() ? prestito.get() : null;
		
	}
}
