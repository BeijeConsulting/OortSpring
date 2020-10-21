package it.beije.oort.kirolosmater.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.kirolosmater.biblioteca.model.Editore;
import it.beije.oort.kirolosmater.biblioteca.repository.EditoreRepository;

@Service
public class EditoreService {

	@Autowired
	private EditoreRepository editoreRepository;
	
	public Editore load(Integer id) {
		
		Optional<Editore> editore = editoreRepository.findById(id);
		
		return editore.isPresent() ? editore.get() : null;
		
	}
}
