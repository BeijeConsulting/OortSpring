package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.entity.Utente;
import it.beije.oort.repository.UtenteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UtenteService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	
	public boolean isThereUtenteSession (HttpServletRequest request) {
		Utente utenteSession = (Utente)request.getSession().getAttribute("utente");
		return (utenteSession != null);
	}
	
	public String getNominativo(Utente utente) {
		if (utente == null)
			throw new IllegalArgumentException();
		return utente.getCognome() + " " + utente.getNome();
	}
	
	
	public Utente load(Integer id) {
		Optional<Utente> utente = utenteRepository.findById(id);
		return utente.isPresent() ? utente.get() : null;
	}
	
	public List<Utente> findByNome(String nome) {
		List<Utente> utenti = utenteRepository.findByNome(nome);
		return utenti;
	}
	
	public Optional<Utente> findByEmail(String email) {
		Optional<Utente> utente = utenteRepository.findByEmail(email);
		return utente;
	}
	
	public Optional<Utente> findByEmailAndPassword(String email, String password) {
		Optional<Utente> utente = utenteRepository.findByEmailAndPassword(email, password);
		return utente;
	}
	
	
	//@Transactional
	public void insert(Utente utente) {
		if (utente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		if (!"".equals(utente.getCognome()) || !"".equals(utente.getNome()) ||
			!"".equals(utente.getEmail()) || !"".equals(utente.getPassword())) {
	
			utenteRepository.save(utente);
			log.info("utente inserito!");
		} else throw new IllegalArgumentException("dati utente non presenti");
	}
	
	
	@Transactional
	public void update(Integer id, Utente datiUtente) {
		if (datiUtente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		if (!"".equals(datiUtente.getCognome()) || !"".equals(datiUtente.getNome()) ||
			!"".equals(datiUtente.getEmail()) || !"".equals(datiUtente.getTelefono())) {
			
			Utente utente = load(id);
			
			if (utente == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			//update
			BeanUtils.copyProperties(datiUtente, utente, "id");
			utenteRepository.save(datiUtente);
			
		} else throw new IllegalArgumentException("dati utente non presenti");
	}
}
