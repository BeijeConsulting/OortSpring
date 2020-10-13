//package it.beije.oort.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import it.beije.oort.entity.Utente;
//import it.beije.oort.repository.UtenteRepository;
//import it.beije.oort.sb.biblioteca.Utenti;
//
//
//@Service
//public class UtenteService {
//	
//	@Autowired
//	private UtenteRepository utenteRepository;
//
//	public String getNominativo(Utente utente) {
//	
//		if (utente == null)
//			throw new IllegalArgumentException();
//		
//		return utente.getCognome() + " " + utente.getNome();
//	}
//	
//	public Utente load(Integer id) {
//		
//		Optional<Utente> utente = utenteRepository.findById(id);
//		
//		return utente.isPresent() ? utente.get() : null;
//		
//	}
//	
//	public List<Utenti> findByNome(String nome) {
//		
//		List<Utenti> utenti = utenteRepository.findByNome(nome);
//		
//		return utenti;
//		
//	}
//	
//}
