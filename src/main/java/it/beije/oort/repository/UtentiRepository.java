package it.beije.oort.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sb.biblioteca.Utenti;
@Repository
public interface UtentiRepository  extends JpaRepository<Utenti, Integer>{
		
		//IM : count u from User u where email = ?
		Optional<Utenti> findByEmail(String email);

		List<Utenti> findByNome(String nome);
		Optional<Utenti> findByEmailAndPassword(String email, String password);
		//Optional<Utente> findByEmailAndPassword(String email, String password);
		
	}


