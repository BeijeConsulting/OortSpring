package it.beije.oort.sala.controller.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.sala.controller.beans.Utente;
import it.beije.oort.sala.controller.repositories.UtenteRepository;

@Service
public class LoginService {

	@Autowired
	private UtenteRepository utenteRepository;
	
//	public Utente checkLogin(String email, String password) {
//		List<Object> temp = JPAToolset.selectJPA(email, password);
//		if(temp.size()==1) {
//			return (Utente)temp.get(0);
//		}
//		return null;
//	}
	
	public Utente checkLogin(String email, String password) {
		Optional<Utente> o = utenteRepository.findByEmailAndPassword(email, password);
		
		return o.isPresent() ? o.get() : null;
	}
}
