package it.beije.oort.gregori.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.gregori.biblioteca.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer>{

	Optional<Utente> findByEmailAndPassword(String email, String password);
	List<Utente> findAll();
	
	Optional<Utente> findByEmail(String email);
	
}
