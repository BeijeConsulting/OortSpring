package it.beije.oort.sala.controller.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.controller.repositories.UtenteRepository;
import it.beije.oort.sala.beans.Libro;
import it.beije.oort.sala.beans.Prestito;
import it.beije.oort.sala.beans.PrestitoTransport;
import it.beije.oort.sala.beans.Utente;
import it.beije.oort.sala.controller.repositories.PrestitoRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;
	@Autowired
	private PrestitoRepository prestitoRepository;
	@Autowired
	private LibroService libroService;
	
	
	public Utente get(Integer id) {
		Optional<Utente> o = utenteRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}

	public List<Utente> getAll() {
		return utenteRepository.findAll();
	}
	
	@Transactional
	public Utente insert(Utente utente) {
		if(utente!=null && isValid(utente)) {
			utenteRepository.save(utente);
		}
		return utente;
	}

	@Transactional
	public void delete(Integer id) {
		utenteRepository.deleteById(id);
	}
	
	@Transactional
	public void update(String field, String value, Integer id) {
		Utente old = get(id);
		if(old!=null) {
			setField(old, field, value);
			utenteRepository.save(old);
		} else {
			throw new IllegalArgumentException("Non Ã¨ presente un utente con id: " + id);
		}
	}
	
	@Transactional
	public Utente update(Utente utente, Integer id) {
		
		if (utente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(utente.getCognome()) || !"".equals(utente.getNome()) ||
			!"".equals(utente.getEmail()) || !"".equals(utente.getTelefono())) {
			
			Utente old = get(id);
			
			if (old == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			
			BeanUtils.copyProperties(utente, old, "idUtente");
			
			utenteRepository.save(old);
			
			return old;
			
		} else throw new IllegalArgumentException("dati utente non presenti");
	}
	
	public List<PrestitoTransport> getPrestiti(Integer idUtente) {
		List<PrestitoTransport> ret = new ArrayList<>();
		for(Prestito p : prestitoRepository.findByIdUtente(idUtente)){
			Utente u = get(idUtente);
			Libro l = libroService.get(p.getIdLibro());
			ret.add(new PrestitoTransport(p, u, l));
		}
		return ret;
	}
	
	private boolean isValid(Utente u) {
		boolean valid = false;
		if(!"".equals(u.getNome()) || !"".equals(u.getCognome()) || !"".equals(u.getCodiceFiscale())) {
			valid=true;
		}
		return valid;
	}

	public void setField(Utente p, String field, String value) {
		switch(field) {
		case "nome":
			p.setNome(value);
			break;
		case "cognome":
			p.setCognome(value);
			break;
		case "codiceFiscale":
			p.setCodiceFiscale(value);
			break;
		case "email":
			p.setEmail(value);
			break;
		case "telefono":
			p.setTelefono(value);
			break;
		case "indirizzo":
			p.setIndirizzo(value);
			break;
		case "password":
			p.setPassword(value);
			break;
		case "admin":
			p.setAdmin(Boolean.parseBoolean(value));
			break;
		}
	} 
}
