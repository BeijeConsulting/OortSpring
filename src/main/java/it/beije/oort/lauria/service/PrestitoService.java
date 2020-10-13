package it.beije.oort.lauria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.lauria.biblioteca.Prestito;
import it.beije.oort.lauria.repository.PrestitoRepository;

@Service
public class PrestitoService {
	
	@Autowired
	private PrestitoRepository prestitoRepository;
	
	public List<Prestito> findAll(){
		
		List<Prestito> prestiti = prestitoRepository.findByIdGreaterThan(0);
		
		return prestiti;
		
	}
	
//	public List<Prestito> findByIdUtente(Integer idUtente){
//		
//		List<Prestito> prestitiUtente = prestitoRepository.findByIdUtente(idUtente);
//		
//		return prestitiUtente;
//		
//	}

}
