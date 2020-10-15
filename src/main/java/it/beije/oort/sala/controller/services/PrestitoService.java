package it.beije.oort.sala.controller.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.beans.Prestito;
import it.beije.oort.sala.controller.repositories.PrestitoRepository;

@Service
public class PrestitoService {

	@Autowired
	private PrestitoRepository prestitoRepository;
	
	public Prestito get(Integer id) {
		Optional<Prestito> o = prestitoRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}
	
	@Transactional
	public void insert(Prestito p) {
		if(p!=null && isValid(p)) {
			prestitoRepository.save(p);
		}
	}
	
	@Transactional
	public void delete(Integer id) {
		prestitoRepository.deleteById(id);
	}
	
	@Transactional
	public void update(String field, String value, Integer id) {	
		Prestito old = get(id);
		if(old!=null) {
			setField(old, field, value);
			prestitoRepository.save(old);
		} else {
			throw new IllegalArgumentException("Non è presente un prestito con id: " + id);
		}
	}

	private boolean isValid(Prestito p) {
		boolean valid = false;
		if(p.getDataInizio()!=null && p.getIdLibro()!=null && p.getIdUtente()!=null) {
			valid=true;
		}
		return valid;
	}
	
	public void setField(Prestito p, String field, String value) {
		switch(field) {
		case "idUtente":
			p.setIdUtente(Integer.parseInt(value));
			break;
		case "idLibro":
			p.setIdLibro(Integer.parseInt(value));
			break;
		case "dataInizio":
			p.setDataInizio(value);
			break;
		case "dataFine":
			p.setDataFine(value);
			break;
		case "note":
			p.setNote(value);
			break;
		}
	} 
}