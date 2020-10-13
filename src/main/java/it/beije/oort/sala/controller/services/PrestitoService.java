package it.beije.oort.sala.controller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.beans.Prestito;
import it.beije.oort.sala.beans.Utente;
import it.beije.oort.sala.controller.repositories.PrestitoRepository;

@Service
public class PrestitoService {

	@Autowired
	private PrestitoRepository prestitoRepository;
	
	@Transactional
	public void insert(Prestito p) {
		if(p!=null && isValid(p)) {
			prestitoRepository.save(p);
		}
	}
	
	private boolean isValid(Prestito p) {
		boolean valid = false;
		if(p.getDataInizio()!=null && p.getIdLibro()!=null && p.getIdUtente()!=null) {
			valid=true;
		}
		return valid;
	}
}
