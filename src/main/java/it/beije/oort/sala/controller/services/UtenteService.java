package it.beije.oort.sala.controller.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.controller.beans.Libro;
import it.beije.oort.sala.controller.beans.Prestito;
import it.beije.oort.sala.controller.beans.PrestitoTransport;
import it.beije.oort.sala.controller.beans.Utente;
import it.beije.oort.sala.controller.repositories.UtenteRepository;
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
	
	@Transactional
	public void insert(Utente utente) {
		if(utente!=null && isValid(utente)) {
			utenteRepository.save(utente);
		}
	}
	
	@Transactional
	public void update(Utente utente, Integer id) {
		if(utente!=null) {
			
			Utente old = get(id);
			if(old!=null) {
				BeanUtils.copyProperties(utente, old, "id");
				utenteRepository.save(old);
			} else {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			
		} else {
			throw new IllegalArgumentException("nuovo utente non pervenuto");
		}
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
}
