package it.beije.oort.sala.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.beans.Editore;
import it.beije.oort.sala.controller.repositories.EditoreRepository;

@Service
public class EditoreService {

    @Autowired
	private EditoreRepository editoreRepository;

	public Editore get(Integer id) {
		Optional<Editore> o =editoreRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}

	public List<Editore> getAll() {
		return editoreRepository.findAll();
	}

	@Transactional
	public void insert(Editore e) {
		if(e!=null && isValid(e)) {
			editoreRepository.save(e);
		}
	}

	@Transactional
	public void delete(Integer id) {
		editoreRepository.deleteById(id);
	}

	@Transactional
	public void update(String field, String value, Integer id) {	
		Editore old = get(id);
		if(old!=null) {
			setField(old, field, value);
			editoreRepository.save(old);
		} else {
			throw new IllegalArgumentException("Non è presente un prestito con id: " + id);
		}
	}

	private boolean isValid(Editore e) {
		boolean valid = false;
		if(e.getDenominazione()!=null && !(e.getDenominazione().equals(""))) {
			valid=true;
		}
		return valid;
	}

	public void setField(Editore p, String field, String value) {
		switch(field) {
		case "denominazione":
			p.setDenominazione(value);
			break;
		case "descrizione":
			p.setDescrizione(value);
			break;
		}
	}
}
