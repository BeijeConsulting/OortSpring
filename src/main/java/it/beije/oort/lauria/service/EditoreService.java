package it.beije.oort.lauria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.lauria.biblioteca.Editore;
import it.beije.oort.lauria.repository.EditoreRepository;

@Service
public class EditoreService {


	@Autowired
	private EditoreRepository editoreRepository;
	
	public List<Editore> findAll(){
		
		List<Editore> ditore = editoreRepository.findByIdGreaterThan(0);
		
		return ditore;
		
	}
}
