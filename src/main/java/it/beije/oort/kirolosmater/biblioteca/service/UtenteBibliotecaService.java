package it.beije.oort.kirolosmater.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.kirolosmater.biblioteca.model.UtenteBiblioteca;
import it.beije.oort.kirolosmater.biblioteca.repository.UtenteBibliotecaRepository;

@Service
public class UtenteBibliotecaService {

	@Autowired
	private UtenteBibliotecaRepository utenteBibliotecaRepository;
	
	public String getNominativo(UtenteBiblioteca utente) {
		
		if (utente == null)
			throw new IllegalArgumentException();
		
		return utente.getCognome() + " " + utente.getNome();
	}
	
	public UtenteBiblioteca load(Integer id) {
		
		Optional<UtenteBiblioteca> utente = utenteBibliotecaRepository.findById(id);
		
		return utente.isPresent() ? utente.get() : null;
		
	}
	
	public List<UtenteBiblioteca> findByNome(String nome) {
		
		List<UtenteBiblioteca> utenti = utenteBibliotecaRepository.findByNome(nome);
		
		return utenti;
		
	}
	
	//@Transactional
	public void insert(UtenteBiblioteca utente) {
		
		if (utente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(utente.getCognome()) || !"".equals(utente.getNome()) ||
			!"".equals(utente.getEmail()) || !"".equals(utente.getTelefono())) {
			
			utenteBibliotecaRepository.save(utente);
			
		} else throw new IllegalArgumentException("dati utente non presenti");
		
	}
	
	@Transactional
	public void update(Integer id, UtenteBiblioteca datiUtente) {
		
		if (datiUtente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(datiUtente.getCognome()) || !"".equals(datiUtente.getNome()) ||
			!"".equals(datiUtente.getEmail()) || !"".equals(datiUtente.getTelefono())) {
			
			UtenteBiblioteca utente = load(id);
			
			if (utente == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			
			BeanUtils.copyProperties(datiUtente, utente, "id");
			
			utenteBibliotecaRepository.save(utente);
			
		} else throw new IllegalArgumentException("dati utente non presenti");
		
	}
}
