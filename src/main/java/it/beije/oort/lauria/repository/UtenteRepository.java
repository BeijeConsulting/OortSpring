package it.beije.oort.lauria.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.lauria.biblioteca.Utente;


@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	//IM : count u from User u where email = ?
	Optional<Utente> findByEmail(String email);
	
	Optional<Utente> findByPassword(String password);
	
	List<Utente> findByNome(String nome);
	
	Optional<Utente> findByEmailAndPassword(String email, String password);
	
}


