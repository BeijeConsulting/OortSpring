package it.beije.oort.sala.controller.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.sala.controller.beans.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	Optional<Utente> findByEmailAndPassword(String email, String password);
	
//	List<Utente> findByNomeLike(String nome);
//	List<Utente> findByCognomeLike(String cognome);
//	List<Utente> findByEmailLike(String email);
	
}
