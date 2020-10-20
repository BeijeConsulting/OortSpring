package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.UtenteRepository;
import it.beije.oort.repository.UtentiRepository;
import it.beije.oort.sb.biblioteca.Utenti;

@Service
public class UtentiService {

	@Autowired
	private UtentiRepository utentiRepository;
	
	public List<Utenti> loadUtenti(){
		return utentiRepository.findAll();
	}
	
	public Utenti loadById(Integer id) {
		Optional<Utenti> utente = utentiRepository.findById(id);
		return utente.isPresent() ? utente.get() : null;
	}
	
	public Utenti check(String email, String password) {
		Optional<Utenti> utente = utentiRepository.findByEmailAndPassword(email, password);
		return utente.isPresent() ? utente.get() : null;
	}
	
	public boolean insert(Utenti utente) {
		try{
			utentiRepository.saveAndFlush(utente);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
//	@Transactional
	public Utenti update(Integer id, Utenti datiUtente) {
		
		if (datiUtente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(datiUtente.getCognome()) || !"".equals(datiUtente.getNome()) ||
			!"".equals(datiUtente.getEmail()) || !"".equals(datiUtente.getTelefono())) {
			
			Utenti utente = loadById(id);
			
			if (utente == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			
			BeanUtils.copyProperties(datiUtente, utente, "id");
			
			utentiRepository.save(utente);
			
			return utente;
			
		} else throw new IllegalArgumentException("dati utente non presenti");
		
	}
	
	public String deleteById(Integer id) {
		Utenti utente = loadById(id);
		if(utente!= null) {
			utentiRepository.delete(utente);
			return "Utente cancellato correttamente";
		} else throw new IllegalArgumentException("NESSUN UTENTE CON ID " + id);
				
	}
}
