package it.beije.oort.sala.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.beans.Autore;
import it.beije.oort.sala.controller.repositories.AutoreRepository;

@Service
public class AutoreService {
	@Autowired 
	private AutoreRepository autoreRepository;

	public Autore get(Integer id) {
		Optional<Autore> o =autoreRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}

	public List<Autore> getAll() {
		return autoreRepository.findAll();
	}

	@Transactional
	public void insert(Autore a) {
		if(a!=null && isValid(a)) {
			autoreRepository.save(a);
		}
	}

	@Transactional
	public void delete(Integer id) {
		autoreRepository.deleteById(id);
	}

	@Transactional
	public void update(String field, String value, Integer id) {	
		Autore old = get(id);
		if(old!=null) {
			setField(old, field, value);
			autoreRepository.save(old);
		} else {
			throw new IllegalArgumentException("Non è presente un prestito con id: " + id);
		}
	}

	private boolean isValid(Autore a) {
		boolean valid = false;
		if(a.getNome()!=null && !(a.getNome().equals("")) && a.getCognome()!=null && !(a.getCognome().equals(""))) {
			valid=true;
		}
		return valid;
	}

	public void setField(Autore p, String field, String value) {
		switch(field) {
		case "nome":
			p.setNome(value);
			break;
		case "cognome":
			p.setCognome(value);
			break;
		case "dataNascita":
			p.setDataNascita(value);
			break;
		case "dataMorte":
			p.setDataMorte(value);
			break;
		case "biografia":
			p.setBiografia(value);
			break;
		}
	}
}